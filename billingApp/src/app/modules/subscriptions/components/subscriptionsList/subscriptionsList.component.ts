import {Component, OnInit} from '@angular/core';
import {ProductOffering} from '../../../../shared/ProductOffering';
import {SubscriptionsShareService} from "../../../../services/subscriptionsShare.service";
import {UserIDService} from "../../../../services/userID.service";
import {UserService} from "../../../../services/user/user.service";

@Component({
  selector: 'subscriptionsList',
  templateUrl: './subscriptionsList.component.html',
  styleUrls: ['./subscriptionsList.component.css']
})

export class SubscriptionsListComponent implements OnInit {

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
