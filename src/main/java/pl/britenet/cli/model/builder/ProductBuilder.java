package pl.britenet.cli.model.builder;

import pl.britenet.cli.model.Product;

public class ProductBuilder {

    private final Product product;

    public ProductBuilder() {
        this.product = new Product();
    }

    public ProductBuilder setId(int id) {
        this.product.setId(id);
        return this;
    }

    public ProductBuilder setName(String name) {
        this.product.setName(name);
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.product.setDescription(description);
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.product.setPrice(price);
        return this;
    }

    public Product getProduct() {
        return this.product;
    }
}
