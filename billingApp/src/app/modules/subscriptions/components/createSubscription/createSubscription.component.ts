import {Component} from "@angular/core";
import {SubscriptionService} from "../../../../services/subscription/subscription.service";
import {ProductOffering} from "../../../../shared/ProductOffering";
import {Categories} from "../../../../shared/Categories";
import {SubscriptionsShareService} from "../../../../services/subscriptionsShare.service";

@Component({
  selector: 'createSubscription',
  templateUrl: './createSubscription.component.html',
  styleUrls: ['./createSubscription.component.css']
})

export class CreateSubscriptionComponent {

  cat = Categories;

  constructor(private subscriptionService: SubscriptionService,
              private  subscriptionsShareService: SubscriptionsShareService) {
  }

  categoriesValues(): Array<string>{
    let keys = Object.keys(this.cat);
    return keys.slice(keys.length / 2, keys.length);
  }

  createSubscription(name: string, description: string, category: number, price: string) {
    let subscription: ProductOffering = new ProductOffering(null, name, description, Number(category), Number(price), false);
    this.subscriptionService.saveSubscription(subscription).subscribe();
    this.subscriptionService.getSubscriptions().subscribe(
      subscriptions => {
        this.subscriptionsShareService.setSubscriptions(subscriptions);
      }
    )
  }

}
