package _06DefiningClasses._02Exercise._09CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        String command;
        while(!"End".equals(command = scanner.nextLine())) {
            String[] data = command.split(" ");

            String name = data[1];
            double stat = Double.parseDouble(data[2]);

            Cat cat;
            switch(data[0]) {
                case "Siamese":
                    cat = new Siamese(name, stat);
                    cats.put(name, cat);

                    break;
                case "Cymric":
                    cat = new Cymric(name, stat);
                    cats.put(name, cat);

                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, stat);
                    cats.put(name, cat);

                    break;
            }
        }

        String cat = scanner.nextLine();

        if(cats.containsKey(cat)) {
            Cat wantedCat = cats.get(cat);
            System.out.println(wantedCat);
        }
    }
}
