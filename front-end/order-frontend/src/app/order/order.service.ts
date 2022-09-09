import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http' //imported
import { Observable } from 'rxjs'; //imported
import { Order } from "../order/order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = "http://localhost:8080/orders";
  private creatOrderUrl = "http://localhost:8080/order";
  private getOrderByIdUrl = "http://localhost:8080/order"; // http://localhost:8080/order/2
  private deleteOrderByIdUrl = "http://localhost:8080/order"; // http://localhost:8080/order/2

  constructor(private httpClient: HttpClient) {} // imported and injected http client

  getOrders():Observable<Order[]>{
    return this.httpClient.get<Order[]>(this.baseUrl);
  }

  creatOrder(order:Order):Observable<Object>{
    return this.httpClient.post(this.creatOrderUrl,order);
  }

  getOrderById(id:number):Observable<Order>{
    return this.httpClient.get<Order>(`${this.getOrderByIdUrl}/${id}`);
  }

  updateOrder(order:Order,id:number):Observable<Order>{
    return this.httpClient.put<Order>(`${this.getOrderByIdUrl}/${id}`,order);
  }

  deleteOrder(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.deleteOrderByIdUrl}/${id}`);
  }
}
