import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'; // imported
import { Order } from '../order/order'; // imported
import { OrderService } from '../order/order.service'; // imported
import { Router } from '@angular/router'; // imported

@Component({
  selector: 'app-update-order',
  templateUrl: './update-order.component.html',
  styleUrls: ['./update-order.component.css']
})
export class UpdateOrderComponent implements OnInit {

  id:number; // route parameter in the edit particular order
  order:Order = new Order(); // create an object of order

  constructor(
    private orderService:OrderService, // imported and injected
    private route:ActivatedRoute, // imported and injected
    private router:Router
    ) { } 

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']
    this.orderService.getOrderById(this.id)
      .subscribe(data => {
        this.order = data;
      });
  }

  onUpdate(){
    this.updateOrder();
  }

  updateOrder(){  
    this.id = this.route.snapshot.params['id'];
    this.orderService.updateOrder(this.order,this.id)
      .subscribe(data=>{
        console.log(data);
        this.navigateToOrders();
      })
  }

  navigateToOrders(){
    this.router.navigate(['/orders']);
  }

}
