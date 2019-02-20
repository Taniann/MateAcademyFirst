package ua.mateacademy.tania.lesson18.zhytomyrfactory;

import ua.mateacademy.tania.lesson18.Socks;
import ua.mateacademy.tania.lesson18.SocksFactory;

public class ZhytomyrSocksFactory implements SocksFactory {

    @Override
    public Socks createSocks(String type) {
        if ("female".equals(type)) {
            return new ZhytomyrFemaleSocks("femaleZhytomyr");
        } else if("male".equals(type)) {
            return new ZhytomyrMaleSocks("maleZhytomyr");
        }  else {
            return new ZhytomyrUnisexSocks("unisexZhytomyr");
        }
    }
}
