package dao;

import java.util.ArrayList;
import java.util.List;

import models.User;
import services.BaseDao;

public class UserDao implements BaseDao<User, Integer> {
    List<User> users = new ArrayList<>();

    @Override
    public void save(User data) {
        users.add(data);
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public User findById(Integer id) {
        return this.users.get(id - 1);
    }

    @Override
    public void update(Integer id, User data) {
        this.users.set(id - 1, data);
    }

    @Override
    public void delete(Integer id) {
        this.users.remove(id - 1);
    }

}
