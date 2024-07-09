package testDataBuilders;

public class Product {


    String category, name;
    int qty;

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public Product(ProductBuilder productBuilder){
        this.category = productBuilder.category;
        this.name = productBuilder.name;
        this.qty = productBuilder.qty;
    }

    public static class ProductBuilder {
        String category, name;
        int qty;


        public ProductBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setQty(int qty) {
            this.qty = qty;
            return this;
        }

        public Product build(){
            Product product = new Product(this);
            return product;
        }
    }
}
