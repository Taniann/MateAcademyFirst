package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigDecimal;

public class Product  implements java.io.Serializable {
    private String productId;
    private String mfrId;
    private String description;
    private BigDecimal price;
    private BigDecimal qtyOnHand;

    public Product() {
    }

    public Product(String productId) {
        this.productId = productId;
    }

    public Product(String productId, String mfrId, String description, BigDecimal price, BigDecimal qtyOnHand) {
        this.productId = productId;
        this.mfrId = mfrId;
        this.description = description;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getMfrId() {
        return this.mfrId;
    }

    public void setMfrId(String mfrId) {
        this.mfrId = mfrId;
    }
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getQtyOnHand() {
        return this.qtyOnHand;
    }

    public void setQtyOnHand(BigDecimal qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        buffer.append("productId").append("='").append(getProductId()).append("' ");
        buffer.append("mfrId").append("='").append(getMfrId()).append("' ");
        buffer.append("description").append("='").append(getDescription()).append("' ");
        buffer.append("price").append("='").append(getPrice()).append("' ");
        buffer.append("qtyOnHand").append("='").append(getQtyOnHand()).append("' ");
        buffer.append("]");

        return buffer.toString();
    }
}

