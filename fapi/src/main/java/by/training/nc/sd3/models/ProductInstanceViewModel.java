package by.training.nc.sd3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductInstanceViewModel {
    private Long id;
    private Long userId;
    private ProductOfferingViewModel productOffering;
    private boolean status;

    public ProductInstanceViewModel() {
    }

    public ProductInstanceViewModel(Long id, Long userId, ProductOfferingViewModel productOffering,
                                    int daysLeft, boolean willBeRenewed, boolean status) {
        this.id = id;
        this.userId = userId;
        this.productOffering = productOffering;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ProductOfferingViewModel getProductOffering() {
        return productOffering;
    }

    public void setProductOffering(ProductOfferingViewModel productOffering) {
        this.productOffering = productOffering;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductInstanceViewModel{" +
                "userId=" + userId +
                ", productOffering=" +  productOffering +
                ", status=" + status +
                '}';
    }
}
