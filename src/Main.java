import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
            } else if (sisse.equals("E") || sisse.equals("e")) {
                System.out.println("Näitan edetabelit");
            } else if (sisse.equals("P") || sisse.equals("p")) {
                System.out.println("Peatan programmi töö");
                break;
            } else {
                System.out.println("Ootamatu sisend, proovi uuesti");
            }


        }

        //Tagastab millisekundite arvu alates 1970. aasta 1.jaanuarist

        //Mängija valib kas
        //a) mängida mängu
        //b) lõpetada
    }
}
