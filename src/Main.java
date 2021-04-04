import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Väljastab alustamisel mängijale juhised
        juhised();
        navigeerimine();
        while (true) {
            String midateha = Abi.sisend("");
            if (midateha.toLowerCase().equals("p")) {
                lõputiitrid();
                break;
            } else if (midateha.toLowerCase().equals("m")) {
                mängi();
            } else if (midateha.toLowerCase().equals("e")) {
                System.out.println("Edetabel!");
            } else if (midateha.toLowerCase().equals("j")) {
                juhised();
            } else {
                System.out.println("Ootamatu sisend, proovi uuesti!");
                navigeerimine();
            }
        }
    }

    private static void mängi() throws InterruptedException {
        System.out.print("Sean mängu valmis");
        for (int i = 0; i < 3; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
        }
        Katse praegune = ylesanne(" ");
        int saadudPunkte = praegune.mituPunkti();
        System.out.println("Said kokku " + saadudPunkte + " punkti!");
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
        int ylPikkus = Abi.suvalinePikkus(30, 60);
        System.out.println("\nSul on tarvis vajutada klahvi '" + klahv + "' " + ylPikkus + " korda.");

        int oota = Abi.suvalinePikkus(1, 5);
        System.out.print("Ole valmis");
        for (int i = 0; i < oota; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
        }
        long algusaeg = System.currentTimeMillis();
        String kasutajaSisend = Abi.sisend("\nLäks!");
        long lõpuaeg = System.currentTimeMillis();

        Katse praegune = new Katse(algusaeg, lõpuaeg, ylPikkus, klahv, kasutajaSisend);
        return praegune;
    }

    private static void lõputiitrid() {
        System.out.println("Aitäh, et mängisid!\n\n" +
                "Mängu tegid:\n" +
                "Mihkel Uutar, @mihkeluutar\n" +
                "Karl Lainestu, @Naploon\n" +
                "Johann Koobas, @j-koobas");
    }

    private static void juhised() {
        System.out.println("Alustasid Kiismäsher 2.0 Ultimate Versioni mängimist!\n" +
                "Mäng on lihtne - arvuti annab sulle ülesande ning sinu eesmärk\n" +
                "on soovitud klahvi võimalikult kiiresti nõutud kordi vajutada.\n" +
                "Ole täpne, sest vale sisestuse korral kaotad punkte! \n\n" +
                "Vajuta sobivat klahvi, et jätkata.");
    }

    private static void navigeerimine() {
        System.out.println(
                "'M' - mängi\n" +
                        "'E' - edetabelisse\n" +
                        "'J' - näita juhendit\n" +
                        "'P' - peata programmi töö");

    }
}
