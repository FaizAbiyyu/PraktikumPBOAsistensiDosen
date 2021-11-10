package Proses07293;

import Entitiy07293.OwnerEntity07293;

public class OwnerProses07293 implements Interface07293 {
    private static OwnerEntity07293[] owner07293 = new OwnerEntity07293[100];
    private static int jumOwner07293 = 0;

    public static OwnerEntity07293[] getOwner07293() {
        return owner07293;
    }

    public void insert(String[] Password07293, String[] namaOwner07293,
                       String[] alamatOwnwer07293, String[] notelpOwner07293){
        for(int i = 0; i < namaOwner07293.length ; i ++){
            owner07293[i] = new OwnerEntity07293(Password07293[i], namaOwner07293[i], alamatOwnwer07293[i]
                    , notelpOwner07293[i]);
            jumOwner07293++;
        }
    }

    @Override
    public void view(){
        for (int i = 0; i < jumOwner07293; i++){
            System.out.println("====================");
            System.out.println("Nama : " + owner07293[i].getNama07293() +
                    "\nAlamat : " + owner07293[i].getAlamat07293() +
                    "\nNo.Telp : " + owner07293[i].getNoTelp07293());
            System.out.println("====================");
        }
    }

    public int cekData(String user, String Password){
        int index = 0;
        for (int i = 0; i < jumOwner07293; i++) {
            if (owner07293[i].getNama07293().equals(user) &&
            owner07293[i].getPassword07293().equals(Password)){
                return index;
            }else{
                index++;
            }
        }
//        for (OwnerEntity07293 prosesOwner07293 : owner07293){
//            if (prosesOwner07293.getNama07293().equals(user) &&
//            prosesOwner07293.getPassword07293().equals(Password)){
//                break;
//            }else{
//                index++;
//            }
//        }
        return index;
    }
}
