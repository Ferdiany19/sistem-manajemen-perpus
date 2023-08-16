package services.book;

import java.util.List;

import models.Book;

public interface BookService {
    void createBook(Book book);

    List<Book> getAllBook();

    Book getBookById(Integer id);

    void updateBook(Integer id, Book book);

    void deleteBook(Integer id);
}
