import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
    //Scanner sc = new Scanner(new File("tulemused.txt"), StandardCharsets.UTF_8);

    //kirjutab tulemused faili
    public static void KirjutaFaili(Tulemus tulemus) throws IOException {
        try {
            //kontrollin kas fail on olemas ning kui pole, siis ta loob uue
            LooFail();
            //loon sõne andmetega
            String rida = tulemus.getPunktid() + "; " + tulemus.getKatse() + "; " + tulemus.getNimi() + "; " + tulemus.getKuupäevKell();

            FileWriter kirjutaja = new FileWriter("Tulemused.txt", true);
            kirjutaja.write(rida);
            kirjutaja.close();

            List<List> kõiktulemused = new ArrayList<>();
            /*
            while (sc.hasNextLine()){
                String rida = sc.nextLine();
                List<String> ajutine = Arrays.asList(rida.split(";"));

                //saan kätte listis oleva esimese elemendi esimene char-i, mis peaks olema koha number tabelis
                int mitmes_koht = ajutine.get(0).charAt(0);
                */
        }
        catch (IOException e) {
            System.out.println("Siia poleks tohtinud jõuda??!!");
            e.printStackTrace();
        }
    }

    //meetod saab sisendiks arvu, mitut parimat tulemust kuvatakse ning lisab need sõned Listi
    public static List<String> TopTulemused(int TopTulemusteArv) throws IOException {
        //loome listi parimate tulemuste jaoks
        List<String> parimad = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("tulemused.txt"), StandardCharsets.UTF_8)) {

            List<String> tabel = new ArrayList<>();

            //loeme tulemused sisse
            while (sc.hasNextLine()) {
                tabel.add(sc.nextLine());
            }

            //töötleme tulemuste listi, et kätte saada parimad tulemused
            for(int i = 0; i < TopTulemusteArv; i++){
                String suurimListi = null;
                double suurimVaartus = 0;

                for (String tabeliRida : tabel) {
                    String[] reaOsad = tabeliRida.split(";");
                    double vaartus = Double.parseDouble(reaOsad[0].trim());

                    //leiame suurima väärtusega tulemuse
                    if (vaartus > suurimVaartus) {
                        suurimVaartus = vaartus;
                        suurimListi = tabeliRida;
                    }
                }

                //lisame parima tulemuse tagastatavasse listi ning eemaldame selle, et leida paremuselt järgmine tulemus
                parimad.add(suurimListi);
                tabel.remove(suurimListi);
            }
        }

        return parimad;
    }


    //meetod kontrollimaks, kas tulemusfail on olemas Kui seda pole, siis ta loob uue
    public static void LooFail(){
        try {
            File tulemused = new File("Tulemused.txt");
            if (!tulemused.exists()) {
                tulemused.createNewFile();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    //TODO: teha meetod, mis otsiks tulemused.txt failist top x tulemust välja
}
