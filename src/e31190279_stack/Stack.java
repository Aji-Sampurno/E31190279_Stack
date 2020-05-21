package e31190279_stack;

import java.util.Scanner;//agar dapat melakukan input data dari keyboard

/**
 *
 * @author Aji Sampurno
 */
public class Stack {
    //membuat variabel dengan type boolean
    private boolean kosong, penuh;
    
    //membuat variable dengan type integer
    private int posisi;//menentukan posisi data pada array 
    private int max_data = 5;//maksimal data yang dapat disimpan dalam array
    
    //mendeklarasikan array dengan nama item
    private int item[] = new int[max_data];
    
    //
    public static void main(String[] args){
        //membuat variabel dengan tyoe data integer
        int pilihan;
        int data;
        
        //membuat outputan untuk memilih menu
        Stack result = new Stack();
        //membuat perulangan untuk menjalankan program
        do{
            System.out.println("MENU");
            System.out.println("=============================================");
            System.out.println("1. PUSH");
            System.out.println("2. POP ITEM");
            System.out.println("3. LIHAT ISI DATA");
            System.out.println("4. KELUAR");
            System.out.println("=============================================");
            System.out.print("Pilih Menu : ");
            //scanner untuk memasukkan menu yang akan dipilih
            Scanner input = new Scanner(System.in);
            pilihan = input.nextInt();
            
            //jika memilih menu 1
            if(pilihan==1){
                System.out.print("Data yang di tambahkan : ");//menampilkan pesan untuk memasukkan data
                data = input.nextInt();//scanner untuk memasukkan data yang ingin dimasukkan
                result.push(data);//memanggil method push
            }
            //jika memilih menu 2
            else if(pilihan==2){
                result.pop();//memanggil method pop
            }
            //jika memilih menu 3
            else if(pilihan==3){
                result.display();//memanggil method display
            }
            //jika memilih menu 0
            else if(pilihan==0){
                System.exit(0);//mengakhiri sesi
            }
            //jika menu yang dipilih tidak ada
            else{
                System.out.println("Pilihan tidak ada");//menampilkan pesan 
            }
        }while(pilihan !=0);//akhir perulangan
    }
    
    //membuat constructor untuk menentukan nilai awal pada stack
    public void Stack(){
        penuh = false; // variabel penuh bernilai false
        kosong = true; // variabel kosong bernilai true
        posisi = 0; // posisi bernilai 0
    }
    //method untuk mengecek niali dari boolean penuh
    public boolean isPenuh(){
        return(penuh); //mengembalikan nilai
    }
    //method untuk mengecek niali dari boolean kosong
    public boolean isKosong(){
        return(kosong); //mengembalikan nilai 
    }
    
    //method untuk memasukkan data pada array dalam stack
    public void push(int data){
        //kodisi untuk memasukkan data
        if(!isPenuh()){
            item[posisi++] = data;//panjang array terus bertambah dan nilai pada array berasal dari data
            kosong = false;//boolean kosong bernilai false
            if(posisi == max_data){
                penuh = true; //jika nilai posisi sama dengan nilai max_data maka boolean penuh akan menjadi true
            }
            System.out.println("Data sudah ditambahkan \n"); //jika kondisi benar maka akan memunculkan pesan
        }else{
            System.out.println("Data sudah penuh \n");//jika salah maka akan memunculkan pesan
        }
        return;//mengembalikan nilai
    }
    
    //method untuk mengambil data pada stack
    public int pop(){
        int x = 0;//memberikan nilai variabel x yang bertipe integer
        //membuat kondisi yang dapat dipenuhi
        if(!isKosong()){
            x = item[--posisi];//mengurangi panjang array setiap pop dijalankan
            penuh = false;//merubah boolean penuh menjadi false agar dapat ditambahkan data kembali
            System.out.println("data yang di pop adalah "+item[posisi]);//pesan letak data yang di pop 
            item[posisi] = 0;//mengurangi data dalam stack
            //membuat kondisi dimana stack bernilai kosong
            if(posisi==0){
                kosong = true;//boolean kosong menjadi true untuk menjalankan kondisi yang terpenuhi
                System.out.println("stack kosong \n");
            }else{
                System.out.println("stack sudah di ambil \n");//pesan saat data pada stack sudah diambil
            }
        }else{
            System.out.println("stack masih kosong !\n");//pesan saat data dalam stack masih kosong
        }
        return(x);//mengembalikan nilai x
    }
    
    //method untuk menampilkan data dalam array
    public void display(){
        System.out.println("isi stack adalah");
        //perulangan untuk menampilkan nilai pada array
        for(int i=0; i<posisi; i++){
            System.out.println(item[i]+"");
        }
        System.out.println("");
    }
}
