import java.util.Scanner;

public class nilaimhs_07293 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jmlmk_07293;
        String mk_07293;
        int nilai_07293;
        float jum_07293, rata_07293;

        System.out.print ("Jumlah Mata kuliah : ");
        jmlmk_07293 = input.nextInt();

        int j_07293 = 1;
        input.nextLine();
        while (j_07293 <= jmlmk_07293){
            System.out.print ("Nama Mata Kuliah ke-" + j_07293+": ");
            mk_07293 = input.nextLine();
            j_07293++;
        }

        jum_07293=0;
        int i_07293 = 1;
        while (i_07293 <= jmlmk_07293){
            System.out.print ("Nilai ke-"+i_07293+": ");
            nilai_07293 = input.nextInt();
            jum_07293 += nilai_07293;
            i_07293++;
        }

        rata_07293 = jum_07293 / jmlmk_07293;
        System.out.println ("Rata-rata nilai mhs: "+rata_07293);
        System.out.println ("Jumlah Total nilai: "+jum_07293);

        if (rata_07293 <= 70){
            System.out.println("GUGUR");
        }else{
            System.out.println("LULUS");         }

    }
}
