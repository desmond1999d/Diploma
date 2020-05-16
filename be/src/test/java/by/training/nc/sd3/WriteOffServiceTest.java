package by.training.nc.sd3;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.ProductInstance;
import by.training.nc.sd3.entity.ProductOffering;
import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.service.BillingAccountService;
import by.training.nc.sd3.service.ProductInstanceService;
import by.training.nc.sd3.service.ProductOfferingService;
import by.training.nc.sd3.service.UserAccountService;
import by.training.nc.sd3.service.impl.WriteOffService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BackendApplication.class)
@Transactional
public class WriteOffServiceTest {

    @Autowired
    private WriteOffService writeOffService;
    @Autowired
    private BillingAccountService billingAccountService;
    @Autowired
    private ProductOfferingService productOfferingService;
    @Autowired
    private ProductInstanceService productInstanceService;
    @Autowired
    private UserAccountService userAccountService;

    @Test
    public void testPayment() {
        BillingAccount billingAccount = billingAccountService.save(new BillingAccount());
        ProductInstance productInstance = new ProductInstance();
        productInstance.setStatus(true);
        productInstance.setBillingAccount(billingAccount);
        ProductOffering productOffering = productOfferingService.save(new ProductOffering());
        productOffering.setCost(1);
        productInstance.setProductOffering(productOffering);
        writeOffService.pay(productInstance);
        Assert.assertFalse(productInstance.isStatus());
    }

    @Test
    public void testMonthlyPayment() {
        int initialSum = 10;
        BillingAccount billingAccount = new BillingAccount();
        billingAccount.setMoney(initialSum);
        billingAccount = billingAccountService.save(billingAccount);

        ProductInstance productInstance = new ProductInstance();
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.MONTH, -1);
        dt = c.getTime();
        productInstance.setWriteOffDate(dt);
        productInstance.setStatus(true);
        productInstance.setBillingAccount(billingAccount);

        ProductOffering productOffering = productOfferingService.save(new ProductOffering());
        productOffering.setCost(1);
        productInstance.setProductOffering(productOffering);

        UserAccount userAccount = new UserAccount(billingAccount.getId(), "", "", "", false, false);
        userAccountService.save(userAccount);
        productInstance.setUserId(userAccount.getId());

        productInstanceService.save(productInstance);
        writeOffService.writeOff();
        Assert.assertEquals(billingAccount.getMoney(), initialSum - productOffering.getCost());
        Assert.assertTrue(productInstance.isStatus());
        Assert.assertEquals(productInstance.getWriteOffDate().getDate(), new Date().getDate());
    }
}
