package moves;

public class Moves {

    private int accuracy;
    private int basePower;
    private String category;
    private int pp;
    private int priority;
    private String type;
    private String name;

    public Moves(String name, int accuracy, int basePower, String category, int pp, int priority, String type) {
        this.name = name;
        this.accuracy = accuracy;
        this.basePower = basePower;
        this.category = category;
        this.pp = pp;
        this.priority = priority;
        this.type = type;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getBasePower() {
        return basePower;
    }

    public void setBasePower(int basePower) {
        this.basePower = basePower;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



