import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAddressComponent } from './add-address/add-address.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { LoginComponent } from './login/login.component';
import { ProceedpageComponent } from './proceedpage/proceedpage.component';
import { RecoverpasswordComponent } from './recoverpassword/recoverpassword.component';
import { RegisterComponent } from './register/register.component';
import { ViewcustomersComponent } from './viewcustomers/viewcustomers.component';
import { ViewproductComponent } from './viewproduct/viewproduct.component';
import { ViewordersComponent } from './vieworders/vieworders.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { ProductcardComponent } from './productcard/productcard.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { AdminGuard } from './guards/admin.guard';
import { UserGuard } from './guards/user.guard';
import { ContactusComponent } from './contactus/contactus.component';
import { ViewprofileComponent } from './viewprofile/viewprofile.component';
import { ManageaddresComponent } from './manageaddres/manageaddres.component';
import { UpdateNewPasswordComponent } from './update-new-password/update-new-password.component';

const routes: Routes = [{path: 'register', component: RegisterComponent},
{path: 'login', component: LoginComponent},
{path: 'add-address', component: AddAddressComponent,canActivate:[UserGuard]},
{path: 'updatepassword', component: UpdateNewPasswordComponent,canActivate:[UserGuard]},
{path: 'manage-address', component: ManageaddresComponent,canActivate:[UserGuard]},
{path:'recoverpassword',component:RecoverpasswordComponent},
{path: 'addproduct', component: AddproductComponent,canActivate:[AdminGuard]},
{path: 'proceedpage', component: ProceedpageComponent,canActivate:[UserGuard]},
{path: 'viewprofile', component: ViewprofileComponent,canActivate:[UserGuard]},
{path: 'viewproduct', component: ViewproductComponent,canActivate:[AdminGuard]},
{path: 'viewcustomers', component: ViewcustomersComponent,canActivate:[AdminGuard]},
{path: 'vieworders', component: ViewordersComponent,canActivate:[AdminGuard]},
{path: 'orderhistory', component: OrderhistoryComponent,canActivate:[UserGuard]},
{path: '',component:ProductcardComponent},
{path: 'products',redirectTo:'',pathMatch:'full'},
{path: 'admindashboard', component: AdmindashboardComponent,canActivate:[AdminGuard]},
{path:'contactsus',component:ContactusComponent},
{path: '**', component: NotfoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
