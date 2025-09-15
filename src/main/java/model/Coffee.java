package model;

public class Coffee
{
    public enum Roast{ LIGHT, MEDIUM, DARK }
    public enum Processing{ WASHED, NATURAL, HONEY }

    private int id;
    private String name;
    private String origin;
    private String variety;
    private Processing processing;
    private Roast roastLevel;

    public Coffee(int id, String name, String origin, String variety, Processing processing, Roast roastLevel)
    {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.variety = variety;
        this.processing = processing;
        this.roastLevel = roastLevel;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }
    public String getVariety() { return variety; }
    public void setVariety(String variety) { this.variety = variety; }
    public Processing getProcessing() { return processing; }
    public void setProcessing(Processing processing) { this.processing = processing; }
    public Roast getRoastLevel() { return roastLevel; }
    public void setRoastLevel(Roast roastLevel) { this.roastLevel = roastLevel; }
}

