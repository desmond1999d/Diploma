package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.Categories;
import by.training.nc.sd3.models.ProductOfferingViewModel;
import by.training.nc.sd3.service.ProductOfferingDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductOfferingDataServiceImpl implements ProductOfferingDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    public List<ProductOfferingViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        ProductOfferingViewModel[] subscriptions = restTemplate.getForObject(backendServerUrl + "/api/subscriptions/", ProductOfferingViewModel[].class);
        return subscriptions == null ? Collections.emptyList() : Arrays.asList(subscriptions);
    }

    public ProductOfferingViewModel getSubscriptionById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/subscriptions/" + id + "/", ProductOfferingViewModel.class);
    }

    @Override
    public List<ProductOfferingViewModel> getSubscriptionByCategory(String category) {
        RestTemplate restTemplate = new RestTemplate();
        ProductOfferingViewModel[] subscriptions = restTemplate.getForObject(backendServerUrl + "/api/subscriptions/by-category?category={category}",
                ProductOfferingViewModel[].class, (long) Categories.valueOf(category).ordinal());
        return subscriptions == null ? Collections.emptyList() : Arrays.asList(subscriptions);
    }

    @Override
    public ProductOfferingViewModel getSubscriptionByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/subscriptions/by-name?name={name}",
                ProductOfferingViewModel.class, name);
    }

    @Override
    public ProductOfferingViewModel save(ProductOfferingViewModel productOfferingViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        ProductOfferingViewModel subscription = restTemplate.postForObject(backendServerUrl + "/api/subscriptions/save",
                productOfferingViewModel, ProductOfferingViewModel.class);
        return subscription;
    }

    @Override
    public ProductOfferingViewModel ban(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ProductOfferingViewModel subscription = restTemplate.postForObject(backendServerUrl + "/api/subscriptions/ban",
                id, ProductOfferingViewModel.class);
        return subscription;
    }

    @Override
    public ProductOfferingViewModel unBan(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ProductOfferingViewModel subscription = restTemplate.postForObject(backendServerUrl + "/api/subscriptions/unban",
                id, ProductOfferingViewModel.class);
        return subscription;
    }
}
