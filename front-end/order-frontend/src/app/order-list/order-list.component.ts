import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; //imported
import { Order } from '../order/order'; //imported
import { OrderService } from '../order/order.service'; //imported

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  orders: Order[];

  constructor(
    private orderService:OrderService, //imported and injected
    private router:Router //imported and injected
    ) { } 

  ngOnInit(): void {
    this.getOrders();
  }

  private getOrders(){
    this.orderService.getOrders()
      .subscribe(data=>{
        this.orders = data;
      })
  }

  updateOrder(id:number){
    this.router.navigate(['edit-order',id]);
  }

  deleteOrder(id:number){
    this.orderService.deleteOrder(id)
      .subscribe(data=>{
        console.log(data);
        this.getOrders();
      });
  }

  viewOrder(id:number){
    this.router.navigate(['view-order',id]);
  }

}
