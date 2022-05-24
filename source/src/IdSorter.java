import java.io.*;
import java.util.*;

public class IdSorter {

    //Format der zu sortierenden Datei ist ID-Name (wobei in einer Zeile beliebig viele Informationen enthalten sein können)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //User-IO
        System.out.print("Hier filename eingeben:");
        String filename = br.readLine(); //Dateiname ohne .txt Endungen auslesen
        try{
            String[] zeile = new String[50];
            String[] stringIds = new String[50];
            String[] ozeile = new String[50];
            File input = new File(filename + ".txt");
            Scanner reader = new Scanner(input);
            reader.useDelimiter("-");
            int counter = 0;
            File oFile = new File("sortedFile.txt");
            FileWriter writer = new FileWriter("sortedFile.txt");


            System.out.println("Datei vor der Permutation: ");      //Hier wird die .txt Datei ausgelesen und zwischen
            while (reader.hasNextLine()){                           //Ids und dem Rest der Zeile unterschieden
                stringIds[counter] = reader.next();                     //gleichzeitig wird die Textdatei zur Eigenkontrolle
                zeile[counter] = reader.nextLine();                     //wiedergegeben.
                System.out.println(stringIds[counter] + " " + zeile[counter]);
                counter++;
            }


            reader.close();


            int[] ids = new int[50];                                //um die Ids nummerisch zu sortieren werden sie in
            for(int i= 0; i<zeile.length; i++){                     //int umgewandelt und dann sortiert von klein nach
                ids[i] = Integer.parseInt(stringIds[i]);            //groß.
            }

            Arrays.sort(ids);

            for(int i=0; i<ids.length; i++){                        //um die Ergebnisdatei zu beschreiben werden nun die
                for(int j = 0; j<ids.length; j++){                  //Ids wieder mit dem Rest der Zeile zusammengefügt
                    if(ids[i] == Integer.parseInt(stringIds[j])){
                        ozeile[i] = stringIds[j]+ " " + zeile[j];
                        writer.write(ozeile[i]+"\n");
                        break;
                    }
                }

            }
            writer.close();



        }
        catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden!");
            e.printStackTrace();
        }


    }
}
