import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../order/order'; //imported
import { OrderService } from '../order/order.service'; //imported

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {

  order:Order = new Order(); // create an object of order

  constructor(
    private orderService:OrderService, //imported
    private router:Router //imported
    ) { }

  ngOnInit(): void {
  }

  onSubmit(){
    // console.log(this.order);
    this.createOrder();
  }

  createOrder(){
    this.orderService.creatOrder(this.order)
      .subscribe(data=>{
        console.log(data),
        this.navigateToOrders();
      });  
  }

  navigateToOrders(){
    this.router.navigate(['/orders']);
  }

}
