import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import { ProductOffering } from '../../shared/ProductOffering';

@Injectable()

export class SubscriptionService {

  constructor(private http: HttpClient) {
  }

  getSubscriptions(): Observable<ProductOffering[]> {
    return this.http.get<ProductOffering[]>('/api/subs/get');
  }

  getSubscriptionById(id: number): Observable<ProductOffering> {
    let params = new HttpParams().set('id', id.toString());
    return this.http.get<ProductOffering>('/api/subs/get-by-id', {params: params});
  }

  getSubscriptionByName(name: string): Observable<ProductOffering> {
    let params = new HttpParams().set('name', name);
    return this.http.get<ProductOffering>('/api/subs/get-by-name', {params: params});
  }

  getSubscriptionByCategory(category: string): Observable<ProductOffering[]> {
    let params = new HttpParams().set('category', category);
    return this.http.get<ProductOffering[]>('/api/subs/get-by-category', {params: params});
  }

  saveSubscription(subscription: ProductOffering): Observable<ProductOffering> {
    return this.http.post<ProductOffering>('/api/subs/save', subscription);
  }

  banSubscription(id: number): Observable<ProductOffering> {
    return this.http.post<ProductOffering>('/api/subs/ban?id=' + id, id);
  }

  unBanSubscription(id: number): Observable<ProductOffering> {
    return this.http.post<ProductOffering>('/api/subs/unban?id=' + id, id);
  }

}
