package by.training.nc.sd3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatisticsEntryViewModel {

    private Long id;
    private Long billingAccountId;
    private ProductOfferingViewModel serviceId;
    private Long sum;
    private LocalDateTime date;

    public StatisticsEntryViewModel() {
    }

    public StatisticsEntryViewModel(Long billingAccountId, ProductOfferingViewModel subscription, Long sum, LocalDateTime date) {
        this.billingAccountId = billingAccountId;
        this.serviceId = subscription;
        this.sum = sum;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillingAccountId() {
        return billingAccountId;
    }

    public void setBillingAccountId(Long billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    public ProductOfferingViewModel getServiceId() {
        return serviceId;
    }

    public void setServiceId(ProductOfferingViewModel subscription) {
        this.serviceId = subscription;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
