package services.user;

import java.util.List;

import models.User;

public interface UserService {
    void createUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);
}
