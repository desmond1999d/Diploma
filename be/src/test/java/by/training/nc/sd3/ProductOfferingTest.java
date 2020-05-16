package by.training.nc.sd3;

import by.training.nc.sd3.entity.ProductOffering;
import by.training.nc.sd3.repository.ProductOfferingRepository;
import by.training.nc.sd3.service.ProductOfferingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.StreamSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BackendApplication.class)
@Transactional
public class ProductOfferingTest {

    @Autowired
    private ProductOfferingService productOfferingService;
    
    private static final String NAME = "Test";

    @Test
    public void testProductOfferingCreation() {
        ProductOffering productOffering = new ProductOffering();
        String NAME = "Test";
        String description = "Test description";
        productOffering.setName(NAME);
        productOffering.setDescription(description);
        productOfferingService.save(productOffering);
        ProductOffering offering = productOfferingService.getProductOfferingByName(NAME);
        Assert.assertEquals(offering.getDescription(), description);
        
    }

    @Test
    public void testProductOfferingFiltering() {
        ProductOffering productOffering = new ProductOffering();
        String NAME = "Test";
        productOffering.setName(NAME);
        productOffering.setCategory(1);
        productOfferingService.save(productOffering);
        Iterable<ProductOffering> productOfferingsByCategory = productOfferingService.getProductOfferingsByCategory(1L);
        Assert.assertTrue(
                StreamSupport.stream(productOfferingsByCategory.spliterator(), false)
                        .anyMatch(offering -> offering.getName().equals(NAME)));
    }

}
