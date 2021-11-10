import java.util.Arrays;
import java.util.Scanner;

public class TAsistensiPBO {
    public static void main(String[] args) {

        //inisialisasi
        Scanner input = new Scanner(System.in);
        int jmlmk07293;
        float jum07293, rata07293;
        boolean isRunning = true;

        // menampilkan dan menginputkan jumlah mata kuliah
        System.out.print ("Jumlah Mata kuliah : ");
        jmlmk07293 = input.nextInt();

        //membuat inisialisasi untuk program do while
        jum07293=0;
        int i07293 = 0;

        //membuat array untuk menyimpan data di do while
        //array1=nilai matakuliah
        int[] array1 = new int[jmlmk07293];
        //array2 = nama matakuliah
        String[]  array2 = new String[jmlmk07293];

        //logika do while untuk inputan nama mata kuliah dan nilai mata kuliah
        input.nextLine();
        do{
            System.out.print ("Nama Mata kuliah ke-"+i07293+": ");
            array2[i07293] = input.nextLine();
            System.out.print ("Nilai Mata Kuliah ke-" + i07293 + ": ");
            array1[i07293] = input.nextInt();
            input.nextLine();
            jum07293 += array1[i07293];
            i07293++;
        }while (i07293 < jmlmk07293);


        do{
            int Pil;
            System.out.println("1. Urutkan Nilai dari yang terkecil");
            System.out.println("2. Tampilkan Rata-Rata");
            System.out.println("3. Keluar");
            System.out.println("Pilih : ");
            Pil = input.nextInt();
            switch (Pil) {
                case 1:
                    for (int i = 0; i < jmlmk07293; i++) {
                        for (int j = 0; j < jmlmk07293; j++) {
                            if (array1[i] < array1[j]) {
                                int temp = array1[i];
                                array1[i] = array1[j];
                                array1[j] = temp;
                                String temp1 = array2[i];
                                array2[i] = array2[j];
                                array2[j] = temp1;
                            }
                        }
                    }

                    for (int k = 0; k < jmlmk07293; k++) {
                        System.out.println("Nama mata kuliah : " + array2[k]);
                        System.out.println("Nilai : " + array1[k]);
                    }
                    System.out.println();
                    break;
                case 2:
                    //logika untuk menampilkan rata rata yang telah diinputkan dalam logika while
                    rata07293 = jum07293 / jmlmk07293;
                    System.out.println("Rata-rata nilai mhs: " + rata07293);
                    System.out.println("Jumlah Total nilai: " + jum07293);

                    //logika if else untuk menentukan gugur dan lulusnya mahasiswa
                    if (rata07293 <= 70) {
                        System.out.println("GUGUR");
                    } else {
                        System.out.println("LULUS");
                    }
                    System.out.println();
                    break;
                case 3 :
                    System.exit(0);
                default:
                    System.out.println("Plattidak dikenal oleh sistem");
            }
        }while (isRunning);
    }
}