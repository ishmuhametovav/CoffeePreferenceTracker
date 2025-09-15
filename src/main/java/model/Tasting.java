package model;

public class Tasting
{
    public enum GRADE{ D, C, B, A, S}

    private int id;
    private int userId;
    private int coffeeId;
    private GRADE grade;
    private String review;

    public Tasting(int id, int userId, int coffeeId, GRADE grade, String review)
    {
        this.id = id;
        this.userId = userId;
        this.coffeeId = coffeeId;
        this.grade = grade;
        this.review = review;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public int getCoffeeId() { return coffeeId; }
    public GRADE getGrade() { return grade; }
    public String getReview() { return review; }

    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setCoffeeId(int coffeeId) { this.coffeeId = coffeeId; }
    public void setGrade(GRADE grade) { this.grade = grade; }
    public void setReview(String review) { this.review = review; }
}
