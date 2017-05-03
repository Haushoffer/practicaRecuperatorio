package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.User;

/**
 * Created by JOEL on 30/04/2017.
 */
public interface UserService {
    Iterable<User> listAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);
}
