package com.gihan.allocationservice.model;

import javax.persistence.*;

@Entity
@Table(name = "order_allocation")
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int order_id;
    private int capacity;
    @Column(name = "fuel_type")
    private String fuelType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", capacity=" + capacity +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
