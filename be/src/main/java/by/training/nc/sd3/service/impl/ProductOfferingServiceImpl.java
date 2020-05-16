package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.entity.ProductOffering;
import by.training.nc.sd3.repository.ProductOfferingRepository;
import by.training.nc.sd3.service.ProductOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ProductOfferingServiceImpl implements ProductOfferingService {

    private ProductOfferingRepository productOfferingRepository;

    @Autowired
    public ProductOfferingServiceImpl(ProductOfferingRepository productOfferingRepository) {
        this.productOfferingRepository = productOfferingRepository;
    }

    public Iterable<ProductOffering> getProductOfferings() {
        return productOfferingRepository.findAll();
    }

    public Optional<ProductOffering> getSubscriptionById(Long id) {
        return productOfferingRepository.findById(id);
    }

    public Iterable<ProductOffering> getProductOfferingsByCategory(Long category) {
        return productOfferingRepository.getByCategory(category.intValue());
    }

    public ProductOffering getProductOfferingByName(String name) {
        return productOfferingRepository.getByName(name);
    }

    @Override
    public ProductOffering save(ProductOffering productOffering) {
        return this.productOfferingRepository.save(productOffering);
    }

    @Override
    public ProductOffering ban(Long id) {
        Optional<ProductOffering> subscriptionOptional = this.productOfferingRepository.findById(id);
        if(subscriptionOptional.isPresent()) {
            ProductOffering productOffering = subscriptionOptional.get();
            productOffering.setIsBanned(true);
            return this.productOfferingRepository.save(productOffering);
        }
        return null;
    }

    @Override
    public ProductOffering unBan(Long id) {
        Optional<ProductOffering> subscriptionOptional = this.productOfferingRepository.findById(id);
        if(subscriptionOptional.isPresent()) {
            ProductOffering productOffering = subscriptionOptional.get();
            productOffering.setIsBanned(false);
            return this.productOfferingRepository.save(productOffering);
        }
        return null;
    }

}
