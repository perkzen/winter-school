package si.um.feri.inventorymanagement.rest.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.um.feri.inventorymanagement.rest.products.vao.Product;
import si.um.feri.inventorymanagement.rest.products.service.ProductsService;

import java.util.List;

@RestController
@RequestMapping("products")
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productsService.deleteProduct(id);
        return ResponseEntity.ok("Deleted product with id " + id + ".");
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, Product product) {
        Product p = productsService.updateProduct(id, product);
        return ResponseEntity.ok(p);
    }

}
