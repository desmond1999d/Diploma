import {Component, OnInit} from '@angular/core';
import {ProductOffering} from '../../../../shared/ProductOffering';
import {SubscriptionsShareService} from "../../../../services/subscriptionsShare.service";
import {UserIDService} from "../../../../services/userID.service";
import {UserService} from "../../../../services/user/user.service";

@Component({
  selector: 'productsList',
  templateUrl: './productsList.component.html',
  styleUrls: ['./productsList.component.css']
})

export class ProductsListComponent implements OnInit {

  subscriptions: ProductOffering[];

  constructor(private subscriptionShareService: SubscriptionsShareService,
              private userIdService: UserIDService,
              private userService: UserService) {
  }

  ngOnInit() {
    this.subscriptionShareService.data$.subscribe(
      subscriptions =>
        this.subscriptions = subscriptions
    )
  }
}
