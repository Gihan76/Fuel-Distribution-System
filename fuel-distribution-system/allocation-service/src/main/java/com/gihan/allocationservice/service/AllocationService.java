package com.gihan.allocationservice.service;

import com.gihan.allocationservice.model.Allocation;
import com.gihan.allocationservice.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationService {
    @Autowired
    AllocationRepository allocationRepository;

    static int diesel = 10000;
    static int super_diesel = 10000;
    static int octane_92 = 10000;
    static int octane_95 = 10000;

    public Allocation makeAllocation(Integer id,Integer capacity,String fueltype){
        Allocation allocation = new Allocation();
        allocation.setOrder_id(id);
        allocation.setCapacity(capacity);
        allocation.setFuelType(fueltype);
        return allocationRepository.save(allocation);
    }
}
