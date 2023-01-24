package si.um.feri.inventorymanagement.rest.products;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Product, String> {
}
