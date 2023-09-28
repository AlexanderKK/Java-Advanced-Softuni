package _03SetsAndMaps._02Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _11LegendaryFarming {
    public static Map<String, Integer> keyMaterials = new TreeMap<>();
    public static Map<String, Integer> junkMaterials = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lineCounter = 0;
        boolean isGameOver = false;
        String legendaryItem = "";

        String command;
        while(!"".equals(command = scanner.nextLine())) {
            //Break if lines are more than 10
            lineCounter++;
            if(lineCounter > 10) {
                break;
            }

            String[] inputLine = command.split(" ");
            if(inputLine.length <= 50) {   //If pairs are more than 25, don't read line
                String material;
                int quantity = 0;

                for (int i = 0; i < inputLine.length; i++) {
                    if(i % 2 == 0) {
                        quantity = Integer.parseInt(inputLine[i]);   //Get element on the left
                    } else {
                        material = inputLine[i].toLowerCase();   //Get element on the right

                        //Check if material is key material or junk material
                        if(material.equals("fragments") || material.equals("shards") || material.equals("motes")) {
                            //Add key material to map and its quantity
                            keyMaterials.putIfAbsent(material, 0);
                            keyMaterials.put(material, keyMaterials.get(material) + quantity);

                            //If material has a quantity equal or over 250 ->
                            //Obtain legendary item subtract 250 from the material qty and exit loops
                            if(keyMaterials.containsKey(material) && keyMaterials.get(material) >= 250) {
                                legendaryItem = getLegendaryItem(material);
                                keyMaterials.put(material, keyMaterials.get(material) - 250);
                                isGameOver = true;
                                break;
                            }
                        } else {
                            //Add junk material to map and its quantity
                            junkMaterials.putIfAbsent(material, 0);
                            junkMaterials.put(material, junkMaterials.get(material) + quantity);
                        }
                    }
                }

                if(isGameOver) {
                    addMissingKeyMaterials(keyMaterials);
                    break;
                }
            }
        }

        printMaterials(legendaryItem);
    }

    private static void printMaterials(String legendaryItem) {
        //Print legendary item
        System.out.printf("%s obtained!%n", legendaryItem);

        //Sort key materials by quantity in descending order
        LinkedHashMap<String, Integer> sortedMaterialsMap = keyMaterials.entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        //Print key materials
        sortedMaterialsMap.forEach((material, quantity) -> System.out.printf("%s: %d%n", material, quantity));

        //Print junk materials
        junkMaterials.forEach((material, quantity) -> System.out.printf("%s: %d%n", material, quantity));
    }

    private static void addMissingKeyMaterials(Map<String, Integer> keyMaterials) {
        if(!keyMaterials.containsKey("fragments")) {
            keyMaterials.put("fragments", 0);
        }

        if(!keyMaterials.containsKey("shards")) {
            keyMaterials.put("shards", 0);
        }

        if(!keyMaterials.containsKey("motes")) {
            keyMaterials.put("motes", 0);
        }
    }

    private static String getLegendaryItem(String material) {
        if(material.equals("fragments")) {
            return "Valanyr";
        } else if(material.equals("shards")) {
            return "Shadowmourne";
        } else if(material.equals("motes")) {
            return "Dragonwrath";
        }
        return "";
    }
}
