import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Order } from '../order/order';
import { OrderService } from '../order/order.service';

@Component({
  selector: 'app-view-order',
  templateUrl: './view-order.component.html',
  styleUrls: ['./view-order.component.css']
})
export class ViewOrderComponent implements OnInit {
  id:number;
  order:Order = new Order();

  constructor(
    private orderService:OrderService, // imported and injected
    private route:ActivatedRoute // imported and injected
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.orderService.getOrderById(this.id)
      .subscribe(data=>{
        this.order = data;
      });
  }

}
