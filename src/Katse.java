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
        int punkte = 0;
        //Arvutab lahendamiseks kulunud aja millisekundites
        long ajakulu = this.lõpuaeg - this.algusaeg;

        //Pikema ülesandega saab mängija potentsiaalselt rohkem punkte
        int ajaboonus = this.ylPikkus*50;
        punkte += ajaboonus;

        //Boonus perfektse tulemuse eest
        String oodatudSisend = this.klahv.repeat(this.ylPikkus);
        if (oodatudSisend.equals(this.kasutajaSisend)) {
            punkte += ylPikkus*20;
        }




        return punkte;
    }

}
