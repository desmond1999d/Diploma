import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {SubscriptionService} from "../../../../services/subscription/subscription.service";
import {ProductOffering} from "../../../../shared/ProductOffering";
import {UserIDService} from "../../../../services/userID.service";
import {SubscriptionUnitService} from "../../../../services/subscriptionUnit/subscriptionUnit.service";
import {ProductInstance} from "../../../../shared/ProductInstance";
import {UserService} from "../../../../services/user/user.service";
import {User} from "../../../../shared/User";

@Component({
  selector: 'subscriptionsDetails',
  templateUrl: './productDetails.component.html',
  styleUrls: ['./productDetails.component.css']
})

export class ProductDetailsComponent implements OnInit {
  productOffering: ProductOffering;
  isSubscribed: boolean;
  notEnoughMoney: boolean;
  id;
  user: User;
  subscriptionId: any;

  config = {
    animated: true,
    keyboard: true
  };
  constructor(private http: SubscriptionService, private route: ActivatedRoute,
              private userIdService: UserIDService,
              private subscriptionUnitService: SubscriptionUnitService,
              private userService: UserService) {
  }

  ngOnInit() {
    this.notEnoughMoney = false;
    this.refreshData();
  }

  refreshData() {
    this.getSubscription();
    this.isSubscribed = false;
    this.id = this.userIdService.getID()[0];
    if (this.id > -1) {
      this.subscriptionUnitService.getSubscriptionUnitsById(this.id).subscribe(
        subscriptionUnits => {
          for (let i = 0; i < subscriptionUnits.length; i++) {
            if (subscriptionUnits[i].productOffering.name === this.productOffering.name)
              this.isSubscribed = true;
          }
        }
      );
      this.userService.getUserById(this.id).subscribe(
        user => {
          this.user = user;
          this.user.isAdmin = user.isAdmin;
        }
      );
    }
  }

  ban() {
    this.http.banSubscription((this.subscriptionId)).subscribe(
      subscription => this.productOffering = subscription
    );
  }

  unBan() {
    this.http.unBanSubscription((this.subscriptionId)).subscribe(
      subscription => this.productOffering = subscription
    );
  }

  getSubscription() {
    this.subscriptionId = this.route.snapshot.paramMap.get('id');
    this.http.getSubscriptionById((this.subscriptionId)).subscribe(subscription => {
      this.productOffering = subscription;
    });
  }

  buyQuantity(quantity) {
    this.buy((quantity));
  }

  buy(quantity: number) {
    if (!this.user.isBanned) {
      let subscriptionUnits = [];
      for (let i = 0; i < quantity; i++) {
        let subscriptionUnit = new ProductInstance(null, this.id, this.productOffering, true);
        subscriptionUnits.push(subscriptionUnit);
      }
      this.subscriptionUnitService.saveSubscriptionUnits(subscriptionUnits).subscribe(
        subscriptionUnit => {
          if (subscriptionUnit !== null) {
            this.isSubscribed = true;
            this.notEnoughMoney = false;
          } else {
            this.notEnoughMoney = true;
          }
        });
    }
  }

  unsubscribe() {
    if (!this.user.isBanned) {
      this.subscriptionUnitService.getSubscriptionUnitsById(this.id).subscribe(
        subscriptionUnits => {
          for (let i = 0; i < subscriptionUnits.length; i++) {
            if (subscriptionUnits[i].productOffering.name === this.productOffering.name) {
              this.subscriptionUnitService.deleteSubscriptionUnit(subscriptionUnits[i]).subscribe(
                subscriptionUnit => this.isSubscribed = false
              );
            }
          }
        }
      );
    }
  }

  public getImages() {
    return this.productOffering.params.filter(param => param.image);
  }
}
