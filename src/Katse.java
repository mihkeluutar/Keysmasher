public class Katse {

    //Konstruktor uue isendi loomiseks
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


    //Meetod punktide välja arvutamiseks (võtab arvesse aega, täpsust ja ülesande pikkust)
    public int mituPunkti() {
        //Kontrollime, et klahv ei oleks 'Space', muidu tekib probleeme tulemuse arvutamisel
        if (this.klahv.equals("Space")) {
            this.klahv = " ";
        }

        //Anname muutujatele esialgsed väärtused
        int punkte = 0;
        double täpsus = 1;

        //Arvutab lahendamiseks kulunud aja millisekundites
        long ajakulu = this.lõpuaeg - this.algusaeg;

        //Pikema ülesandega saab mängija rohkem punkte
        int pikkusboonus = this.ylPikkus * 50;
        punkte += pikkusboonus;

        //Boonus perfektse tulemuse eest
        String oodatudSisend = this.klahv.repeat(this.ylPikkus);
        if (oodatudSisend.equals(this.kasutajaSisend)) {
            punkte += ylPikkus * 50;
            System.out.println("Said boonuse!");
        } else {
            System.out.println("Ei saanud boonust!");
        }

        //Täpsuskoefitsendi arvutamine
        //Puuduvate, liigsete ja valede tähemärkide eest kaotab mängija punkte
        int liigseidPuuduvaid = Math.abs(oodatudSisend.length() - this.kasutajaSisend.length());
        täpsus *= ((double) (liigseidPuuduvaid)) / ((double) (ylPikkus));
        int valed = 0;

        //Kontrollime, kas kasutaja kasutas ikka õiget klahvi
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

        //Vähendame täpsuskoefitsenti vastavalt valedele tähemärkidele
        //Kui valede tähemärkide arv on suurem kui ülesande pikkus korrutame täpsusekoefitseandi 0.1-ga
        if (valed > this.ylPikkus) {
            täpsus *= 0.1;
        } else if (valed != 0){
            täpsus *= ((double) (valed)) / ((double) (this.ylPikkus));
        }

        //Kiiruskoefitsendi arvutamine (eeldame ca 4 tähemärki/sec)
        long eeldatavAeg = this.ylPikkus * 250;
        double kiirus = (double) (eeldatavAeg) / (double)(ajakulu);

        //Valem lõppskoori leidmiseks
        if (täpsus < 0)
            täpsus = 0.01;
        punkte = (int) (punkte * täpsus * kiirus);

        //Testimise eesmärgil väljastame ka need ekraanile
        System.out.println("Täpsus: " + täpsus);
        System.out.println("Kiirus: " + kiirus);

        return punkte;
    }

}
