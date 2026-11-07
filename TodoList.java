import java.util.Scanner;

public class TodoList {

// Array untuk menampung isi to-do-list
    public static String[] list = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

public static void showTodolist() {

    System.out.println("To-do-List : ");
    for (var i = 0; i < list.length; i++) {
        var toDo = list[i];
        var no = i + 1;

        if (toDo != null) {
            System.out.println(no + ". " + toDo);
        }
    }
}

public static void fungsiTambah(String tambah) {

    boolean cekpenuh = true;
    for (int k = 0; k < list.length; k++) {
    if (list[k] == null) {
        // cek apakah array masih ada yg kosong atau tidak
        cekpenuh = false;
        break;
    }
    }

    // untuk membuat array tambahan jika array lama tidak cukup menampung nya
    if (cekpenuh) {
        var arBaru = list;
        list = new String[list.length * 2];

        for (int j = 0; j < arBaru.length; j++) {
            list[j] = arBaru[j];
        }
    }


    // cek di mana list baru di letakkan
    for (int i = 0; i < list.length; i++) {
        if (list[i] == null) {
            list[i] = tambah;
            break;
        }
    }
}


public static boolean fungsiHapus(Integer number) {
    // cek apakah yg dihapus apakah di luar kapasitas Array
    if ((number - 1) >= list.length) {
        return false;
    } else if (list[number - 1] ==  null) {
    // cek untuk apabila dia ada di urutan terakhir untuk mengisi 'nul' karena isi nya tersebut telah di pindahkan ke depan nya    
        return false;
    } else {
        for (int i = number - 1; i < list.length; i++) {
        if (i == (list.length - 1)) {
            list[i] = null;
        } else {
            // memindahkan list yg di belakang menjadi maju 1 langkah.
            list[i] = list[i + 1];
        }
    }

    return true;
}
}

public static String input(String perintah) {
    System.out.print(perintah + " : ");
    String data = scanner.nextLine();
    return data;
}


public static void viewTodolist() {

    while (true) {

    showTodolist();

    System.out.println("MENU : ");
    System.out.println("1. Tambah");
    System.out.println("2. Hapus");
    System.out.println("x. keluar");

    var toDo = input("Pilihan ");

    if (toDo.equals("1")) {
        viewTambah();
    } else if (toDo.equals("2")) {
        viewHapus();
    } else if (toDo.equals("x")) {
        break;    
    } else {
        System.err.println("ERROR!");
    }

    }
    

}


public static void viewHapus() {
    var hapus = input("Pilih no yang ingin dihapus ('x' untuk keluar)");

    if (hapus.equals("x")) {
        
    } else {
        boolean cekHapus = fungsiHapus(Integer.valueOf(hapus));
        if (!cekHapus) {
            System.out.println("Gagal menghapus : " + cekHapus);
        }
    }
}



public static void viewTambah() {
    System.out.println("TAMBAH TO-DO-LIST");
    var tambah = input("Masukkan To-do untuk ditambahkan ('x untukk keluar')");

    if (tambah.equals("x")) {
        
    } else {
        fungsiTambah(tambah);
    }
}


// Main Utama
public static void main(String[] args) {
  viewTodolist();
}
}