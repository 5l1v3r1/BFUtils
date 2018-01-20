package BrainFuckPP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class SocketMgr
{
    private Socket s;
    private BufferedReader in;
    private PrintWriter out;

    void conn(String addr, int port) throws IOException
    {
        s = new Socket(addr, port);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
    }

    char read() throws IOException
    {
        return (char)in.read();
    }

    void send(char c)
    {
        out.println(c);
    }

    void close() throws IOException
    {
        if(s != null && !s.isClosed())
            s.close();
    }
}