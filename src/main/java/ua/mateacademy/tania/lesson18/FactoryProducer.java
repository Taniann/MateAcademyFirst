package ua.mateacademy.tania.lesson18;

import ua.mateacademy.tania.lesson18.kyivfactory.KyivSocksFactory;
import ua.mateacademy.tania.lesson18.zhytomyrfactory.ZhytomyrSocksFactory;

public class FactoryProducer {
    public static SocksFactory getFactory(String factoryType) {
        if ("kyiv".equals(factoryType)) {
            return new KyivSocksFactory();
        } else {
            return new ZhytomyrSocksFactory();
        }
    }
}
