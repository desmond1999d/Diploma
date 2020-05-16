export class OfferParam {
  public id: number;
  public name: string;
  public value: string;
  public image: boolean;

  constructor(id: number, name: string, value: string, image: boolean) {
    this.id = id;
    this.name = name;
    this.value = value;
    this.image = image;
  }
}
