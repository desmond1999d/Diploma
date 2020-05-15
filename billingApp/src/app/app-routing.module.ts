import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductsListComponent } from './modules/subscriptions/components/productsList/productsList.component';
import {ProductDetailsComponent} from './modules/subscriptions/components/productDetails/productDetails.component';
import {LoginComponent} from './modules/subscriptions/components/login/login.component.';
import {RegistrationComponent} from './modules/subscriptions/components/registration/registration.component';
import {CreateBillingAccountComponent} from './modules/subscriptions/components/createBillingAccount/createBillingAccount.component';
import {ProfileDetailsComponent} from './modules/subscriptions/components/profileDetails/profileDetails.component';
import {ManageBillingAccountComponent} from './modules/subscriptions/components/manageBillingAccount/manageBillingAccount.component';
import {AdminAccountComponent} from "./modules/subscriptions/components/adminAccount/adminAccount.component";
import {CreateSubscriptionComponent} from "./modules/subscriptions/components/createSubscription/createSubscription.component";

const routes: Routes = [
  { path: 'subscriptions', component: ProductsListComponent },
  { path: '', redirectTo: '/subscriptions',
  pathMatch: 'full'},
  { path: 'details/:id', component: ProductDetailsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'createBillingAccount', component: CreateBillingAccountComponent },
  { path: 'user/:id', component: ProfileDetailsComponent },
  { path: 'manageBillingAccount', component: ManageBillingAccountComponent },
  { path: 'adminAccount', component: AdminAccountComponent },
  { path: 'createSubscription', component: CreateSubscriptionComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
