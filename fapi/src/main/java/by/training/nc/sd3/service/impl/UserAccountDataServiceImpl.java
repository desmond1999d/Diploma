package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.UserAccountViewModel;
import by.training.nc.sd3.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserAccountDataServiceImpl implements UserAccountDataService {

    @Value("http://localhost:8081/")
    private String backendServerUrl;

    public UserAccountViewModel getUserAccountById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/user-accounts/{id}?id={id}",
                UserAccountViewModel.class, id, id);
    }

    public UserAccountViewModel getUserAccountByData(String login, String password) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/user-accounts?login={login}&password={password}",
                UserAccountViewModel.class, login, password);
    }

    public UserAccountViewModel saveUserAccount(UserAccountViewModel account, Long activeBillingAccountId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(backendServerUrl + "/api/user-accounts/save?activeBillingAccountId=" + activeBillingAccountId,
                account, UserAccountViewModel.class);
    }

    @Override
    public UserAccountViewModel ban(UserAccountViewModel userAccountViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(backendServerUrl + "/api/user-accounts/ban",
                userAccountViewModel, UserAccountViewModel.class);
    }

    @Override
    public UserAccountViewModel unBan(UserAccountViewModel userAccountViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(backendServerUrl + "/api/user-accounts/unBan",
                userAccountViewModel, UserAccountViewModel.class);
    }

    @Override
    public UserAccountViewModel[] getAll() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(backendServerUrl + "/api/user-accounts/get-all", null,
                UserAccountViewModel[].class);
    }

    @Override
    public UserAccountViewModel changeActiveBillingAccount(UserAccountViewModel userAccountViewModel,
                                                           Long billingAccountId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(backendServerUrl + "/api/user-accounts/change-billing-account?billingAccountId=" + billingAccountId,
                userAccountViewModel, UserAccountViewModel.class);
    }

    @Override
    public Integer subscriptionsQuantity(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/user-accounts//subscription-unit/quantity?id={id}",
                Integer.class, id);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/user-accounts/by-name?name={name}}",
                UserAccountViewModel.class, name);
    }
}
