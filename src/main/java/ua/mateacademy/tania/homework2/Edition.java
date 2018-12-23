package ua.mateacademy.tania.homework2;

import java.math.BigDecimal;

/**
 * Created by Таня on 23.12.2018.
 */
public class Edition {
    private int id;
    private String name;
    private String info;
    private BigDecimal price;
    private String imageUrl;
    private String type;

    private Edition(EditionBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.info = builder.info;
        this.price = builder.price;
        this.imageUrl = builder.imageUrl;
        this.type = builder.type;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static EditionBuilder builder() {
        return new EditionBuilder();
    }

    public final static class EditionBuilder {
        private int id;
        private String name;
        private String info;
        private BigDecimal price;
        private String imageUrl;
        private String type;

        private EditionBuilder() {
        }

        public EditionBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public EditionBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public EditionBuilder withInfo(String info) {
            this.info = info;
            return this;
        }

        public EditionBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public EditionBuilder withImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public EditionBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public Edition build() {
            return new Edition(this);
        }
    }
}
