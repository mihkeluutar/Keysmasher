import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Edetabel extends Mangija{
    private LocalDate kuupäev;
    private String nimi;
    private int tulemus;
    public int koht;

    public Edetabel(int tulemus, int koht) {
        super(tulemus);
        this.koht = koht;

        kuupäev = getKuupäev();
        nimi = getMangija_nimi();
    }

    public static void näitaTabel() throws IOException {
        try {
            Scanner sc = new Scanner(new File("Edetabel.txt"), StandardCharsets.UTF_8);
            //FileWriter kirjutaja = new FileWriter("Edetabel.txt");
            List<List> maatriks = new ArrayList<>();

            while (sc.hasNextLine()){
                List<String> ajutine = new ArrayList<>();
                String rida = sc.nextLine();

                String koht = "";


            }





        }
        catch (IOException e) {
            System.out.println("Siia poleks tohtinud jõuda??!!");
            e.printStackTrace();
        }
    }
}
