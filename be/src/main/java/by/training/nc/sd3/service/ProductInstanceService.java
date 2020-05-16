package by.training.nc.sd3.service;

import by.training.nc.sd3.entity.ProductInstance;

import java.util.Optional;

public interface ProductInstanceService {

    Iterable<ProductInstance> getProductInstances();

    ProductInstance save(ProductInstance productInstance);

    Iterable<ProductInstance> save(Iterable<ProductInstance> productInstances);

    void delete(Long id);

    Iterable<ProductInstance> getByBillingAccountId(Long ownerId);

    Iterable<ProductInstance> getByUserId(Long userAccountId);

    Optional<ProductInstance> getById(Long id);

    ProductInstance changeStatus(ProductInstance productInstance);

    ProductInstance update(ProductInstance productInstance);

}
