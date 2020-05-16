package by.training.nc.sd3.security;


import by.training.nc.sd3.models.UserAccountViewModel;
import by.training.nc.sd3.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationManagerImpl implements AuthenticationManager {

    private final UserAccountDataService userAccountDataService;
    private final TokenProvider tokenProvider;

    @Autowired
    public AuthenticationManagerImpl(UserAccountDataService userAccountDataService, TokenProvider tokenProvider) {
        this.userAccountDataService = userAccountDataService;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserAccountViewModel userAccountViewModel = userAccountDataService.getUserAccountByData(authentication.getName(),
                (String) authentication.getCredentials());
        if (userAccountViewModel != null) {
            return tokenProvider.getAuthentication("", userAccountViewModel);
        }
        throw new BadCredentialsException("Bad credentials");
    }
}
