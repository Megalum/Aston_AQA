package Lesson2;

public class Employee {
    private String name;
    private String post;
    private String eMail;
    private String phone;
    private double salary;
    private byte age;

    public Employee(String name, String post, String eMail, String phone, double salary, byte age) {
        this.name = name;
        this.post = post;
        this.eMail = eMail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void getEmployee(){
        System.out.println(this + "\n");
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    public byte getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Сотрудник: " + name + ", возраст: " + age + ", состоит на должности: " + post +
                " и имеет зарплату: " + salary + "\nEmail для связи: " + eMail +
                "\nТелефон для связи: " + phone;
    }
}
