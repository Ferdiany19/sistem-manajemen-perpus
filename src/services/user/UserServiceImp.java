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
            throw new UserNotFoundException("Username masih kosong!");
        }
        if (user.getEmail() == "") {
            throw new UserNotFoundException("Email masih kosong!");
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
        if (id > getAllUsers().size()) {
            throw new UserNotFoundException("User tidak ditemukan");
        }
        return this.userDao.findById(id);
    }

}
