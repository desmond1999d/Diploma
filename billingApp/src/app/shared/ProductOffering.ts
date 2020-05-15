import {OfferParam} from "./OfferParam";

export class ProductOffering {
  public id: number;
  public name: String;
  public description: String;
  public category: number;
  public price: number;
  public params: Array<OfferParam>;
  public isBanned: boolean;

  constructor(id: number, name: String, description: String, category: number, price: number, params: Array<OfferParam>, isBanned: boolean) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.category = category;
    this.price = price;
    this.params = params;
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
