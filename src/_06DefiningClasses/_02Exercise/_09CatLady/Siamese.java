package _06DefiningClasses._02Exercise._09CatLady;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, double stat) {
        super(name);
        earSize = stat;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", className(), name(), earSize);
    }
}
