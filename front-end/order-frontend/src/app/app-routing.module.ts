import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateOrderComponent } from './create-order/create-order.component';
import { OrderListComponent } from './order-list/order-list.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
import { ViewOrderComponent } from './view-order/view-order.component';

const routes: Routes = [
  {path:'orders', component:OrderListComponent},  // http://localhost:4200/orders -> return orderlist component
  {path:'', redirectTo:'orders', pathMatch:'full'}, // http://localhost:4200 -> return orderlist component
  {path:'request-order', component:CreateOrderComponent}, // http://localhost:4200/request-order -> return CreateOrderComponent
  {path:'edit-order/:id', component:UpdateOrderComponent}, // http://localhost:4200/update-order/1 -> return updateOrderComponent
  {path:'view-order/:id',component:ViewOrderComponent} // http://localhost:4200/view-order/1 -> return viewOrderComponent
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
