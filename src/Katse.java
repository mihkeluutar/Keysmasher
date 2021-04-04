import java.util.Objects;

public class Katse {

    public Katse(long algusaeg, long lõpuaeg, int ylPikkus, String klahv, String kasutajaSisend) {
        this.algusaeg = algusaeg;
        this.lõpuaeg = lõpuaeg;
        this.ylPikkus = ylPikkus;
        this.klahv = klahv;
        this.kasutajaSisend = kasutajaSisend;
    }

    long algusaeg;
    long lõpuaeg;
    int ylPikkus;
    String klahv;
    String kasutajaSisend;


    public int mituPunkti() {
        if (this.klahv.equals("Space")) {
            this.klahv = " ";
        }
        int punkte = 0;
        double täpsus = 1;
        //Arvutab lahendamiseks kulunud aja millisekundites
        long ajakulu = this.lõpuaeg - this.algusaeg;

        //Pikema ülesandega saab mängija potentsiaalselt rohkem punkte
        int ajaboonus = this.ylPikkus * 50;
        punkte += ajaboonus;

        //Boonus perfektse tulemuse eest
        String oodatudSisend = this.klahv.repeat(this.ylPikkus);
        if (oodatudSisend.equals(this.kasutajaSisend)) {
            punkte += ylPikkus * 50;
        }

        //Täpsuskoefitsendi arvutamine
        //Puuduvate ja liigsete sümbolite eest kaotab mängija punkte
        //Valede tähemärkide eest samuti
        int liigseidPuuduvaid = Math.abs(oodatudSisend.length() - this.kasutajaSisend.length());
        täpsus -= ((double) (liigseidPuuduvaid)) / ((double) (ylPikkus));
        int valed = 0;
        if (this.kasutajaSisend.length() <= oodatudSisend.length()) {
            for (int i = 0; i < this.kasutajaSisend.length(); i++) {
                String oodatud = this.klahv;
                String leitud = String.valueOf(this.kasutajaSisend.charAt(i));
                if (!oodatud.equals(leitud)) {
                    valed += 1;
                }
            }
        } else {
            for (int i = 0; i < oodatudSisend.length(); i++) {
                String oodatud = this.klahv;
                String leitud = String.valueOf(this.kasutajaSisend.charAt(i));
                if (!oodatud.equals(leitud)) {
                    valed += 1;
                }
            }
        }
        täpsus -= ((double) (valed)) / ((double) (this.ylPikkus));

        //Kiiruskoefitsendi arvutamine (eeldame ca 8 tähemärki/sec)
        long eeldatavAeg = this.ylPikkus * 125;
        double kiirus = (double) (eeldatavAeg) / (double)(ajakulu);

        punkte = (int) (punkte * täpsus * kiirus);
        //Testimise eesmärgil väljastame ka need ekraanile
        System.out.println("Täpsus: " + täpsus);
        System.out.println("Kiirus: " + kiirus);
        return punkte;
    }

}
