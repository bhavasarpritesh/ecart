import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SlidemenuComponent } from './slidemenu/slidemenu.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { RegisterComponent } from './register/register.component';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatNativeDateModule} from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import {MatRadioModule} from '@angular/material/radio';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { AddAddressComponent } from './add-address/add-address.component';
import { RecoverpasswordComponent } from './recoverpassword/recoverpassword.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { ProceedpageComponent } from './proceedpage/proceedpage.component';
import { ViewproductComponent } from './viewproduct/viewproduct.component';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatPaginatorModule } from '@angular/material/paginator';
import { ViewcustomersComponent } from './viewcustomers/viewcustomers.component';
import { ViewordersComponent } from './vieworders/vieworders.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { ProductcardComponent } from './productcard/productcard.component';
import   { MatCardModule} from '@angular/material/card';
import {MatBadgeModule} from '@angular/material/badge';
import { CartdialogComponent } from './cartdialog/cartdialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { SuccessalertComponent } from './successalert/successalert.component';
import { ProductdialougeComponent } from './productdialouge/productdialouge.component';
import { UpdateproductComponent } from './updateproduct/updateproduct.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { TokenInterceptor } from './services/TokenInterceptor';
import { OtpdialogComponent } from './otpdialog/otpdialog.component';
import { AdminGuard } from './guards/admin.guard';
import { ContactusComponent } from './contactus/contactus.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import { ViewprofileComponent } from './viewprofile/viewprofile.component';
import { ManageaddresComponent } from './manageaddres/manageaddres.component';
import { UpdateaddresComponent } from './updateaddres/updateaddres.component';
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { UpdateNewPasswordComponent } from './update-new-password/update-new-password.component';
import { HashLocationStrategy, LocationStrategy  } from '@angular/common';
@NgModule({
  declarations: [
    AppComponent,
    SlidemenuComponent,
    RegisterComponent,
    LoginComponent,
    AddAddressComponent,
    RecoverpasswordComponent,
    AddproductComponent,
    ProceedpageComponent,
    ViewproductComponent,
    ViewcustomersComponent,
    ViewordersComponent,
    OrderhistoryComponent,
    ProductcardComponent,
    CartdialogComponent,
    AdmindashboardComponent,
    SuccessalertComponent,
    ProductdialougeComponent,
    UpdateproductComponent,
    NotfoundComponent,
    OtpdialogComponent,
    ContactusComponent,
    ViewprofileComponent,
    ManageaddresComponent,
    UpdateaddresComponent,
    UpdateNewPasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatGridListModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    MatSelectModule,
    MatIconModule,
    MatRadioModule,
    ReactiveFormsModule,
    FormsModule,
    MatTableModule,
    MatSortModule,
    FlexLayoutModule,
    MatPaginatorModule,
    MatCardModule,
    MatBadgeModule,
    MatDialogModule,
    HttpClientModule,
    MatTooltipModule,
    NgbModule
  ],
  providers: [ {  
    provide: HTTP_INTERCEPTORS,  
    useClass: TokenInterceptor,  
    multi: true  
  } ,{provide : LocationStrategy , useClass: HashLocationStrategy} ],
  bootstrap: [AppComponent]
})
export class AppModule { }
