package Lesson2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Иванов Иван Иванович", "Инженер", "ivan@gmail.com", "+375299652341", 2500.0, (byte) 47));
        employees.add(new Employee("Семенов Семен Семенович", "Бухгалтер", "sem@gmail.com", "+375335842102", 1800.0, (byte) 55));
        employees.add(new Employee("Сергеев Сергей Сергеевич", "Программист", "serega@gmail.com", "+375292541585", 2800.0, (byte) 36));
        employees.add(new Employee("Грак Станислав Станиславович", "Директор", "grak@gmail.com", "+375449852653", 3700.0, (byte) 45));
        employees.add(new Employee("Синичкика Светлана Васильевна", "Уборщик", "sinica@gmail.com", "+375254832651", 1200.0, (byte) 52));

        for( Employee out: employees){
            out.getEmployee();
        }

        System.out.println("\n\n");

        Park park = new Park();
        park.addAttractions(new Park.Attraction("Горки", "10:30 - 18:00", 20.5));
        System.out.println(park);
    }
}
