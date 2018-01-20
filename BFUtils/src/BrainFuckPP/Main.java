package BrainFuckPP;

import java.net.ConnectException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        File module = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        final String usage = "Usage: java -jar " + module.getName() + ".jar [-h] <File>\nArguments:\n\t-h\t: List this information";

        if (args.length > 0 && !args[0].equalsIgnoreCase("-h")) {
                try {
                    Parser p = new Parser(new File(args[0]));
                    p.compile();
                    p.exec();
                } catch (FileNotFoundException e) {
                    System.out.println("Brainf**k++ File Not Found!\n");
                    System.out.println(usage);
                } catch (ConnectException e) {
                    System.out.println("Error: Socket Connection Failed!");
                }
        } else {
            System.out.println(usage);
        }
    }
}