package ua.mateacademy.tania.patterns.decorator;

import java.math.BigDecimal;

public class PriceDiscountDecorator implements Product {
    private int discountInPercent;
    private Product product;

    public PriceDiscountDecorator(int discountInPercent, Product product) {
        this.discountInPercent = discountInPercent;
        this.product = product;
    }

    @Override
    public BigDecimal getPrice() {
        return (product.getPrice().multiply(BigDecimal.valueOf(discountInPercent))).
                divide(BigDecimal.valueOf(100));

    }

    @Override
    public void setPrice(BigDecimal price) {
        product.setPrice(getPrice());
    }
}
