package ua.mateacademy.tania.builder;

/**
 * Created by Таня on 23.12.2018.
 */
public class Person {
    private int id;
    private String name;
    private int age;

    private Person(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

   public static final class Builder {
       private int id;
       private String name;
       private int age;

       private Builder() {
       }

       public Builder withId(int id) {
           this.id = id;
           return this;
       }

       public Builder withName(String name) {
           this.name = name;
           return this;
       }

       public Builder withAge(int age) {
           this.age = age;
           return this;
       }

       public Person build() {
           return new Person(this);
       }
   }
}
