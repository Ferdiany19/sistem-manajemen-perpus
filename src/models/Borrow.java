package models;

import java.time.LocalDate;

public class Borrow {
    private Book book;
    private User peminjam;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;

    public Borrow(Book book, User peminjam, LocalDate tanggalPinjam, LocalDate tanggalKembali) {
        this.book = book;
        this.peminjam = peminjam;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(User peminjam) {
        this.peminjam = peminjam;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(LocalDate tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(LocalDate tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    @Override
    public String toString() {
        return "Borrow [book=" + book + ", peminjam=" + peminjam + ", tanggalPinjam=" + tanggalPinjam
                + ", tanggalKembali=" + tanggalKembali + "]";
    }

}
