package histogram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //читаем из файла
        String input = "";
        try ( FileReader fr = new FileReader("input");
             BufferedReader reader = new BufferedReader(fr)){
            String line = "";
            while (line != null) {
                input += line;
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //заполняем символами
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            Character symbol = input.charAt(i);
            if (symbol != ' ') {
                if (!map.containsKey(symbol)) {
                    map.put(symbol, count);
                }
                else {
                    map.put(symbol, map.get(symbol) + 1);
                }
            }

        }
        //сортируем HashMap
        Map<Character, Integer> sortedMap = new TreeMap<Character, Integer>(map);
        //sortedMap.entrySet().forEach(System.out::println);

        //находим максимальное value
        int maxValue = sortedMap.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get().getValue();
        //выводим гистограмму
        for (int j = maxValue; j > 0; j--) {
            for (Map.Entry entry: sortedMap.entrySet()) {
                if (j <= (int)entry.getValue()) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (Map.Entry entry: sortedMap.entrySet()) {
            System.out.print(entry.getKey());
        }
    }
}