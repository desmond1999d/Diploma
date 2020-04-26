import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductInstance} from "../../shared/ProductInstance";

@Injectable()

export class SubscriptionUnitService {

  constructor(private http: HttpClient) {
  }

  public getSubscriptionUnitsById(id: number): Observable<ProductInstance[]> {
    let params = new HttpParams().set('userId', id.toString());
    return this.http.get<ProductInstance[]>('/api/subsunits/get-by-userid', {params: params});
  }

  public saveSubscriptionUnit(subscriptionUnit: ProductInstance) {
    return this.http.post<ProductInstance>('/api/subsunits/save', subscriptionUnit);
  }

  public deleteSubscriptionUnit(subscriptionUnit: ProductInstance) {
    return this.http.delete('/api/subsunits/delete/' + subscriptionUnit.id + '?id=' + subscriptionUnit.id);
  }

  public changeStatusSubscriptionUnit(subscriptionUnit: ProductInstance) {
    return this.http.post<ProductInstance>('/api/subsunits/change-status', subscriptionUnit);
  }

}
