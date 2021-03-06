import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductsListComponent} from './components/productsList/productsList.component';
import {ButtonsModule} from 'ngx-bootstrap/buttons';
import {NgxPaginationModule} from 'ngx-pagination';
import {HeaderComponent} from './components/header/header.component';
import {RouterModule} from '@angular/router';
import {ProductDetailsComponent} from './components/productDetails/productDetails.component';
import {LoginComponent} from './components/login/login.component.';
import {RegistrationComponent} from './components/registration/registration.component';
import {CreateBillingAccountComponent} from './components/createBillingAccount/createBillingAccount.component';
import {UserSubscriptionsComponent} from './components/userSubscriptions/userSubscriptions.component';
import {UserBillingAccountsComponent} from './components/userBillingAccounts/userBillingAccounts.component';
import {ProfileDetailsComponent} from './components/profileDetails/profileDetails.component';
import {AdminAccountComponent} from './components/adminAccount/adminAccount.component';
import {ManageBillingAccountComponent} from './components/manageBillingAccount/manageBillingAccount.component';
import {CreateSubscriptionComponent} from "./components/createSubscription/createSubscription.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CollapseModule } from 'ngx-bootstrap/collapse';
import { CarouselModule } from 'ngx-bootstrap/carousel';

@NgModule({
  imports: [
    CommonModule,
    ButtonsModule,
    NgxPaginationModule,
    RouterModule,
    BrowserAnimationsModule,
    CollapseModule.forRoot(),
    BrowserAnimationsModule,
    CarouselModule.forRoot()
  ],
  exports: [
    ProductsListComponent,
    HeaderComponent,
    ProductDetailsComponent,
    LoginComponent,
    RegistrationComponent,
    CreateBillingAccountComponent,
    UserSubscriptionsComponent,
    UserBillingAccountsComponent,
    ProfileDetailsComponent,
    AdminAccountComponent,
    ManageBillingAccountComponent,
    CreateSubscriptionComponent
  ],
  declarations: [
    ProductsListComponent,
    HeaderComponent,
    ProductDetailsComponent,
    LoginComponent,
    RegistrationComponent,
    CreateBillingAccountComponent,
    UserSubscriptionsComponent,
    UserBillingAccountsComponent,
    ProfileDetailsComponent,
    AdminAccountComponent,
    ManageBillingAccountComponent,
    CreateSubscriptionComponent
  ],
  providers: []
})
export class SubscriptionsModule {

}
