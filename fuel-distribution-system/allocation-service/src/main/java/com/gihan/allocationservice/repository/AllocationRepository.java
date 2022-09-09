package com.gihan.allocationservice.repository;

import com.gihan.allocationservice.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation,Integer> {
}
