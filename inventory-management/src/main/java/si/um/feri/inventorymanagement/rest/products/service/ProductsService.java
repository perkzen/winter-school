package si.um.feri.inventorymanagement.rest.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.um.feri.inventorymanagement.rest.products.vao.Product;
import si.um.feri.inventorymanagement.rest.products.repository.ProductsRepository;

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
                product.getManufacturer(),
                product.getPrice());
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

    public Product updateProduct(String id, Product product) {
        Product p = productsRepository.findById(id).orElse(null);
        if (p != null) {
            p.setDisplayName(product.getDisplayName());
            p.setQuantity(product.getQuantity());
            p.setDescription(product.getDescription());
            p.setType(product.getType());
            p.setManufacturer(product.getManufacturer());
            return productsRepository.save(p);
        }
        return null;
    }

}
