package si.um.feri.inventorymanagement.rest.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public Product createProduct(Product product) {
        Product p = new Product(
                product.getDisplayName(),
                product.getQuantity(),
                product.getDescription(),
                product.getType(),
                product.getManufacturer());
        return productsRepository.save(p);
    }

    public Product getProduct(String id) {
        return productsRepository.findById(id).orElse(null);
    }

    public List<Product> getProducts() {
        return productsRepository.findAll();
    }

    public void deleteProduct(String id) {
        productsRepository.deleteById(id);
    }

}
