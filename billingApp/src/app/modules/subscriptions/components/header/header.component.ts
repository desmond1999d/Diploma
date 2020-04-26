import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {UserIDService} from '../../../../services/userID.service';
import {SubscriptionService} from "../../../../services/subscription/subscription.service";
import {ProductOffering} from "../../../../shared/ProductOffering";
import {SubscriptionsShareService} from "../../../../services/subscriptionsShare.service";
import {UserService} from "../../../../services/user/user.service";
import {el} from "@angular/platform-browser/testing/src/browser_util";


@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {

  loggedUserIDObs = this.userIDService.data$;
  loggedUserID;
  subscriptions: ProductOffering[];
  subscription: ProductOffering;
  isAdmin: boolean = false;

  constructor(private http: SubscriptionService, public userIDService: UserIDService,
              private subscriptionShareService: SubscriptionsShareService,
              private userService: UserService) {
    this.userIDService.setID(-1);
    this.http.getSubscriptions().subscribe(
      subscriptions =>
        this.subscriptionShareService.setSubscriptions(subscriptions)
    )
  }

  ngOnInit() {
    this.loggedUserIDObs.subscribe(loggedUserID => {
      this.loggedUserID = loggedUserID[0];
      this.getIsAdmin();
    });
  }

  getIsAdmin() {
    if(this.loggedUserID > -1) {
      this.userService.getUserById(this.loggedUserID).subscribe(
        user => this.isAdmin = user.isAdmin
      )
    }
  }

  getAllSubscriptions() {
    this.http.getSubscriptions().subscribe(
      subscriptions =>
        this.subscriptionShareService.setSubscriptions(subscriptions)
    )
  }

  search(name: string): ProductOffering {
    this.http.getSubscriptionByName(name).subscribe(subscription => {
      this.subscriptionShareService.setSubscriptions([subscription]);
    });
    return this.subscription;
  }

  filter(category: string): ProductOffering[] {
    this.http.getSubscriptionByCategory(category).subscribe(subscriptions => {
      this.subscriptionShareService.setSubscriptions(subscriptions);
    });
    return this.subscriptions;
  }

  logOut() {
    this.userIDService.setID(-1);
    this.isAdmin = false;
  }
}
