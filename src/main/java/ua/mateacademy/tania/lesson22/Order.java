package ua.mateacademy.tania.lesson22;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
;

/**
 * Created by Tania Nebesna on 12.02.2019.
 */

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
    private BigDecimal orderNum;
    private String product;
    private Date orderDate;
    private String mfr;
    private BigDecimal qty;
    private BigDecimal amount;

    public Order() {
    }

    public Order(BigDecimal orderNum, String product, Date orderDate, String mfr, BigDecimal qty, BigDecimal amount) {
        this.orderNum = orderNum;
        this.product = product;
        this.orderDate = orderDate;
        this.mfr = mfr;
        this.qty = qty;
        this.amount = amount;
    }

    @Id
    @Column(name = "order_num", nullable = false, unique = true, precision = 22)
    public BigDecimal getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    @Column(name = "product")
    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE", length = 7)
    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name = "MFR", length = 3)
    public String getMfr() {
        return this.mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    @Column(name = "QTY", precision = 22)
    public BigDecimal getQty() {
        return this.qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    @Column(name = "AMOUNT", precision = 22)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderNum, order.orderNum) &&
                Objects.equals(product, order.product) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(mfr, order.mfr) &&
                Objects.equals(qty, order.qty) &&
                Objects.equals(amount, order.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNum, product, orderDate, mfr, qty, amount);
    }
}
