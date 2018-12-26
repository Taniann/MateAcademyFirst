package ua.mateacademy.tania.lesson3.template;

/**
 * Created by Таня on 25.12.2018.
 */
public class DoTemplate {
    public static void main(String[] args) {
        TemplateExample templateExample = new TemplateExample() {
            @Override
            public void doOperation() {
                System.out.println("do something");
            }
        };

        templateExample.templateMethod();

        templateExample = new TemplateExample() {
            @Override
            public void doOperation() {
                System.out.println("do something another");
            }
        };
        templateExample.templateMethod();
    }

}
