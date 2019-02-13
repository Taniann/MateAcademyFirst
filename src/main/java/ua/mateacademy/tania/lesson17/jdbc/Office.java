package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Tania Nebesna on 13.02.2019.
 */
public class Office {
    private BigInteger id;
    private String city;
    private String region;
    private BigInteger mgr;
    private BigDecimal target;
    private BigDecimal sale;

    public Office() {
    }

    public Office(BigInteger id, String city, String region, BigInteger mgr, BigDecimal target, BigDecimal sale) {
        this.id = id;
        this.city = city;
        this.region = region;
        this.mgr = mgr;
        this.target = target;
        this.sale = sale;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigInteger getMgr() {
        return mgr;
    }

    public void setMgr(BigInteger mgr) {
        this.mgr = mgr;
    }

    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", mgr=" + mgr +
                ", target=" + target +
                ", sale=" + sale +
                '}';
    }
}
