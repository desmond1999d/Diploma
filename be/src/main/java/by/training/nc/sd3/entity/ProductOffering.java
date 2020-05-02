package by.training.nc.sd3.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product_offering")
public class ProductOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int category;
    private int cost;
    private boolean isBanned;
    @OneToMany(mappedBy = "productOfferingId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = OfferParam.class)
    private List<OfferParam> params;

    public ProductOffering() {
    }

    public ProductOffering(String name, String description, int category, int cost, boolean isBanned, List<OfferParam> params) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.cost = cost;
        this.isBanned = isBanned;
        this.params = params;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = Categories.valueOf(category).ordinal();
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean banned) {
        isBanned = banned;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public List<OfferParam> getParams() {
        return params;
    }

    public void setParams(List<OfferParam> params) {
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOffering that = (ProductOffering) o;
        return id.equals(that.id) &&
                cost == that.cost &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, category, cost, params);
    }

    @Override
    public String toString() {
        return "ProductOffering{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category + '\'' +
                ", cost=" + cost + '\'' +
                ", params=" + params + '\'' +
                '}';
    }
}
