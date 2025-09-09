package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InMemoryUserDAO
{
    private List<User> users = new ArrayList<>();

    public User createUser(String firstName, String lastName, int age, String email, String hashPassword)
    {
        User user = new User(firstName, lastName, age, email, hashPassword);
        users.add(user);
        return user;
    }

    public User findUserByEmail(String email)
    {
        User user = users.stream().filter(element -> element.getEmail().equals(email))
                .findFirst().orElse(null);

        return user;
    }

    public void updateUser(User user)
    {
        int userIndex = IntStream.range(0, users.size())
                .filter(index -> users.get(index).getEmail().equals(user.getEmail()))
                .findFirst()
                .orElse(-1);

        if(userIndex != -1) users.set(userIndex, user);
    }

    public void deleteUser(String email)
    {
        User user = findUserByEmail(email);
        users.remove(user);
    }
}
