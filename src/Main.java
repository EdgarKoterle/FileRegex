import java.util.regex.*;
import java.io.*;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        Pattern pattSPZ=Pattern.compile("(B(A|B|C|J|L|N|R|S|Y)|CA|D(K|S|T)|G(A|L)|H(C|E)|IL|K(A|I|E|K|M|N|S)|L(E|C|M|V)|M(A|I|L|T|Y)|N(I|O|M|R|Z)|P(B|D|E|O|K|N|P|T|U|V)|R(A|K|S|V)|S(A|B|C|E|I|K|L|O|N|P|V)|T(A|C|N|O|R|S|T|V)|V(K|T)|Z(A|C|H|I|M|V))([ ]{0,1})([0-9]{3})([A-Z]{2})");
        Pattern pattRC=Pattern.compile("([0-9]{2})(01|02|03|04|05|06|07|08|09|10|11|12|51|52|53|54|55|56|57|58|59|60|61|62)(([0]{1}[1-9]{1})|([1-2]{1}[0-9]{1})|([3]{1}[0-1]{1}))/([0-9]{3,4})");
        Pattern pattMAC=Pattern.compile("([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})");
        BufferedReader r=new BufferedReader(new FileReader("rawText.txt"));
        String line;

        while ((line=r.readLine()) != null)
        {
            Matcher SPZ=pattSPZ.matcher(line);
            Matcher RC=pattRC.matcher(line);
            Matcher MAC=pattMAC.matcher(line);

            while (SPZ.find())
            {
                int start=SPZ.start(0);
                int end=SPZ.end(0);

                System.out.println(line.substring(start, end));
            }

            while (RC.find())
            {
                int start=RC.start(0);
                int end=RC.end(0);

                System.out.println(line.substring(start, end));
            }

            while (MAC.find())
            {
                int start=MAC.start(0);
                int end=MAC.end(0);

                System.out.println(line.substring(start, end));
            }
        }
    }
}