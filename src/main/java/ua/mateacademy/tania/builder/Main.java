package ua.mateacademy.tania.builder;

/**
 * Created by Таня on 23.12.2018.
 */
public class Main {
    public static void main(String[] args) {
/*        Person person = Person.builder().withId(1).withName("name").withAge(20).build();
        System.out.println(person.toString());
        A a  = A.builder().setId(1).setName("Name").createA();
        System.out.println(a.toString());

        SportCar sportCar = new SportCar.Builder("Audi").setColor("black").setMaxSpeed("300").built();
        System.out.println(sportCar.getName());
        System.out.println(sportCar.getColor());
        System.out.println(sportCar.getMaxSpeed());*/
        FootballTeam footballTeam = FootballTeam.builder().setBack("smth").build();

        InfoCar infoCar = InfoCar.builder()
                                 .brand("Mercedes")
                                 .model("GLS")
                                 .color("White")
                                 .year(2018)
                                 .hp(340)
                                 .build();
    }
}
