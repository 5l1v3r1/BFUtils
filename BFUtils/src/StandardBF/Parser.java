package StandardBF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Parser
{
    private ArrayList<Character> ins;
    private FileInputStream reader;

    Parser(File f) throws FileNotFoundException
    {
        this.ins = new ArrayList<Character>();
        this.reader = new FileInputStream(f);
    }

    void compile() throws IOException
    {
        int c;

        while ((c = reader.read()) != -1)
            ins.add((char)c);
    }

    void exec()
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> mem = new ArrayList<Integer>();
        Stack loopPtr = new Stack();

        String fStr, sockStr;
        int ptr = 0;
        char c;

        mem.add(0);

        for (int eip = 0; eip < ins.size(); eip++)
        {
            switch(ins.get(eip)) {
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
                    mem.set(ptr, (int)sc.next().charAt(0));
                    break;
                case '.':
                    System.out.print((char)mem.get(ptr).intValue());
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
            }
        }
    }
}