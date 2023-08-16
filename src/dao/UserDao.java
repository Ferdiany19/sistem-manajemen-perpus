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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void update(Integer id, User data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
