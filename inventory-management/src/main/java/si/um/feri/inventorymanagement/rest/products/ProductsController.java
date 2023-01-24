package si.um.feri.inventorymanagement.rest.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Product p = productsService.getProduct(id);
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(Product product) {
        Product p = productsService.createProduct(product);
        return ResponseEntity.ok(p);
    }

    @GetMapping("all")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productsService.deleteProduct(id);
        return ResponseEntity.ok("Deleted product with id " + id + ".");
    }

}
