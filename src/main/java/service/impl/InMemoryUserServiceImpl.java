package service.impl;

import model.PasswordUtil;
import model.User;
import repository.InMemoryUserDAO;
import service.UserService;

import java.io.IOException;
import java.security.InvalidParameterException;

public class InMemoryUserServiceImpl implements UserService
{
    private InMemoryUserDAO userDAO = new InMemoryUserDAO();
    @Override
    public User createUser(String firstName, String lastName, String age, String email, String plainPassword) throws IOException
    {
        String hashPassword = PasswordUtil.hash(plainPassword);
        int _age = Integer.valueOf(age);
        if(_age <= 0) throw new IOException("Age must be higher than zero!");
        return userDAO.createUser(firstName, lastName, _age, email, hashPassword);
    }
    @Override
    public User findUserById(int id) throws InvalidParameterException
    {
        User user = userDAO.findUserById(id);
        if(user == null) throw new InvalidParameterException("User with such id doesn't exist");
        return user;
    }
    @Override
    public User findUserByEmail(String email) throws InvalidParameterException
    {
        User user = userDAO.findUserByEmail(email);
        if(user == null) throw new InvalidParameterException("User with such id doesn't exist");
        return user;
    }
    @Override
    public void updateUser(User user)
    {
        userDAO.updateUser(user);
    }
    @Override
    public void deleteUser(String email)
    {
        userDAO.deleteUser(email);
    }
}
