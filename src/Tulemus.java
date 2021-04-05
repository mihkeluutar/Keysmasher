import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Tulemus {

    public Katse katse;
    public int punktid;
    public String nimi;
    public LocalDateTime kuupäevKell;

    public Tulemus(Katse katse, int punktid) {
        this.katse = katse;
        this.punktid = punktid;

        Scanner sc = new Scanner(System.in);
        System.out.println("Sisesta oma nimi:");
        nimi = sc.nextLine();

        kuupäevKell = LocalDateTime.now();
    }

    public Katse getKatse() {
        return katse;
    }

    public void setKatse(Katse katse) {
        this.katse = katse;
    }

    public int getPunktid() {
        return punktid;
    }

    public void setPunktid(int punktid) {
        this.punktid = punktid;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public LocalDateTime getKuupäevKell() {
        return kuupäevKell;
    }

    public void setKuupäevKell(LocalDateTime kuupäevKell) {
        this.kuupäevKell = kuupäevKell;
    }
}
