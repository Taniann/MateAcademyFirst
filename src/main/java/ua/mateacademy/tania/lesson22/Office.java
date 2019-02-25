package ua.mateacademy.tania.lesson22;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "OFFICES")
public class Office implements java.io.Serializable {

    private BigDecimal office;
    private String city;
    private String region;
    private BigDecimal target;
    private BigDecimal sales;

    public Office() {
    }

    public Office(BigDecimal office, String city, String region, BigDecimal target, BigDecimal sales) {
        this.office = office;
        this.city = city;
        this.region = region;
        this.target = target;
        this.sales = sales;
    }

    @Id
    @Column(name = "OFFICE", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getOffice() {
        return this.office;
    }

    public void setOffice(BigDecimal office) {
        this.office = office;
    }

    @Column(name = "CITY", nullable = false, length = 40)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "REGION", nullable = false, length = 30)
    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "TARGET", precision = 22, scale = 0)
    public BigDecimal getTarget() {
        return this.target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    @Column(name = "SALES", nullable = false, precision = 22, scale = 0)
    public BigDecimal getSales() {
        return this.sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

}
