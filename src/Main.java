import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import dao.BorrowDao;
import dao.UserDao;
import models.Book;
import models.Borrow;
import models.User;
import services.book.BookService;
import services.book.BookServiceImp;
import services.borrow.BorrowService;
import services.borrow.BorrowServiceImp;
import services.user.UserService;
import services.user.UserServiceImp;

public class Main {

    static BookDao bookDao = new BookDao();
    static BookService bookService = new BookServiceImp(bookDao);

    static UserDao userDao = new UserDao();
    static UserService userService = new UserServiceImp(userDao);

    static BorrowDao borrowDao = new BorrowDao();
    static BorrowService borrowService = new BorrowServiceImp(borrowDao);

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String choice;
        Boolean repeat = true;

        try {
            while (repeat) {
                mainMenu();
                choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        tambahBuku(scanner);
                        break;
                    case "2":
                        lihatDaftarBuku(scanner);
                        break;
                    case "3":
                        cariBuku(scanner);
                        break;
                    case "4":
                        hapusBuku(scanner);
                        break;
                    case "5":
                        break;
                    case "6":
                        tambahAnggota(scanner);
                        break;
                    case "7":
                        pinjamBuku(scanner);
                        break;
                    case "8":
                        kembaliBuku(scanner);
                        break;
                    default:
                        System.out.println("Input salah!");
                        break;
                }

                while (true) {
                    System.out.print("Kembali ke Main Menu? (Y/t)");
                    String ulangi = scanner.nextLine();
                    if ("y".equalsIgnoreCase(ulangi)) {
                        // ulang = true;
                        break;
                    } else if ("t".equalsIgnoreCase(ulangi)) {
                        repeat = false;
                        break;
                    } else {
                        System.out.println("Input salah!");
                        continue;
                    }
                }
            }

            System.out.println("Terimakasi!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void mainMenu() {
        System.out.println("""
                === SISTEM MANAJEMEN PERPUSTAKAAN ===
                1. Tambah Buku
                2. Lihat Daftar Buku
                3. Cari Buku
                4. Hapus Buku
                5. Edit Buku (unimplemented)
                6. Tambah Anggota
                7. Pinjam Buku
                8. Kembalikan Buku
                """);
        System.out.print("Masukkan pilihan: ");
    }

    private static void tambahAnggota(Scanner scanner) {
        System.out.println("=====TAMBAH ANGGOTA=======");
        User user = new User();

        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();

        for (int i = 0; i < 1; i++) {
            user = new User(username, email);
            userService.createUser(user);
        }

        List<User> resultsUser = userService.getAllUsers();
        for (int i = 0; i < resultsUser.size(); i++) {
            System.out.println((i + 1) + ". " + resultsUser.get(i));
        }
    }

    private static void tambahBuku(Scanner scanner) {
        // Scanner scanner = new Scanner(System.in);
        System.out.println("=====TAMBAH BUKU=======");
        Book book = new Book();

        System.out.print("Masukkan Judul: ");
        String judul = scanner.nextLine();

        System.out.print("Masukkan Penerbit: ");
        String penerbit = scanner.nextLine();

        System.out.print("Masukkan Penulis: ");
        String penulis = scanner.nextLine();

        for (int i = 0; i < 1; i++) {
            book = new Book(judul, penerbit, penulis);
            bookService.createBook(book);
        }

        // tampilkan list buku
        List<Book> resultsListBooks = bookService.getAllBook();
        for (int i = 0; i < resultsListBooks.size(); i++) {
            System.out.println((i + 1) + ". " + resultsListBooks.get(i));
        }

    }

    private static void lihatDaftarBuku(Scanner scanner) {
        // Scanner scanner = new Scanner(System.in);
        System.out.println("========DAFTAR BUKU=========\n\n");

        List<Book> results = bookService.getAllBook();
        if (results.isEmpty()) {
            System.out.println("Data masih kosong!");
        } else {
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i) + "\n\n");
            }
        }
    }

    private static void cariBuku(Scanner scanner) {
        System.out.println("========CARI BUKU=========\n\n");

        // list buku dan id nya
        List<Book> results = bookService.getAllBook();
        if (results.isEmpty()) {
            System.out.println("Data masih kosong!");
        } else {
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i) + "\n\n");
            }

            System.out.print("Masukkan ID yang mau dicari: ");
            Integer pilihBuku = Integer.valueOf(scanner.nextLine());
            Book hasil = bookService.getBookById(pilihBuku);
            System.out.println(hasil);
        }
    }

    private static void hapusBuku(Scanner scanner) {
        System.out.println("========HAPUS BUKU=========\n\n");

        // list buku yang ditampilkam
        List<Book> results = bookService.getAllBook();
        if (results.isEmpty()) {
            System.out.println("Data masih kosong!");
        } else {
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i) + "\n\n");
            }

            System.out.println("0. Batal");

            System.out.print("Masukkan ID yang mau di hapus: ");
            Integer pilihBuku = Integer.valueOf(scanner.nextLine());
            if (pilihBuku != 0) {
                bookService.deleteBook(pilihBuku);
                if (results.isEmpty()) {
                    System.out.println("Datanya kosong!");
                } else {
                    System.out.println("========DAFTAR BUKU SAAT INI=========");
                    for (int i = 0; i < results.size(); i++) {
                        System.out.println((i + 1) + ". " + results.get(i) + "\n\n");
                    }
                }
            } else {
                mainMenu();
            }
        }
    }

    private static void pinjamBuku(Scanner scanner) {

        List<Book> results = bookService.getAllBook();
        List<User> resultsUser = userService.getAllUsers();
        if (results.isEmpty() || resultsUser.isEmpty()) {
            System.out.println("Data masih kosong!");
        } else {
            // tampilkan daftar buku
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i) + "\n\n");

            }
            // tampilkan daftar user
            for (int i = 0; i < resultsUser.size(); i++) {
                System.out.println((i + 1) + ". " + resultsUser.get(i) + "\n\n");
            }

            System.out.println("Masukkan ID buku: ");
            Integer idBuku = Integer.valueOf(scanner.nextLine());
            Book bookBorrowed = bookService.getBookById(idBuku);
            System.out.println("Masukkan ID User: ");
            Integer idUser = Integer.valueOf(scanner.nextLine());
            User userBorrowed = userService.getUserById(idUser);

            Borrow borrow = new Borrow(bookBorrowed, userBorrowed);
            borrowService.createBorrow(borrow);
            System.out.println("Buku telah dipinjam");

            System.out.println("=====BUKU YANG TELAH DIPINJAM=======");
            List<Borrow> result = borrowService.getAllBorrow();
            for (int i = 0; i < result.size(); i++) {
                System.out.println((i + 1) + ". " + result.get(i));
            }
        }
    }

    private static void kembaliBuku(Scanner scanner) {

        List<Borrow> result = borrowService.getAllBorrow();
        for (int i = 0; i < result.size(); i++) {
            System.out.println((i + 1) + ". " + result.get(i));
        }

        System.out.print("Masukkan ID peminjaman: ");
        Integer idBorrowed = Integer.valueOf(scanner.nextLine());
        Borrow pengembalianBuku = borrowService.getBorrowById(idBorrowed);
        borrowService.returnBook(idBorrowed, pengembalianBuku);

        System.out.println("=====BUKU YANG TELAH DIKEMBALIKAN========");
        List<Borrow> results = borrowService.getAllBorrow();
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + result.get(i));
        }
    }
}
