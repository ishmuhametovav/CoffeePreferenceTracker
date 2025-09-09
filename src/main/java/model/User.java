package model;

public class User
{
    private String firstName;

    private String lastName;

    private int age;

    private String email;

    private String hashPassword;

    public User(String firstName, String lastName, int age, String email, String hashPassword)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.hashPassword = hashPassword;
    }

    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public int getAge(){ return age; }
    public String getEmail(){ return email; }
    public String getHashPassword(){ return hashPassword; }

    public void getFirstName(String firstName){ this.firstName = firstName; }
    public void getLastName(String lastName){ this.lastName = lastName; }
    public void getAge(int age){ this.age = age; }
    public void getEmail(String email){ this.email = email; }
    public void getHashPassword(String hashPassword){ this.hashPassword = hashPassword; }
}
