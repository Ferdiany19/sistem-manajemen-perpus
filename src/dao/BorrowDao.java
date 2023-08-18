package dao;

import java.util.ArrayList;
import java.util.List;

import models.Borrow;
import services.BaseDao;

public class BorrowDao implements BaseDao<Borrow, Integer> {
    List<Borrow> borrows = new ArrayList<>();

    @Override
    public void save(Borrow data) {
        borrows.add(data);
    }

    @Override
    public List<Borrow> findAll() {
        return this.borrows;
    }

    @Override
    public Borrow findById(Integer id) {
        return this.borrows.get(id - 1);
    }

    @Override
    public void update(Integer id, Borrow data) {
        borrows.set(id - 1, data);
    }

    @Override
    public void delete(Integer id) {
        borrows.remove(id - 1);
    }

}
