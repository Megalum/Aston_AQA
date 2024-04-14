package task2;

public class Phone {
    private String name;
    private String number;

    public Phone(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
