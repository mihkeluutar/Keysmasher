public class Tulemus {

    public long algusaeg;
    public long lõpuaeg;
    public int punktid;


    public Tulemus(long algusaeg, long lõpuaeg, int punktid) {
        this.algusaeg = algusaeg;
        this.lõpuaeg = lõpuaeg;
        this.punktid = punktid;
    }

    public long getAlgusaeg() {
        return algusaeg;
    }

    public void setAlgusaeg(long algusaeg) {
        this.algusaeg = algusaeg;
    }

    public long getLõpuaeg() {
        return lõpuaeg;
    }

    public void setLõpuaeg(long lõpuaeg) {
        this.lõpuaeg = lõpuaeg;
    }

    public int getPunktid() {
        return punktid;
    }

    public void setPunktid(int punktid) {
        this.punktid = punktid;
    }



}
