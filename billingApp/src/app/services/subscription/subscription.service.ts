import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import { ProductOffering } from '../../shared/ProductOffering';
import {HttpService} from "../http.service";

@Injectable()
export class SubscriptionService {

  constructor(private http: HttpClient) {
  }

  getSubscriptions(): Observable<ProductOffering[]> {
    return this.http.get<ProductOffering[]>('/api/catalog/get', HttpService.httpOptions);
  }

  getSubscriptionById(id: number): Observable<ProductOffering> {
    let params = new HttpParams().set('id', id.toString());
    return this.http.get<ProductOffering>('/api/catalog/get-by-id', {params: params, headers: HttpService.httpOptions.headers});
  }

  getSubscriptionByName(name: string): Observable<ProductOffering> {
    let params = new HttpParams().set('name', name);
    return this.http.get<ProductOffering>('/api/catalog/get-by-name', {params: params, headers: HttpService.httpOptions.headers});
  }

  getSubscriptionByCategory(category: string): Observable<ProductOffering[]> {
    let params = new HttpParams().set('category', category);
    return this.http.get<ProductOffering[]>('/api/catalog/get-by-category', {params: params, headers: HttpService.httpOptions.headers});
  }

  saveSubscription(subscription: ProductOffering): Observable<ProductOffering> {
    return this.http.post<ProductOffering>('/api/catalog/save', subscription, HttpService.httpOptions);
  }

  banSubscription(id: number): Observable<ProductOffering> {
    return this.http.post<ProductOffering>('/api/catalog/ban?id=' + id, id, HttpService.httpOptions);
  }

  unBanSubscription(id: number): Observable<ProductOffering> {
    return this.http.post<ProductOffering>('/api/catalog/unban?id=' + id, id, HttpService.httpOptions);
  }

}
