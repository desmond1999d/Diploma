package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.ProductInstance;
import by.training.nc.sd3.service.BillingAccountService;
import by.training.nc.sd3.service.ProductInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class WriteOffService {

    private ProductInstanceService productInstanceService;
    private BillingAccountService billingAccountService;

    @Autowired
    public WriteOffService(ProductInstanceService productInstanceService,
                           BillingAccountService billingAccountService) {
        this.productInstanceService = productInstanceService;
        this.billingAccountService = billingAccountService;
    }

    public void pay(ProductInstance productOfferingUnit) {
        Optional<BillingAccount> billingAccountOptional = billingAccountService.getById(productOfferingUnit.getBillingAccount().getId());
        if (billingAccountOptional.isPresent()) {
            BillingAccount billingAccount = billingAccountOptional.get();
            int fee = productOfferingUnit.getProductOffering().getCost();
            if (billingAccount.getMoney() - fee >= 0) {
                billingAccount.setMoney(billingAccount.getMoney() - fee);
                this.billingAccountService.save(billingAccount);
            } else {
                productOfferingUnit.setStatus(false);
            }
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void writeOff() {
        List<ProductInstance> productOfferingUnits = new ArrayList<>();
        productInstanceService.getProductInstances().forEach(productOfferingUnits::add);
        productOfferingUnits.removeIf(productInstance -> !productInstance.getProductOffering().isMrc());
        productOfferingUnits.forEach(
                productOfferingUnit -> {
                    if (productOfferingUnit.isStatus()) {
                        Date date = new Date();
                        if (date.getTime() - productOfferingUnit.getWriteOffDate().getTime() >= 1000) {
                            productOfferingUnit.setWriteOffDate(date);
                            pay(productOfferingUnit);
                            this.productInstanceService.update(productOfferingUnit);
                        }
                    }
                }
        );
    }
}