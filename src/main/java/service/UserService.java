package service;

import model.User;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.stream.IntStream;

public interface UserService
{
    User createUser(String firstName, String lastName, String age, String email, String plainPassword) throws IOException;

    User findUserById(int id) throws InvalidParameterException;

    User findUserByEmail(String email) throws InvalidParameterException;

    void updateUser(User user);

    void deleteUser(String email);
}
