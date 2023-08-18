package services.book;

import java.util.List;

import dao.BookDao;
import exception.BookNotFoundException;
import models.Book;

public class BookServiceImp implements BookService {
    BookDao bookDao;

    public BookServiceImp(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void createBook(Book book) {
        if (book.getJudul() == "") {
            throw new BookNotFoundException("Judul buku Masih Kosong");
        }
        if (book.getPenerbit() == "") {
            throw new BookNotFoundException("Penerbit buku Masih Kosong");
        }
        if (book.getPengarang() == "") {
            throw new BookNotFoundException("Pengarang Buku Masih Kosong");
        }

        bookDao.save(book);
        System.out.println("Buku berhasil ditambahkan!");
    }

    @Override
    public List<Book> getAllBook() {
        return bookDao.findAll();

    }

    @Override
    public Book getBookById(Integer id) {
        if (id > bookDao.findAll().size() || id < 1) {
            throw new BookNotFoundException("Buku tidak ditemukan");
        }
        return bookDao.findById(id);
    }

    @Override
    public void updateBook(Integer id, Book book) {
        bookDao.update(id, book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.delete(id);
    }

}
