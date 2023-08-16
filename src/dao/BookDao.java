package dao;

import java.util.ArrayList;
import java.util.List;

import models.Book;
import services.BaseDao;

public class BookDao implements BaseDao<Book, Integer> {
    List<Book> books = new ArrayList<>();

    @Override
    public void save(Book data) {
        books.add(data);
    }

    @Override
    public List<Book> findAll() {
        return this.books;
    }

    @Override
    public Book findById(Integer id) {
        return this.books.get(id - 1);
    }

    @Override
    public void update(Integer id, Book data) {
        books.set(id - 1, data);
    }

    @Override
    public void delete(Integer id) {
        books.remove(id - 1);
    }

}
