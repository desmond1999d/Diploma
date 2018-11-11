package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.BillingAccountViewModel;
import by.training.nc.sd3.service.BillingAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@RequestMapping("/api/ba")
public class BillingAccountDataController {

    @Autowired
    private BillingAccountDataService billingAccountDataService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<BillingAccountViewModel>> getAllBillingAccounts() {
        return ResponseEntity.ok(billingAccountDataService.getAll());
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public ResponseEntity<List<BillingAccountViewModel>> getBillingAccountById(@RequestParam int id) {
        return ResponseEntity.ok(billingAccountDataService.getBillingAccountById(id));
    }

    @RequestMapping(value = "/getbyownerid", method = RequestMethod.GET)
    public ResponseEntity<List<BillingAccountViewModel>> getBillingAccountByOwnerId(@RequestParam int id) {
        return ResponseEntity.ok(billingAccountDataService.getBillingAccountByOwnerId(id));
    }

    @RequestMapping(value = "/checkpasswordbyid", method = RequestMethod.POST)
    public ResponseEntity<Boolean> checkPasswordById(@RequestBody String password, @RequestBody int id) {
        return ResponseEntity.ok(billingAccountDataService.checkPasswordById(password, id));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<BillingAccountViewModel> saveBillingAccount(@RequestBody BillingAccountViewModel billingAccount) {
        if (billingAccount != null) {
            System.out.println(billingAccount);
            return ResponseEntity.ok(billingAccountDataService.saveBillingAccount(billingAccount));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBillingAccount(@PathVariable String id) {
        billingAccountDataService.deleteBillingAccountById(Integer.valueOf(id));
    }
}