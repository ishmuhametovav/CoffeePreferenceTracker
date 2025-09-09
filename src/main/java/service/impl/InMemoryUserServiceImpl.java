package service.impl;

import model.PasswordUtil;
import model.User;
import repository.InMemoryUserDAO;
import service.UserService;

public class InMemoryUserServiceImpl implements UserService
{
    private InMemoryUserDAO userDAO = new InMemoryUserDAO();
    @Override
    public User createUser(String firstName, String lastName, String age, String email, String plainPassword)
    {
        String hashPassword = PasswordUtil.hash(plainPassword);
        int _age = Integer.valueOf(age);
        return userDAO.createUser(firstName, lastName, _age, email, hashPassword);
    }
    @Override
    public User findUserByEmail(String email)
    {
        return userDAO.findUserByEmail(email);
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
