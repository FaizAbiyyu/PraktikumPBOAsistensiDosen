import java.util.Scanner;

public class nilaimhs07293 {
    public static void main(String[] args) {

        //inisialisasi
        Scanner input = new Scanner(System.in);
        int jmlmk07293;
        String mk07293;
        int nilai07293;
        float jum07293, rata07293;

        // menampilkan dan menginputkan jumlah mata kuliah
        System.out.print ("Jumlah Mata kuliah : ");
        jmlmk07293 = input.nextInt();

        //logika do while untuk inputan nama mata kuliah dan nilai mata kuliah
        jum07293=0;
        int i07293 = 1;
        do{
            System.out.print ("Nama Mata kuliah ke-"+i07293+": ");
            mk07293 = input.nextLine();
            input.nextLine();
            System.out.print ("Nilai Mata Kuliah ke-" + i07293 + ": ");
            nilai07293 = input.nextInt();
            jum07293 += nilai07293;
            i07293++;
        }while (i07293 <= jmlmk07293);

        //logika untuk menampilkan rata rata yang telah diinputkan dalam logika while
        rata07293 = jum07293 / jmlmk07293;
        System.out.println ("Rata-rata nilai mhs: "+rata07293);
        System.out.println ("Jumlah Total nilai: "+jum07293);

        //logika if else untuk menentukan gugur dan lulusnya mahasiswa
        if (rata07293 <= 70){
            System.out.println("GUGUR");
        }else{
            System.out.println("LULUS");
        }
    }
}