package StandardBF;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class BFtoC {
    private FileInputStream fin;
    private BufferedWriter fout;
    private Map<Character, String> insMap;

    BFtoC(File fin) throws IOException
    {
        insMap = new HashMap<Character, String>();
        insMap.put('+', "\t++(*ptr);\n");
        insMap.put('-', "\t--(*ptr);\n");
        insMap.put('>', "\t++ptr;\n");
        insMap.put('<', "\t--ptr;\n");
        insMap.put(',', "\tscanf(\"%c\", ptr);\n");
        insMap.put('.', "\tprintf(\"%c\", *ptr);\n");
        insMap.put('[', "\twhile (*ptr)\n\t{\n");
        insMap.put(']', "\t}\n");

        this.fin = new FileInputStream(fin);
        this.fout = new BufferedWriter(new FileWriter(new File("out.c"), false));
    }

    BFtoC(File fin, File fout) throws FileNotFoundException, IOException
    {
        insMap = new HashMap<Character, String>();
        insMap.put('+', "\t++(*ptr)\n");
        insMap.put('-', "\t--(*ptr)\n");
        insMap.put('>', "\t++ptr;\n");
        insMap.put('<', "\t--ptr;\n");
        insMap.put(',', "\tscanf(\"%c\", ptr);\n");
        insMap.put('.', "\tprintf(\"%c\", *ptr);\n");
        insMap.put('[', "\twhile (*ptr)\n\t{");
        insMap.put(']', "\t}\n");

        this.fin = new FileInputStream(fin);
        this.fout = new BufferedWriter(new FileWriter(fout, false));
    }

    void compile() throws IOException
    {
        int c, memSize = 0;
        ArrayList<Character> ins = new ArrayList<Character>();

        while ((c = fin.read()) != -1) {
            ins.add((char)c);
            if (c == '>')
                memSize++;
        }

        fout.write("#include <stdio.h>\n" +
                "#include <string.h>\n" +
                "\n" +
                "#define MEMORY_SIZE " + memSize + "\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "\tchar mem[MEMORY_SIZE], *ptr;\n" +
                "\tmemset(mem, 0, sizeof(mem));\n" +
                "\tptr = mem;\n");

        for(char ch : ins)
        {
            fout.write(insMap.get(ch));
        }

        fout.write("return 0;\n}");
        fout.close();
    }
}
