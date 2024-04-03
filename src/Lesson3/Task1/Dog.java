package Lesson3.Task1;

public class Dog extends Animal {

    private static long countDog;
    public Dog(String name) {
        super(name);
        countDog++;
    }

    @Override
    public void run(int count){
        String out = count > 500 ? getName() + " устал после 500м" : getName() + " пробежал " + count + "м";
        System.out.println(out);
    }

    @Override
    public void sail(int count){
        String out = count > 10 ? getName() + " устал после 10м" : getName() + " проплыл " + count + "м";
        System.out.println(out);
    }

    @Override
    public String toString() {
        return "Собака: " + getName();
    }

    public static long getCount() {
        return countDog;
    }

}
