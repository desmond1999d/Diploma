import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {HttpService} from './http.service';
import {map} from 'rxjs/operators';
import {ProductOffering} from "../shared/ProductOffering";

const INIT_DATA = [];

@Injectable()
export class SubscriptionsShareService {
  private subscriptions = new BehaviorSubject(INIT_DATA);
  data$: Observable<any> = this.subscriptions.asObservable();

  constructor(private http: HttpService) {}

  getSubscriptions() {
    return this.subscriptions.getValue();
  }

  setSubscriptions(subscriptions: ProductOffering[]) {
    this.subscriptions.next(subscriptions);
  }
}
