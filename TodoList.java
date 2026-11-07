public class TodoList {

// Array untuk menampung isi to-do-list
    public static String[] list = new String[10];

public static void showTodolist() {

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


public static void viewTodolist() {

}

public static void viewHapus() {

}

public static void viewTambah() {

}

public static void main(String[] args) {
   
}
}