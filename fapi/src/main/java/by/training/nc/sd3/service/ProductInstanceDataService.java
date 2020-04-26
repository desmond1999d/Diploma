package by.training.nc.sd3.service;

import by.training.nc.sd3.models.ProductInstanceViewModel;

import java.util.List;

public interface ProductInstanceDataService {

    List<ProductInstanceViewModel> getSubscriptionUnitsByUserId(Long id);

    void delete(Long id);

    ProductInstanceViewModel save(ProductInstanceViewModel productInstanceViewModel);

    ProductInstanceViewModel changeStatus(ProductInstanceViewModel productInstanceViewModel);
}
