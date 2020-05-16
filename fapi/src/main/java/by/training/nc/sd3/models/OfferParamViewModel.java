package by.training.nc.sd3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferParamViewModel {
    private Long id;
    private String name;
    private String value;
    private Long productOfferingId;
    private boolean image;

    public OfferParamViewModel() {
    }

    public OfferParamViewModel(String name, String value, Long productOfferingId) {
        this.name = name;
        this.value = value;
        this.productOfferingId = productOfferingId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getProductOfferingId() {
        return productOfferingId;
    }

    public void setProductOfferingId(Long productOfferingId) {
        this.productOfferingId = productOfferingId;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "OfferParamViewModel{" +
                "id=" + id +
                ", name=" + name +
                ", value='" + value +
                '}';
    }
}
