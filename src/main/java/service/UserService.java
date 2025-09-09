package service;

import model.User;

import java.util.stream.IntStream;

public interface UserService
{
    User createUser(String firstName, String lastName, String age, String email, String plainPassword);

    User findUserByEmail(String email);

    void updateUser(User user);

    void deleteUser(String email);
}
