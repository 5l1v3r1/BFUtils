package BrainFuckPP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileWriter;

class FileMgr
{
    private FileInputStream fin;
    private BufferedWriter fout;
    private boolean open = false;

    void load(File f, boolean append) throws IOException
    {
        f.createNewFile();
        this.fin = new FileInputStream(f);
        this.fout = new BufferedWriter(new FileWriter(f, append));
        this.open = true;
    }

    char read() throws IOException
    {
        return (char)fin.read();
    }

    void write(char c) throws IOException
    {
        fout.write(c);
    }

    boolean isOpen()
    {
        return open;
    }

    public void close() throws IOException
    {
        if (open) {
            this.fin.close();
            this.fout.close();
        }
        this.open = false;
    }
}