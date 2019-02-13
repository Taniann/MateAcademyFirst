package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Tania Nebesna on 12.02.2019.
 */
public class Order {
    private BigDecimal orderNum;
    private Product product;
    private LocalDate orderDate;
    private String mfr;
    private BigDecimal qty;
    private BigDecimal amount;

    public Order() {
    }

    public Order(BigDecimal orderNum, Product product) {
        this.orderNum = orderNum;
        this.product = product;
    }
    public Order(BigDecimal orderNum, Product product, LocalDate orderDate, String mfr, BigDecimal qty, BigDecimal amount) {
        this.orderNum = orderNum;
        this.product = product;
        this.orderDate = orderDate;
        this.mfr = mfr;
        this.qty = qty;
        this.amount = amount;
    }

    public BigDecimal getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public String getMfr() {
        return this.mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }
    public BigDecimal getQty() {
        return this.qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        buffer.append("orderNum").append("='").append(getOrderNum()).append("' ");
        buffer.append("product").append("='").append(getProduct()).append("' ");
        buffer.append("orderDate").append("='").append(getOrderDate()).append("' ");
        buffer.append("mfr").append("='").append(getMfr()).append("' ");
        buffer.append("qty").append("='").append(getQty()).append("' ");
        buffer.append("amount").append("='").append(getAmount()).append("' ");
        buffer.append("]");

        return buffer.toString();
    }

}
