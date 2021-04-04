import java.util.Scanner;

public class Abi {

    //Tagastab suvalise täisarvu vahemikust min - max
    public static int suvalinePikkus (int min, int max) {
        return (int) (Math.random()*(max-min+1)+min);
    }

    public static String sisend(String kuvatavTekst) {
        System.out.println(kuvatavTekst);
        Scanner in = new Scanner(System.in);
        String sisend = in.nextLine();
        return sisend;
    }
}


