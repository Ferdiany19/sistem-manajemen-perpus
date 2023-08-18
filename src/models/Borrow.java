package models;

import java.time.LocalDate;

public class Borrow {
    private Book book;
    private User user;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;

    public Borrow(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Borrow [book=" + book + ", user=" + user + ", tanggalPinjam=" + tanggalPinjam + ", tanggalKembali="
                + tanggalKembali + "]";
    }

    public Borrow() {
    }

}
