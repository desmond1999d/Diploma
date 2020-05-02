package by.training.nc.sd3.entity;

import javax.persistence.*;

@Entity
@Table(name = "params")
public class OfferParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String value;
    private Long productOfferingId;

    public OfferParam() {
    }

    public OfferParam(String name, String value, Long productOfferingId) {
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

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", name=" + name +
                ", value='" + value +
                '}';
    }
}
