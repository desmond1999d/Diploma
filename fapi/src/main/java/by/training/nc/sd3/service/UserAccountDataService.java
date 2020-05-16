package by.training.nc.sd3.service;

import by.training.nc.sd3.models.UserAccountViewModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserAccountDataService extends UserDetailsService {
    UserAccountViewModel getUserAccountById(Long id);
    UserAccountViewModel getUserAccountByData(String login, String password);
    UserAccountViewModel saveUserAccount(UserAccountViewModel account, Long activeBillingAccountId);
    UserAccountViewModel ban(UserAccountViewModel userAccountViewModel);
    UserAccountViewModel unBan(UserAccountViewModel userAccountViewModel);
    UserAccountViewModel[] getAll();
    UserAccountViewModel changeActiveBillingAccount(UserAccountViewModel userAccountViewModel,
                                                    Long billingAccountId);
    Integer subscriptionsQuantity(Long id);
}
