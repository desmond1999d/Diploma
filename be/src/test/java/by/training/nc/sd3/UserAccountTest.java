package by.training.nc.sd3;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.service.BillingAccountService;
import by.training.nc.sd3.service.UserAccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BackendApplication.class)
@Transactional
public class UserAccountTest {

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private BillingAccountService billingAccountService;
    private Validator validator;
    private static final String NAME = "Test";
    private static final String PASSWORD = "Pass";

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testEmptyBillingAccount() {
        UserAccount userAccount = new UserAccount(null, "test", "test", "test", false, false);
        Set<ConstraintViolation<UserAccount>> violations = validator.validate(userAccount);
        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testRegistration() {
        BillingAccount billingAccount = billingAccountService.save(new BillingAccount());
        UserAccount userAccount = new UserAccount(billingAccount.getId(), NAME, PASSWORD, "test", false, false);
        userAccountService.save(userAccount);
        Assert.assertEquals(userAccountService.getUserAccountByName(NAME).get().getActiveBillingAccountId(), billingAccount.getId());
    }

    @Test
    public void testLogin() {
        BillingAccount billingAccount = billingAccountService.save(new BillingAccount());
        UserAccount userAccount = new UserAccount(billingAccount.getId(), NAME, PASSWORD, "test", false, false);
        userAccountService.save(userAccount);
        Assert.assertNotNull(userAccountService.getUserAccount(NAME, PASSWORD));
    }
}
