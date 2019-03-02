package ua.mateacademy.tania.builder;

public class InfoCar {
    private final String brand;
    private final String model;
    private final String color;
    private final Integer year;
    private final Integer hp;

    private InfoCar(InfoCarBuilder infoCarBuilder) {
        this.brand = infoCarBuilder.getBrand();
        this.model = infoCarBuilder.getModel();
        this.color = infoCarBuilder.getColor();
        this.year = infoCarBuilder.getYear();
        this.hp = infoCarBuilder.getHp();
    }

    public static InfoCarBuilder builder() {
        return new InfoCarBuilder();
    }

    public static class InfoCarBuilder {
        private String brand;
        private String model;
        private String color;
        private int year;
        private int hp;

        public InfoCarBuilder brand(final String brand) {
            this.brand = brand;
            return this;
        }

        public InfoCarBuilder model(final String model) {
            this.model = model;
            return this;
        }

        public InfoCarBuilder color(final String color) {
            this.color = color;
            return this;
        }

        public InfoCarBuilder year(final int year) {
            this.year = year;
            return this;
        }

        public InfoCarBuilder hp(final int hp) {
            this.hp = hp;
            return this;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getYear() {
            return year;
        }

        public int getHp() {
            return hp;
        }

        public InfoCar build() {
            return new InfoCar(this);
        }
    }
}