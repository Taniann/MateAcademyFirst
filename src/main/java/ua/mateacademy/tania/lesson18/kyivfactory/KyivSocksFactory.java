package ua.mateacademy.tania.lesson18.kyivfactory;

import ua.mateacademy.tania.lesson18.*;

public class KyivSocksFactory implements SocksFactory {

    @Override
    public Socks createSocks(String type) {
        if ("female".equals(type)) {
            return new FemaleSocks("female");
        } else if("male".equals(type)) {
            return new MaleSocks("male");
        } else if("kidBoy".equals(type)) {
            return new KidBoySocks("kidBoy");
        } else if ("kidGirl".equals(type)) {
            return new KidGirlSocks("kidGirl");
        } else if ("new".equals(type)) {
            return new NewSocks("new");
        } else {
            return new UnisexSocks("unisex");
        }
    }

}
