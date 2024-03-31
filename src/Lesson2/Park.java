package Lesson2;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private final String name;
    private final List<Attraction> attractions;
    static class Attraction{
         private final String title;
         private final String workTime;
         private final double prise;

        public Attraction(String title, String workTime, double prise) {
            this.title = title;
            this.workTime = workTime;
            this.prise = prise;
        }

        public String getTitle() {
            return title;
        }

        public String getWorkTime() {
            return workTime;
        }

        public double getPrise() {
            return prise;
        }

        @Override
        public String toString() {
            return "    Аттракцион: '" + title +
                    "'\n    время работы: " + workTime +
                    " \n    цена: " + prise + '\n';
        }
    }

    public Park() {
        name = "Григорий";
        attractions = new ArrayList<>();
        attractions.add(new Attraction("Карусель", "10:00 - 22:00", 10.5));
        attractions.add(new Attraction("Качели" , "Круглосуточно", 0));
    }

    public String getName() {
        return name;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    @Override
    public String toString() {
        String message ="Парк: '" + name + '\'' + "\n";
        for (Attraction out: attractions)
        {
            message += out;
        }
        return message;
    }

    public void addAttractions(Attraction attraction){
        attractions.add(attraction);
    }
}
