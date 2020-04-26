import {ProductOffering} from "./ProductOffering";

export class ProductInstance {
  public id: number;
  public userId: number;
  public productOffering: ProductOffering;
  public status: boolean;

  constructor(id: number, userId: number, productOffering: ProductOffering, status: boolean) {
    this.id = id;
    this.userId = userId;
    this.productOffering = productOffering;
    this.status = status;
  }
}
