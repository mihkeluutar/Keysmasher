import java.time.LocalDate;
import java.util.Scanner;

public class Mangija {
    public String mangija_nimi;
    public LocalDate kuupäev;
    public int tulemus;

    public Mangija(int tulemus) {
        this.tulemus = tulemus;

        Scanner sc = new Scanner(System.in);
        System.out.println("Sisesta oma nimi:");

        mangija_nimi = sc.nextLine();
        kuupäev = java.time.LocalDate.now();
    }

    public String getMangija_nimi() {
        return mangija_nimi;
    }

    public LocalDate getKuupäev() {
        return kuupäev;
    }

    public int getTulemus() {
        return tulemus;
    }

    @Override
    public String toString() {
        return "Mangija{" +
                "mangija_nimi='" + mangija_nimi + '\'' +
                ", kuupäev=" + kuupäev +
                ", tulemus=" + tulemus +
                '}';
    }
}
