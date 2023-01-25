package si.um.feri.inventorymanagement.rest.products.vao;

import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String displayName;
    private int quantity;
    private String description;
    private String type;
    private double price;
    private String manufacturer;

    public Product(String displayName, int quantity, String description, String type, String manufacturer, double price) {
        this.displayName = displayName;
        this.quantity = quantity;
        this.description = description;
        this.type = type;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Product(String id, String displayName, int quantity, String description, String type, String manufacturer, double price) {
        this.id = id;
        this.displayName = displayName;
        this.quantity = quantity;
        this.description = description;
        this.type = type;
        this.manufacturer = manufacturer;
        this.price = price;
    }
}

