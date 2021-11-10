package Entitiy07293;

public class SepatuTerdaftarEntity07293 {
    private SizeEntity sizeEntity07293;
    private int indexJenis07293;
    private String KodeSepatu07293;
    private int size;

    public SepatuTerdaftarEntity07293(SizeEntity sizeEntity07293,
                                      int indexJenis07293,
                                      String KodeSepatu07293){
        this.sizeEntity07293 = sizeEntity07293;
        this.indexJenis07293 = indexJenis07293;
        this.KodeSepatu07293 = KodeSepatu07293;
    }

    public SizeEntity getSizeEntity07293() {
        return sizeEntity07293;
    }

    public void setSizeEntity07293(SizeEntity sizeEntity07293) {
        this.sizeEntity07293 = sizeEntity07293;
    }

    public int getIndexJenis07293() {
        return indexJenis07293;
    }

    public void setIndexJenis07293(int indexJenis07293) {
        this.indexJenis07293 = indexJenis07293;
    }

    public String getKodeSepatu07293() {
        return KodeSepatu07293;
    }

    public void setKodeSepatu07293(String kodeSepatu07293) {
        KodeSepatu07293 = kodeSepatu07293;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
