package services.book;

import java.util.List;

import dao.BookDao;
import models.Book;

public class BookServiceImp implements BookService {
    BookDao bookDao;

    public BookServiceImp(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void createBook(Book book) {
        if (book.getJudul() == "") {
            // Exception
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
