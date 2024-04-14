package task1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1 {

    public static void run(){
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "tree", "two", "four", "five",
                "six", "seven", "five", "six", "five", "five", "six", "four"));


        System.out.println("Список уникальных слов:");
        for (String out: unique(list)){
            System.out.print(out + "  ");
        }

        System.out.println("\n\nСписок слов и количество их повторений:");
        for (String out: counting(list).keySet()){
            System.out.printf("%s - %d\n", out, counting(list).get(out).intValue());
        }


    }

    private static Map<String, Long> counting(List<String> list){
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static List<String> unique(List<String> list){
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
