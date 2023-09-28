package _06DefiningClasses._02Exercise._09CatLady;

public class StreetExtraordinaire extends Cat {
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double stat) {
        super(name);
        decibelsOfMeows = stat;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", className(), name(), decibelsOfMeows);
    }
}
