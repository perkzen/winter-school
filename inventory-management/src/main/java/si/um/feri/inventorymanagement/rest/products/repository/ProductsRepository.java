package si.um.feri.inventorymanagement.rest.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import si.um.feri.inventorymanagement.rest.products.vao.Product;

public interface ProductsRepository extends MongoRepository<Product, String> {
}
