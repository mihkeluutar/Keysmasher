import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        //Väljastab alustamisel mängijale logo, juhised ja navigeerimisinfo
        pilt();
        juhised();
        System.out.println("Vajuta sobivat klahvi, et jätkata.");
        navigeerimine();
        while (true) {
            String midateha = Abi.sisend("");
            if (midateha.toLowerCase().equals("p")) {
                lõputiitrid();
                break;
            } else if (midateha.toLowerCase().equals("m")) {
                mängi();
            } else if (midateha.toLowerCase().equals("e")) {
                edetabel();
            } else if (midateha.toLowerCase().equals("j")) {
                juhised();
                Abi.sisend("\n" + "Vajutage enter, et naaseda menüüsse.");
                navigeerimine();
            } else {
                System.out.println("Ootamatu sisend, proovi uuesti!");
                navigeerimine();
            }
        }
    }

    //Meetod uue ülesande loomiseks ja mängimiseks
    private static void mängi() throws InterruptedException, IOException {
        System.out.print("Sean mängu valmis");
        for (int i = 0; i < 3; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
        }

        //Programm loob uue ülesande
        Katse praegune = ylesanne(" ");

        //Kuvame ekraanile mängija saadud punktid
        int saadudPunkte = praegune.mituPunkti();
        System.out.println("Said kokku " + saadudPunkte + " punkti!\n");

        //Kui skoor on piisavalt hea
        if (saadudPunkte > 0) {
            //Mangija mangija = new Mangija(praeguneTulemus);

            Tulemus praeguneTulemus = new Tulemus(praegune, saadudPunkte);
            Edetabel.KirjutaFaili(praeguneTulemus);
            System.out.println("\n");
        }

        //menüü kuvamine
        navigeerimine();

    }

    //meetod edetabeli väljastamiseks
    private static void edetabel() {
        //kasutajalt sisendi saamine
        String TopTulemusteArvsõne = Abi.sisend("Sisestage soovitud parimate tulemuste arv: ");
        try {
            //sisendi täisarvuks muutmine, sobivuse kontrollimine
            int TopTulemusteArv = Integer.parseInt(TopTulemusteArvsõne);
            if(TopTulemusteArv > 0) {
                Edetabel.Tabel(TopTulemusteArv);
            }
            else{
                System.out.println("Tulemuste nägemiseks peab sisestama positiivse täisarvu.");
            }
            Abi.sisend("\n" + "Vajutage enter, et naaseda menüüsse.");
            navigeerimine();

        } catch (NumberFormatException nfe){
            System.out.println("Ootamatu sisend!");
            navigeerimine();
        } catch (IOException e){
            System.out.println("Tulemused puuduvad!");
            navigeerimine();
        }

    }

    /**
     * @param klahv Võtab sisendiks klahvi, mida kasutaja sisestama peab
     * @return tagastab Katse, kus on kirjas algusaeg, lõpuaeg, ülesande pikkus ja klahv, mdia sisetada
     * @throws InterruptedException vajalik ooteaja tekitamiseks
     */
    private static Katse ylesanne(String klahv) throws InterruptedException {
        if (klahv.equals(" ")) {
            klahv = "Space";
        } else {
            klahv.toUpperCase();
        }
        //Genereerime mängijale suvalise pikkusega ülesande
        int ylPikkus = Abi.suvalinePikkus(10, 30);
        System.out.println("\nSul on tarvis vajutada klahvi '" + klahv + "' " + ylPikkus + " korda.");

        //Lisame põnevuse tekitamiseks 1-5 sek ooteaega
        int oota = Abi.suvalinePikkus(1, 5);
        System.out.print("Ole valmis");
        for (int i = 0; i < oota; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
        }

        //Fikseerime katse algusaja, kasutaja sisendi ja lõpuaja
        long algusaeg = System.currentTimeMillis();
        String kasutajaSisend = Abi.sisend("\nLäks!");
        long lõpuaeg = System.currentTimeMillis();

        //tagastame Katse praegune, kus on olemas kõik vajalikud andmed praeguse katse kohta
        Katse praegune = new Katse(algusaeg, lõpuaeg, ylPikkus, klahv, kasutajaSisend);
        return praegune;
    }

    //Kuvab ekranile info mängu tegijate kohta
    private static void lõputiitrid() {
        System.out.println("Aitäh, et mängisid!\n\n" +
                "Mängu tegid:\n" +
                "Mihkel Uutar - @mihkeluutar\n" +
                "Karl Lainestu - @Naploon\n" +
                "Johann Koobas - @j-koobas\n\n" +
                "Poe Gaming LLC, 2021");
    }

    //Kuvab ekraanile mängu juhised
    private static void juhised() {
        System.out.println("Alustasid Kiismäsher Ultimate'i mängimist!\n" +
                "Mäng on lihtne - arvuti annab sulle ülesande ning sinu \n" +
                "eesmärk on soovitud klahvi võimalikult kiiresti nõutud \n" +
                "kordi vajutada.\n" +
                "Ole täpne, sest vale sisestuse korral kaotad punkte! \n");
    }

    //Kuvab ekraanile klahvid, mis on vajalikud navigeerimiseks
    private static void navigeerimine() {
        System.out.println(
                "'M' - mängi\n" +
                        "'E' - edetabelisse\n" +
                        "'J' - näita juhendit\n" +
                        "'P' - peata programmi töö");

    }

    //Kuvab programmi käivitades ASCII sümbolitega kujundatud Kiismäsher Ultimate'i logo :)
    private static void pilt() {
        System.out.println("+-Peo Gaming LLC-------------------------------------------+\n" +
                "|                                                          |\n" +
                "|    | |/ (_|_)             (_) (_)   | |                  |\n" +
                "|    | ' / _ _ ___ _ __ ___   __ _ ___| |__   ___ _ __     |\n" +
                "|    |  < | | / __| '_ ` _ \\ / _` / __| '_ \\ / _ \\ '__|    |\n" +
                "|    | . \\| | \\__ \\ | | | | | (_| \\__ \\ | | |  __/ |       |\n" +
                "|    |_|\\_\\_|_|___/_| |_| |_|\\__,_|___/_| |_|\\___|_|       |\n" +
                "|    | |  | | | | (_)               | |                    |\n" +
                "|    | |  | | | |_ _ _ __ ___   __ _| |_ ___               |\n" +
                "|    | |  | | | __| | '_ ` _ \\ / _` | __/ _ \\              |\n" +
                "|    | |__| | | |_| | | | | | | (_| | ||  __/              |\n" +
                "|     \\____/|_|\\__|_|_| |_| |_|\\__,_|\\__\\___|              |\n" +
                "|                                                          |\n" +
                "+-----------------------------------------------------2021-+");
    }
}
