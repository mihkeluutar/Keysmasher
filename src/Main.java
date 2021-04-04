import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Väljastab alustamisel mängijale juhised
        juhised();
        /*
        System.out.println("'M' - mängi\n'E' - edetabelisse\n'P' - peata programmi töö");
        while (true) {

            //Kasutame Scannerit, et kasutajalt sisendit saada
            Scanner sisend = new Scanner(System.in);

            String sisse = sisend.nextLine();
            if (sisse.equals("M") || sisse.equals("m")) {
                System.out.println("Valisid mängimise, oota veidi...");
                int ylPikkus = Abi.suvalinePikkus(10, 50);
                System.out.println("Sul on tarvis vajutada klahvi 'Space' " + ylPikkus + " korda");
                System.out.println("Läks!");
                long algusaeg = System.currentTimeMillis();
                Scanner in = new Scanner(System.in);
                String katsetus = in.nextLine();
                long lõpuaeg = System.currentTimeMillis();
                System.out.println("Algusaeg: " + algusaeg + "\nLõpuaeg:  " + lõpuaeg + "\nAjakulu:  " + (lõpuaeg-algusaeg));
                System.out.println("Tulemus: \n" + Katse.mituPunkti(algusaeg, lõpuaeg, katsetus, ylPikkus));
            } else if (sisse.equals("E") || sisse.equals("e")) {
                System.out.println("Näitan edetabelit");
            } else if (sisse.equals("P") || sisse.equals("p")) {
                System.out.println("Peatan programmi töö");
                break;
            } else {
                System.out.println("Ootamatu sisend, proovi uuesti");
            }


        }
         */
        while (true) {
            String midateha = Abi.sisend("'M' - mängi\n'E' - edetabelisse\n'P' - peata programmi töö");
            if (midateha.toLowerCase().equals("p")) {
                lõputiitrid();
                break;
            } else if (midateha.toLowerCase().equals("m")) {
                mängi();
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
        praegune.mituPunkti();

        /*
        System.out.println("Valisid mängimise, oota veidi...");
        int ylPikkus = Abi.suvalinePikkus(10, 50);
        System.out.println("Sul on tarvis vajutada klahvi 'Space' " + ylPikkus + " korda");
        System.out.println("Läks!");
        long algusaeg = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        String katsetus = in.nextLine();
        long lõpuaeg = System.currentTimeMillis();
        System.out.println("Algusaeg: " + algusaeg + "\nLõpuaeg:  " + lõpuaeg + "\nAjakulu:  " + (lõpuaeg-algusaeg));
        System.out.println("Tulemus: \n" + Katse.mituPunkti(algusaeg, lõpuaeg, katsetus, ylPikkus));
         */
    }

    /**
     *
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
        System.out.println("Sul on tarvis vajutada klahvi '" + klahv + "' " + ylPikkus + " korda");

        int oota = Abi.suvalinePikkus(1,5);
        System.out.println("Ole valmis");
        for (int i = 0; i < oota; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
        }
        long algusaeg = System.currentTimeMillis();
        String kasutajaSisend = Abi.sisend("Läks!");
        long lõpuaeg = System.currentTimeMillis();

        Katse praegune = new Katse(algusaeg, lõpuaeg, ylPikkus, klahv, kasutajaSisend);
        return praegune;
    }

    private static void lõputiitrid() {
        System.out.println("Aitäh, et mängisid!\n\n" +
                "Programmi lõid Mihkel Uutar, Karl Lainestu");
    }

    private static void juhised() {
        System.out.println("Alustasid Kiismäsher 2.0 Ultimate Versioni mängimist!\n" +
                "Mäng on lihtne - arvuti annab sulle ülesande ning sinu eesmärk\n" +
                "on soovitud klahvi võimalikult kiiresti nõutud kordi vajutada.\n" +
                "Ole täpne, sest vale sisestuse korral kaotad punkte! \n\n" +
                "Vajuta sobivat klahvi, et jätkata.");
    }
}
