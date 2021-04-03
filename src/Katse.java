public class Katse {

    long algusaeg;
    long lõpuaeg;
    int ylPikkus;

    public static int mituPunkti(long algusaeg, long lõpuaeg, String sisend, int ylPikkus) {

        long ajakulu = 15000 - (lõpuaeg - algusaeg);
        if (ajakulu <= 0) {
            ajakulu = 100;
        }

        int sisendiPikkus = sisend.length();
        int liigseidPuuduvaid = Math.abs(sisendiPikkus - ylPikkus);

        double täpsus = 1 - (Math.abs(sisendiPikkus - ylPikkus) / ylPikkus) - (liigseidPuuduvaid/ylPikkus);
        String oodatavTulemus = " ".repeat(ylPikkus);
        for (int i = 0; i < sisendiPikkus; i++) {
            if ((sisend.charAt(i)) != ' ') {
                täpsus -= 1 / sisendiPikkus;
            }
        }
        int punktid = (int) (( ajakulu) * täpsus * (1+(ylPikkus / 100)));
        return punktid;
    }

}
