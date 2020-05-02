package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.ProductInstanceViewModel;
import by.training.nc.sd3.service.ProductInstanceDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductInstanceDataServiceImpl implements ProductInstanceDataService {

    @Value("http://localhost:8081/")
    private String backendServerUrl;

    public List<ProductInstanceViewModel> getSubscriptionUnitsByUserId(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        ProductInstanceViewModel[] subscriptionUnits = restTemplate.getForObject(backendServerUrl + "/api/subscription-units/get-by-user-id?userId={id}",
                ProductInstanceViewModel[].class, id);
        return subscriptionUnits == null ? Collections.emptyList() : Arrays.asList(subscriptionUnits);
    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/subscription-units/delete/{id}?id={id}", id, id);
    }

    @Override
    public ProductInstanceViewModel save(ProductInstanceViewModel productInstanceViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(backendServerUrl + "/api/subscription-units/post",
                productInstanceViewModel, ProductInstanceViewModel.class);
    }

    @Override
    public List<ProductInstanceViewModel> saveAll(List<ProductInstanceViewModel> productInstanceViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(backendServerUrl + "/api/subscription-units/post-all",
                productInstanceViewModel, List.class);
    }

    @Override
    public ProductInstanceViewModel changeStatus(ProductInstanceViewModel productInstanceViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(backendServerUrl + "/api/subscription-units/change-status",
                productInstanceViewModel, ProductInstanceViewModel.class);
    }

}
