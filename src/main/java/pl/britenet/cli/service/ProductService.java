package pl.britenet.cli.service;

import pl.britenet.cli.database.DatabaseService;
import pl.britenet.cli.model.Product;
import pl.britenet.cli.model.builder.ProductBuilder;

import java.sql.SQLException;
import java.util.Optional;

public class ProductService {

    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Product> getProduct(int id) {
        return this.databaseService.performSQL(
                String.format("SELECT * FROM product WHERE id=%d", id),
                resultSet -> {

            try {
                if (resultSet.next()) {
                    return new ProductBuilder()
                            .setId(id)
                            .setName(resultSet.getString("name"))
                            .setDescription(resultSet.getString("description"))
                            .setPrice(resultSet.getDouble("price"))
                            .getProduct();
                }
                else {
                    return null;
                }
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    public void insertProduct(Product product) {
        this.databaseService.performDML(String.format("INSERT INTO product (name, description, price) VALUES ('%s', '%s', %.2f)",
                product.getName(),
                product.getDescription(),
                product.getPrice())
        );
    }

    public void updateProduct(Product product) {
        this.databaseService.performDML(String.format("UPDATE product SET name='%s', description='%s', price=%.2f WHERE id=%d",
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getId())
        );
    }

    public void deleteProduct(int id) {
        this.databaseService.performDML(String.format("DELETE FROM product WHERE id=%d", id));
    }
}
