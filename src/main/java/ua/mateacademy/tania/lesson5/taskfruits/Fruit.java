package ua.mateacademy.tania.lesson5.taskfruits;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Tania Nebesna on 04.01.2019.
 */
public class Fruit {
    private FruitKind kind;
    private int expirationDateInDays;
    private LocalDate deliveryDate;
    private BigDecimal price;

    public Fruit(FruitKind kind, int expirationDateInDays, LocalDate deliveryDate, BigDecimal price) {
        this.kind = kind;
        this.expirationDateInDays = expirationDateInDays;
        this.deliveryDate = deliveryDate;
        this.price = price;
    }

    public FruitKind getKind() {
        return kind;
    }

    public int getExpirationDate() {
        return expirationDateInDays;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "kind=" + kind +
                ", expirationDateInDays=" + expirationDateInDays +
                ", deliveryDate=" + deliveryDate +
                ", price=" + price +
                '}';
    }
}
