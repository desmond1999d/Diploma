package by.training.nc.sd3.repository;

import by.training.nc.sd3.entity.ProductOffering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOfferingRepository extends CrudRepository<ProductOffering, Long> {

    ProductOffering getByName(String name);

    Iterable<ProductOffering> getByCategory(int category);

    void deleteByName(String name);
}
