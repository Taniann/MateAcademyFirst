package ua.mateacademy.tania.patterns.decorator;

import java.math.BigDecimal;

public interface Product {
    BigDecimal getPrice();
    void setPrice(BigDecimal price);
}
