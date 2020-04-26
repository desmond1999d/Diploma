package by.training.nc.sd3.models;

public class ProductOfferingViewModel {
    private Long id;
    private String name;
    private String description;
    private int category;
    private int price;
    private boolean isBanned;

    public ProductOfferingViewModel() {
    }

    public ProductOfferingViewModel(Long id, String name, String description, int category, int price, boolean isBanned) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isBanned = isBanned;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories getCategory() {
        return Categories.values()[category];
    }

    public void setCategory(Categories category) {
        this.category = category.ordinal();
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean banned) {
        isBanned = banned;
    }

    @Override
    public String toString() {
        return "ProductOfferingViewModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
