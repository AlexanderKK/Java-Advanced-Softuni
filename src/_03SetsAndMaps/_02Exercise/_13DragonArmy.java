package _03SetsAndMaps._02Exercise;

import javax.lang.model.type.NullType;
import java.util.*;

public class _13DragonArmy {
    protected static Map<String, TreeMap<String, LinkedHashMap<String, Integer>>> dragonsMap = new LinkedHashMap<>();
    protected static Map<String, LinkedHashMap<String, Double>> dragonsAvgStats;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        if(n >= 1 && n <= 100) {
            while(n-- > 0) {
                String[] input = scanner.nextLine().split(" ");

                String dragonType = input[0];
                String dragonName = input[1];

                String damageInput = input[2];
                String healthInput = input[3];
                String armorInput = input[4];

                dragonsMap.putIfAbsent(dragonType, new TreeMap<>());
                dragonsMap.get(dragonType).putIfAbsent(dragonName, new LinkedHashMap<>());

                int damage, health, armor;

                if(damageInput.equals(null + "")) {
                    damage = 45;
                } else {
                    damage = Integer.parseInt(input[2]);
                }

                if(healthInput.equals(null + "")) {
                    health = 250;
                } else {
                    health = Integer.parseInt(input[3]);
                }

                if(armorInput.equals(null + "")) {
                    armor = 10;
                } else {
                    armor = Integer.parseInt(input[4]);
                }

                dragonsMap.get(dragonType).get(dragonName).put("damage", damage);
                dragonsMap.get(dragonType).get(dragonName).put("health", health);
                dragonsMap.get(dragonType).get(dragonName).put("armor", armor);
            }

            //Initialize a map containing dragon type and average stats
            dragonsAvgStats = getAverageDragonsStats();

            //Print all data about dragons
            printDragonsData();
        }
    }

    private static void printDragonsData() {
        dragonsMap.forEach((dragonType, dragonNames) -> {
            //Get average stats from average stats map with dragon type key
            LinkedHashMap<String, Double> avgDragonStats = dragonsAvgStats.get(dragonType);

            //Extract values from keys in average dragons map
            double avgDamage = avgDragonStats.get("damage");
            double avgHealth = avgDragonStats.get("health");
            double avgArmor = avgDragonStats.get("armor");

            //Print average stats for dragon type
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", dragonType, avgDamage, avgHealth, avgArmor);

            dragonNames.forEach((dragonName, stats) -> {
                //Print dragon name
                System.out.printf("-%s -> ", dragonName);

                StringBuilder statsBuilder = new StringBuilder();
                stats.forEach((stat, value) -> {
                    //Print dragon stats
                    statsBuilder.append(String.format("%s: %d, ", stat, value));
                });

                //Get string without ", "
                String subStr = statsBuilder.substring(0, statsBuilder.length() - 2);

                //Clear string
                statsBuilder.delete(0, statsBuilder.length());

                //Set new string
                statsBuilder.append(subStr);

                //Print dragon stats without last ", "
                System.out.println(statsBuilder);
            });
        });
    }

    private static Map<String, LinkedHashMap<String, Double>> getAverageDragonsStats() {
        Map<String, LinkedHashMap<String, Double>> avgStats = new LinkedHashMap<>();

        for (String type : dragonsMap.keySet()) {
            TreeMap<String, LinkedHashMap<String, Integer>> dragons = dragonsMap.get(type);

            int sumDamage = 0, sumHealth = 0, sumArmor = 0;

            //Sum damage, health and armor from every dragon
            for (String dragon : dragons.keySet()) {
                LinkedHashMap<String, Integer> stats = dragons.get(dragon);

                sumDamage += stats.get("damage");
                sumHealth += stats.get("health");
                sumArmor += stats.get("armor");
            }

            //Get average stats from the group of dragons
            double avgDamage = 1.0 * sumDamage / dragons.size();
            double avgHealth = 1.0 * sumHealth / dragons.size();
            double avgArmor = 1.0 * sumArmor / dragons.size();

            //Add to map with average stats for every dragon type
            avgStats.put(type, new LinkedHashMap<>() {{
                put("damage", avgDamage);
                put("health", avgHealth);
                put("armor", avgArmor);
            }});
        }

        return avgStats;
    }
}
