package ua.mateacademy.tania.lesson6.tasklambda;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Tania Nebesna on 05.01.2019.
 */

public class Fruit implements Serializable {
    private FruitType fruitType;
    private int dayToLive;
    private LocalDate deliveryDate;
    private int price;
    private List<Vitamins> vitamins;

    public Fruit(FruitType fruitType, int dayToLive, LocalDate deliveryDate, int price, List<Vitamins> vitamins) {
        this.fruitType = fruitType;
        this.dayToLive = dayToLive;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.vitamins = vitamins;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public int getDayToLive() {
        return dayToLive;
    }

    public void setDayToLive(int dayToLive) {
        this.dayToLive = dayToLive;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Vitamins> getVitamins() {
        return vitamins;
    }

    public void setVitamins(List<Vitamins> vitamins) {
        this.vitamins = vitamins;
    }

    public String getFruitTypeAndPrice () {
        return fruitType + " " + price;
    }

    @Override
    public String toString() {
        return "Fruit [fruitType=" + fruitType + ", dayToLive=" + dayToLive + ", deliveryDate=" + deliveryDate
                + ", price=" + price + ", vitamins=" + vitamins + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dayToLive;
        result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
        result = prime * result + ((fruitType == null) ? 0 : fruitType.hashCode());
        result = prime * result + price;
        result = prime * result + ((vitamins == null) ? 0 : vitamins.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fruit other = (Fruit) obj;
        if (dayToLive != other.dayToLive)
            return false;
        if (deliveryDate == null) {
            if (other.deliveryDate != null)
                return false;
        } else if (!deliveryDate.equals(other.deliveryDate))
            return false;
        if (fruitType != other.fruitType)
            return false;
        if (price != other.price)
            return false;
        if (vitamins == null) {
            if (other.vitamins != null)
                return false;
        } else if (!vitamins.equals(other.vitamins))
            return false;
        return true;
    }

    //3. Зробити методи в класі фрукт що вертають checkable|unchecable exceptions  і їх обробляти
    // can be unchecable exceptions ArithmeticException if divider is 0
    public int dividePrice(int divider) {
        return this.price / divider;
    }

    //checked exceptions
    public static void openSomeFile(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            int i;
            while ((i = fileReader.read()) != -1) {
                System.out.println(i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ooops.. file is not found (");;
        } catch (IOException e) {
            System.out.println("something goes wrong");;
        }
    }


}
