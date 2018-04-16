package BrainFuckPP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Parser {
    private static final String validIns = "+-><,.[]#&;:%^!";
    private ArrayList<Character> ins;
    private FileInputStream reader;

    Parser(File f) throws FileNotFoundException {
        this.ins = new ArrayList<>();
        this.reader = new FileInputStream(f);
    }

    void compile() throws IOException {
        int c;

        while ((c = reader.read()) != -1) {
            if (validIns.contains(Character.toString((char)c)))
                ins.add((char) c);
        }
    }

    void exec() throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> mem = new ArrayList<Integer>();
        FileMgr fm = new FileMgr();
        SocketMgr sm = new SocketMgr();
        Stack loopPtr = new Stack();

        StringBuilder fStr = new StringBuilder(), sockStr = new StringBuilder();
        int ptr = 0;
        char c;

        mem.add(0);

        for (int eip = 0; eip < ins.size(); eip++) {
            switch (ins.get(eip)) {
                case '+':
                    mem.set(ptr, mem.get(ptr) + 1);
                    break;
                case '-':
                    mem.set(ptr, mem.get(ptr) - 1);
                    break;
                case '>':
                    if (ptr >= mem.size() - 1)
                        mem.add(0);
                    ptr++;
                    break;
                case '<':
                    ptr--;
                    break;
                case ',':
                    mem.set(ptr, (int) sc.next().charAt(0));
                    break;
                case '.':
                    System.out.print((char) mem.get(ptr).intValue());
                    break;
                case '[':
                    if (mem.get(ptr) != 0)
                        loopPtr.push(eip);
                    else
                        while (ins.get(eip) != ']')
                            eip++;
                    break;
                case ']':
                    if (mem.get(ptr) != 0)
                        eip = Integer.parseInt(loopPtr.peek().toString());
                    else
                        loopPtr.pop();
                    break;
                case '#':
                    if (!fm.isOpen()) {
                        fStr.delete(0, fStr.length());
                        for (int readPtr = ptr; readPtr < mem.size(); readPtr++) {
                            if (mem.get(readPtr) == 0)
                                break;
                            else
                                fStr.append((char) mem.get(readPtr).intValue());
                        }
                        fm.load(new File(fStr.toString()), false);
                    } else {
                        fm.close();
                    }
                    break;
                case '&':
                    if (!fm.isOpen()) {
                        fStr.delete(0, fStr.length());
                        for (int readPtr = ptr; readPtr < mem.size(); readPtr++) {
                            if (mem.get(readPtr) == 0)
                                break;
                            else
                                fStr.append((char) mem.get(readPtr).intValue());
                        }
                        fm.load(new File(fStr.toString()), true);
                    } else {
                        fm.close();
                    }
                    break;
                case ';':
                    fm.write((char) mem.get(ptr).intValue());
                    break;
                case ':':
                    mem.set(ptr, (int) fm.read());
                    break;
                case '%':
                    sockStr.delete(0, sockStr.length());
                    for (int readPtr = ptr; readPtr < ptr + 5; readPtr++) {
                        if ((readPtr + 1) - ptr <= 4) {
                            sockStr.append(mem.get(readPtr).intValue());
                            sockStr.append(".");
                        } else {
                            sockStr.deleteCharAt(sockStr.length() - 1);
                            sockStr.append(":");
                            sockStr.append(mem.get(readPtr).intValue());
                        }
                    }
                    sm.conn(sockStr.toString().split(":")[0], Integer.parseInt(sockStr.toString().split(":")[1]));
                    break;
                case '^':
                    sm.send((char) mem.get(ptr).intValue());
                    break;
                case '!':
                    mem.set(ptr, (int) sm.read());
                    break;
            }
        }
        fm.close();
        sm.close();
    }

    String memDump(ArrayList<Integer> mem) {
        StringBuilder sb = new StringBuilder();

        for (int c : mem)
        {
            sb.append(c);
            sb.append("|");
        }

        return sb.toString();
    }
}
