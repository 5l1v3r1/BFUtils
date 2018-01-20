import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketExample {
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(1402);
        try {
            while (true) {
                Socket s = listener.accept();
                try {
                    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    String str;

                    out.println("lol");


                    while((str = in.readLine()) != null)
                        System.out.print(str);
                    System.out.println();
                } finally {
                    s.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}