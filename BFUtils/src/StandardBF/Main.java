package StandardBF;

import java.net.URISyntaxException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        File module = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        final String usage = "Usage: java -jar " + module.getName() + ".jar [-h] [-C] <File>\nArguments:\n\t-h\t: List this information\n\t-C\t: Compile to C";

        if (args.length > 0 && !args[0].equalsIgnoreCase("-h")) {
            if (args[0].equals("-C")) {
                BFtoC bfc;
                if (args.length > 2) {
                    bfc = new BFtoC(new File(args[1]), new File(args[2]));
                } else {
                    bfc = new BFtoC(new File(args[1]));
                }

                bfc.compile();
            } else {
                try {
                    Parser p = new Parser(new File(args[0]));
                    p.compile();
                    p.exec();
                } catch (FileNotFoundException e) {
                    System.out.println("Brainf**k File Not Found!\n");
                    System.out.println(usage);
                }
            }
        } else {
            System.out.println(usage);
        }
    }
}