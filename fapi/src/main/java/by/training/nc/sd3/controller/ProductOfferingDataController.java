package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.ProductOfferingViewModel;
import by.training.nc.sd3.service.ProductOfferingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subs")
public class ProductOfferingDataController {

    @Autowired
    private ProductOfferingDataService productOfferingDataService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<ProductOfferingViewModel>> getSubscriptions() {
        return ResponseEntity.ok(productOfferingDataService.getAll());
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public ResponseEntity<ProductOfferingViewModel> getSubscriptionById(@RequestParam String id) {
        return ResponseEntity.ok(productOfferingDataService.getSubscriptionById(Long.valueOf(id)));
    }

    @RequestMapping(value = "/get-by-name", method = RequestMethod.GET)
    public ResponseEntity<ProductOfferingViewModel> getSubscriptionByName(@RequestParam String name) {
        return ResponseEntity.ok(productOfferingDataService.getSubscriptionByName(name));
    }

    @RequestMapping(value = "/get-by-category", method = RequestMethod.GET)
    public ResponseEntity<List<ProductOfferingViewModel>> getSubscriptionByCategory(@RequestParam String category) {
        return ResponseEntity.ok(productOfferingDataService.getSubscriptionByCategory(category));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ProductOfferingViewModel> save(@RequestBody ProductOfferingViewModel productOfferingViewModel) {
        return ResponseEntity.ok(productOfferingDataService.save(productOfferingViewModel));
    }

    @PostMapping(value = "/ban")
    public ResponseEntity<ProductOfferingViewModel> ban(@RequestParam Long id) {
        return ResponseEntity.ok(productOfferingDataService.ban(id));
    }

    @PostMapping(value = "/unban")
    public ResponseEntity<ProductOfferingViewModel> unBan(@RequestParam Long id) {
        return ResponseEntity.ok(productOfferingDataService.unBan(id));
    }
}
