public class Katse {

    String algusaeg;
    double lõpuaeg;
    String nimi;
    Ülesanne ülesanne; //Määrab kui palju tähemärke kasutaja sisestama peab

    public Katse(String algusaeg, double lõpuaeg, String nimi, Ülesanne ülesanne) {
        this.algusaeg = algusaeg;
        this.lõpuaeg = lõpuaeg;
        this.nimi = nimi;
        this.ülesanne = ülesanne;
    }
}
