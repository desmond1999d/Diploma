package by.training.nc.sd3.service;

import by.training.nc.sd3.models.ProductOfferingViewModel;

import java.util.List;

public interface ProductOfferingDataService {
    List<ProductOfferingViewModel> getAll();
    ProductOfferingViewModel getSubscriptionById(Long id);
    List<ProductOfferingViewModel> getSubscriptionByCategory(String category);
    ProductOfferingViewModel getSubscriptionByName(String name);
    ProductOfferingViewModel save(ProductOfferingViewModel productOfferingViewModel);
    ProductOfferingViewModel ban(Long id);
    ProductOfferingViewModel unBan(Long id);
}
