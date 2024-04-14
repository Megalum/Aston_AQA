package task2;

public class Task2 {

    public static void run(){
        Directory directory = new Directory();

        directory.add(new Phone("Иванов", "+375298660562"));
        directory.add(new Phone("Пертов", "+375339548521"));
        directory.add(new Phone("Сидоров", "+375296584123"));
        directory.add(new Phone("Иванов", "+375448521452"));
        directory.add(new Phone("Гречников", "+375256585452"));
        directory.add(new Phone("Петров", "+375298965852"));
        directory.add(new Phone("Романюк", "+375336542121"));
        directory.add(new Phone("Иванов", "+375251234567"));
        directory.add(new Phone("Пырх", "+375299658302"));
        directory.add(new Phone("Пырх", "+375440002540"));

        directory.get("Иванов");
        System.out.println("\n");
        directory.get("Пертов");
        System.out.println("\n");
        directory.get("Сидоров");
        System.out.println("\n");
        directory.get("Гречников");
        System.out.println("\n");
        directory.get("Пырх");
        System.out.println("\n");
    }
}
