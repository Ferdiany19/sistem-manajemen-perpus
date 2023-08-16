package services.user;

import java.util.List;

import dao.UserDao;
import models.User;

public class UserServiceImp implements UserService {

    UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        userDao.save(user);
        System.out.println("User berhasil ditambahkan!");
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

}
