export class ProductOffering {
  public id: number;
  public name: String;
  public description: String;
  public category: number;
  public price: number;
  public isBanned: boolean;

  constructor(id: number, name: String, description: String, category: number,
              productOfferingPrice: number, isBanned: boolean) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.category = category;
    this.price = productOfferingPrice;
    this.isBanned = isBanned;
  }

  getName() {
    return this.name;
  }

  setName(name: String) {
    this.name = name;
  }

  setDescription(description: String) {
    this.description = description;
  }

  getDescription() {
    return this.description;
  }
}
