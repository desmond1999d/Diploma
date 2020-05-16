package by.training.nc.sd3.service;


import by.training.nc.sd3.entity.ProductOffering;

import java.util.Optional;

public interface ProductOfferingService {

    Iterable<ProductOffering> getProductOfferings();
    Optional<ProductOffering> getSubscriptionById(Long id);
    Iterable<ProductOffering> getProductOfferingsByCategory(Long category);
    ProductOffering getProductOfferingByName(String name);
    ProductOffering save(ProductOffering productOffering);
    ProductOffering ban(Long id);
    ProductOffering unBan(Long id);
}
