package _06DefiningClasses._02Exercise._09CatLady;

public class Cymric extends Cat {
    private double furLength;
    public Cymric(String name, double stat) {
        super(name);
        furLength = stat;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", className(), name(), furLength);
    }
}
