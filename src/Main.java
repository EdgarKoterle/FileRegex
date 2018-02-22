import java.util.regex.*;
import java.io.*;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Pattern pattSPZ=Pattern.compile("(B(A|B|C|J|L|N|R|S|Y)|CA|D(K|S|T)|G(A|L)|H(C|E)|IL|K(A|I|E|K|M|N|S)|L(E|C|M|V)|M(A|I|L|T|Y)|N(I|O|M|R|Z)|P(B|D|E|O|K|N|P|T|U|V)|R(A|K|S|V)|S(A|B|C|E|I|K|L|O|N|P|V)|T(A|C|N|O|R|S|T|V)|V(K|T)|Z(A|C|H|I|M|V))([ ]{0,1})([0-9]{3})([A-Z]{2})");
            Pattern pattRC=Pattern.compile("([0-9]{2})(01|02|03|04|05|06|07|08|09|10|11|12|51|52|53|54|55|56|57|58|59|60|61|62)(([0]{1}[1-9]{1})|([1-2]{1}[0-9]{1})|([3]{1}[0-1]{1}))/([0-9]{3,4})");
            Pattern pattMAC=Pattern.compile("([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})");
            BufferedReader r=new BufferedReader(new FileReader("rawText.txt"));
            String line;
            FileWriter writeSPZ=new FileWriter("SPZ.txt");
            FileWriter writeRC=new FileWriter("RC.txt");
            FileWriter writeMAC=new FileWriter("MAC.txt");
            System.getProperty("line.separator");

            while ((line=r.readLine()) != null)
            {
                Matcher matchSPZ=pattSPZ.matcher(line);
                Matcher matchRC=pattRC.matcher(line);
                Matcher matchMAC=pattMAC.matcher(line);

                while (matchSPZ.find())
                {
                    int start=matchSPZ.start(0);
                    int end=matchSPZ.end(0);

                    writeSPZ.write(line.substring(start, end));
                    writeSPZ.write(System.getProperty("line.separator"));
                }

                while (matchRC.find())
                {
                    int start=matchRC.start(0);
                    int end = matchRC.end(0);

                    writeRC.write(line.substring(start, end));
                    writeRC.write(System.getProperty("line.separator"));
                }

                while (matchMAC.find())
                {
                    int start=matchMAC.start(0);
                    int end=matchMAC.end(0);

                    writeMAC.write(line.substring(start, end));
                    writeMAC.write(System.getProperty("line.separator"));
                }
            }

            writeSPZ.close();
            writeRC.close();
            writeMAC.close();

            System.out.println("Success");
        }

        catch (IOException e)
        {
            e.getMessage();
        }
    }
}