package si.um.feri.inventorymanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import si.um.feri.inventorymanagement.rest.products.service.ProductsService;
import si.um.feri.inventorymanagement.rest.products.vao.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceTests {
    @Autowired
    private ProductsService productsService;

    @BeforeEach
    void beforeEach() {
        productsService.deleteAll();
    }

    @Test
    void testCreateProduct() {
        Product product = new Product(
                "Test product",
                10,
                "Test description",
                "Test type",
                "Test manufacturer",
                10.0);
        Product p = productsService.createProduct(product);
        assertEquals(product.getDisplayName(), p.getDisplayName());
        assertEquals(product.getQuantity(), p.getQuantity());
        assertEquals(product.getDescription(), p.getDescription());
        assertEquals(product.getType(), p.getType());
        assertEquals(product.getManufacturer(), p.getManufacturer());
        assertEquals(product.getPrice(), p.getPrice());
    }

    @Test
    void testGetProduct() {
        Product product = new Product(
                "Test product",
                10,
                "Test description",
                "Test type",
                "Test manufacturer",
                10.0);
        Product p = productsService.createProduct(product);
        Product p2 = productsService.getProduct(p.getId());
        assertEquals(p.getId(), p2.getId());
        assertEquals(p.getDisplayName(), p2.getDisplayName());
        assertEquals(p.getQuantity(), p2.getQuantity());
        assertEquals(p.getDescription(), p2.getDescription());
        assertEquals(p.getType(), p2.getType());
        assertEquals(p.getManufacturer(), p2.getManufacturer());
        assertEquals(p.getPrice(), p2.getPrice());
    }

    @Test
    void testFailGetProduct() {
        Product p = productsService.getProduct("123");
        assertNull(p);
    }

    @Test
    void testGetProducts() {
        Product product = new Product(
                "Test product",
                10,
                "Test description",
                "Test type",
                "Test manufacturer",
                10.0);
        Product p = productsService.createProduct(product);
        assertEquals(1, productsService.getProducts().size());
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product(
                "Test product",
                10,
                "Test description",
                "Test type",
                "Test manufacturer",
                10.0);
        Product p = productsService.createProduct(product);
        productsService.deleteProduct(p.getId());
        assertEquals(0, productsService.getProducts().size());
    }

    @Test
    void testFailDeleteProduct() {
        productsService.deleteProduct("123");
        assertEquals(0, productsService.getProducts().size());
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product(
                "Test product",
                10,
                "Test description",
                "Test type",
                "Test manufacturer",
                10.0);
        Product p = productsService.createProduct(product);
        Product product2 = new Product(
                "Test product 2",
                20,
                "Test description 2",
                "Test type 2",
                "Test manufacturer 2",
                20.0);
        Product p2 = productsService.updateProduct(p.getId(), product2);
        assertEquals(p.getId(), p2.getId());
        assertEquals(product2.getDisplayName(), p2.getDisplayName());
        assertEquals(product2.getQuantity(), p2.getQuantity());
        assertEquals(product2.getDescription(), p2.getDescription());
        assertEquals(product2.getType(), p2.getType());
        assertEquals(product2.getManufacturer(), p2.getManufacturer());
        assertEquals(product2.getPrice(), p2.getPrice());
    }

    @Test
    void testFailUpdateProduct() {
        Product product2 = new Product(
                "Test product 2",
                20,
                "Test description 2",
                "Test type 2",
                "Test manufacturer 2",
                20.0);
        Product p2 = productsService.updateProduct("123", product2);
        assertNull(p2);
    }

}
