package ua.mateacademy.tania.springintro;

/**
 * Created by Tania Nebesna on 07.03.2019
 */
public abstract class AbstractAnimal implements Animal{

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public abstract String getVoice();

    @Override
    public String toString() {
        return "AbstractAnimal [getName()=" + getName() + " , getVoice()=" + getVoice();
    }
}
