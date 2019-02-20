package ua.mateacademy.tania.patterns.decorator;

import java.math.BigDecimal;

public class Laptop implements Product {
    private BigDecimal price;

    public Laptop(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
