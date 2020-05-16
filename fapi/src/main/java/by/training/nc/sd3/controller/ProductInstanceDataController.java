package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.ProductInstanceViewModel;
import by.training.nc.sd3.service.ProductInstanceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prodinstances")
public class ProductInstanceDataController {

    @Autowired
    private ProductInstanceDataService productInstanceDataService;

    @RequestMapping(value = "/get-by-userid", method = RequestMethod.GET)
    public ResponseEntity<List<ProductInstanceViewModel>> getSubscriptionUnitsByUserId(@RequestParam("userId") Long id) {
        return ResponseEntity.ok(productInstanceDataService.getSubscriptionUnitsByUserId(id));
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        productInstanceDataService.delete(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ProductInstanceViewModel> save(@RequestBody ProductInstanceViewModel productInstanceViewModel) {
        return ResponseEntity.ok(productInstanceDataService.save(productInstanceViewModel));
    }

    @PostMapping(value = "/save-all")
    public ResponseEntity<List<ProductInstanceViewModel>> save(@RequestBody List<ProductInstanceViewModel> productInstanceViewModel) {
        return ResponseEntity.ok(productInstanceDataService.saveAll(productInstanceViewModel));
    }

    @PostMapping(value = "/change-status")
    public ResponseEntity<ProductInstanceViewModel> changeStatus(@RequestBody ProductInstanceViewModel productInstanceViewModel) {
        return ResponseEntity.ok(productInstanceDataService.changeStatus(productInstanceViewModel));
    }

}
