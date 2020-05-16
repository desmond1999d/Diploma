package by.training.nc.sd3.controller;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.ProductInstance;
import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.service.BillingAccountService;
import by.training.nc.sd3.service.ProductInstanceService;
import by.training.nc.sd3.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/product-instances")
public class ProductInstanceController {

    private ProductInstanceService productInstanceService;

    public ProductInstanceController(ProductInstanceService productInstanceService) {
        this.productInstanceService = productInstanceService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ProductInstance> getAll() {
        return productInstanceService.getProductInstances();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ProductInstance save(@RequestBody ProductInstance productInstance) {
        return productInstanceService.save(productInstance);
    }

    @RequestMapping(value = "/post-all", method = RequestMethod.POST)
    public Iterable<ProductInstance> saveAll(@RequestBody Iterable<ProductInstance> productInstances) {
        return productInstanceService.save(productInstances);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        productInstanceService.delete(id);
    }

    @RequestMapping(value = "/get-by-user-id", method = RequestMethod.GET)
    public Iterable<ProductInstance> getByUserAccountId(@RequestParam("userId") Long id) {
        return productInstanceService.getByUserId(id);
    }

    @PostMapping(value = "/change-status")
    public ProductInstance changeStatus(@RequestBody ProductInstance productInstance) {
        return productInstanceService.changeStatus(productInstance);
    }
}
