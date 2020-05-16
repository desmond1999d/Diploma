package by.training.nc.sd3.service;

import by.training.nc.sd3.models.ProductOfferingViewModel;

import java.util.List;

public interface ProductOfferingDataService {
    List<ProductOfferingViewModel> getAll();
    ProductOfferingViewModel getProductOfferingById(Long id);
    List<ProductOfferingViewModel> getProductOfferingByCategory(String category);
    ProductOfferingViewModel getProductOfferingByName(String name);
    ProductOfferingViewModel save(ProductOfferingViewModel productOfferingViewModel);
    ProductOfferingViewModel ban(Long id);
    ProductOfferingViewModel unBan(Long id);
}
