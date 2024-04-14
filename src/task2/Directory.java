package task2;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private List<Phone> book;

    public Directory() {
        book = new ArrayList<>();
    }

    public void add(Phone phone){
        book.add(phone);
    }

    public void get(String name){
        book.stream()
                .filter(e -> e.equals(name))
                .forEach(e -> System.out.println(e.getName() + ": " + e.getNumber()));
    }
}
