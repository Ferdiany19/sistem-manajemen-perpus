package services.user;

import java.util.List;

import dao.UserDao;
import exception.UserNotFoundException;
import models.User;

public class UserServiceImp implements UserService {

    UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        if (user.getUsername() == "") {
            throw new UserNotFoundException("Username Masih Kosong");
        }
        if (user.getEmail() == "") {
            throw new UserNotFoundException("Email Masih Kosong");
        }
        userDao.save(user);
        System.out.println("User berhasil ditambahkan!");
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        if (id > getAllUsers().size() || id < 1) {
            throw new UserNotFoundException("User tidak ditemukan");
        }
        return this.userDao.findById(id);
    }

}
