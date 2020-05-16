package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.UserAccountViewModel;
import by.training.nc.sd3.security.TokenProvider;
import by.training.nc.sd3.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ua")
public class UserAccountDataController {

    private final UserAccountDataService userAccountDataService;
    private final by.training.nc.sd3.security.TokenProvider tokeProvider;

    @Autowired
    public UserAccountDataController(UserAccountDataService userAccountDataService, TokenProvider tokeProvider) {
        this.userAccountDataService = userAccountDataService;
        this.tokeProvider = tokeProvider;
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public ResponseEntity<UserAccountViewModel> getUserAccountById(@RequestParam Long id) {
        return ResponseEntity.ok(userAccountDataService.getUserAccountById(id));
    }

    @PostMapping(value = "/get-all")
    public ResponseEntity<UserAccountViewModel[]> getAll() {
        return ResponseEntity.ok(userAccountDataService.getAll());
    }

    @RequestMapping(value = "/user")
    public UserAccountViewModel user(UserAccountViewModel userAccountViewModel) {
        return userAccountViewModel;
    }

    @RequestMapping(value = "/get-by-data", method = RequestMethod.POST)
    public ResponseEntity<String> getUserAccountByData(@RequestParam String login, @RequestBody String password) {
        UserDetails userDetails = userAccountDataService.getUserAccountByData(login, password);
        if (userDetails == null) {
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.ok(tokeProvider.generateToken(userDetails));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<UserAccountViewModel> saveUserAccount(@RequestBody UserAccountViewModel userAccount, @RequestParam Long activeBillingAccountId) {
        if (userAccount != null) {
            System.out.println(userAccount);
            return ResponseEntity.ok(userAccountDataService.saveUserAccount(userAccount, activeBillingAccountId));
        }
        return null;
    }

    @PostMapping(value = "ban")
    public ResponseEntity<UserAccountViewModel> ban(@RequestBody UserAccountViewModel userAccountViewModel) {
        return ResponseEntity.ok(userAccountDataService.ban(userAccountViewModel));
    }

    @PostMapping(value = "unban")
    public ResponseEntity<UserAccountViewModel> unBan(@RequestBody UserAccountViewModel userAccountViewModel) {
        return ResponseEntity.ok(userAccountDataService.unBan(userAccountViewModel));
    }

    @PostMapping(value = "change-BillingAccount")
    public ResponseEntity<UserAccountViewModel> changeActiveBillingAccount(@RequestBody UserAccountViewModel userAccountViewModel,
                                                                           @RequestParam Long billingAccountId) {
        return ResponseEntity.ok(userAccountDataService.changeActiveBillingAccount(userAccountViewModel, billingAccountId));
    }

    @GetMapping(value = "/subscription-unit/quantity")
    public ResponseEntity<Integer> getSubscriptionsQuantity(@RequestParam Long id) {
        return ResponseEntity.ok(userAccountDataService.subscriptionsQuantity(id));
    }
}
