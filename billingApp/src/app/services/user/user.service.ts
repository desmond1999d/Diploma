import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from "../../shared/User";
import {RequestOptions} from "@angular/http";
import {HttpService} from "../http.service";

@Injectable()

export class UserService {

  constructor(private http: HttpClient) {
  }

  getAllUsers(): Observable<any> {
    return this.http.post('/api/ua/get-all', null);
  }

  getUser(login: string, password: string): Observable<any> {
    return this.http.post('/api/ua/get-by-data?login=' + login, password, HttpService.httpOptions);
  }

  getUserById(id: number): Observable<User> {
    let params = new HttpParams().set('id', id.toString());
    return this.http.get<User>('/api/ua/get-by-id', {params: params, headers: HttpService.httpOptions.headers});
  }

  createUser(user: User, activeBillingAccountId: number) {
    return this.http.post<User>('/api/ua/save?activeBillingAccountId='+activeBillingAccountId, user, HttpService.httpOptions);
  }

  ban(user: User) {
    return this.http.post<User>('/api/ua/ban', user, HttpService.httpOptions);
  }

  unBan(user: User) {
    return this.http.post<User>('/api/ua/unban', user, HttpService.httpOptions);
  }

  changeActiveBillingAccount(user: User, billingAccountId: number) {
    return this.http.post<User>('/api/ua/change-BillingAccount?billingAccountId=' + billingAccountId, user, HttpService.httpOptions);
  }

  getSubscriptionsQuantity(id: number) {
    return this.http.get<number>('/api/ua/productOffering-unit/quantity?id=' + id, HttpService.httpOptions);
  }

}
