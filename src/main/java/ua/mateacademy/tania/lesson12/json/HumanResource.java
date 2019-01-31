package ua.mateacademy.tania.lesson12.json;

/**
 * Created by Tania Nebesna on 24.01.2019.
 */
public class HumanResource extends Person {
    private int startWorkYear;

    public HumanResource() {
        super();
    }

    public HumanResource(Integer id, String name, String surname, int yearOfBorn, int startWorkYear) {
        super(id, name, surname, yearOfBorn);
        this.startWorkYear = startWorkYear;
    }

    public int getStartWorkYear() {
        return startWorkYear;
    }

    public void setStartWorkYear(int startWorkYear) {
        this.startWorkYear = startWorkYear;
    }

    @Override
    public String toString() {
        return "HumanResource [startWorkYear=" + startWorkYear + ", " + super.toString() + "]";
    }
}
