package ua.mateacademy.tania.patterns.abstractfactory;

import ua.mateacademy.tania.patterns.abstractfactory.germany.GermanyFactory;
import ua.mateacademy.tania.patterns.abstractfactory.polish.PolishFactory;

public class FactoryProvider {
    public static Factory getFactory(String factory) {
        if("Germany".equals(factory)) {
            return new GermanyFactory();
        } else if ("Polish".equals(factory)) {
            return new PolishFactory();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
