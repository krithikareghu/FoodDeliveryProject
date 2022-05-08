package com.project.FoodDeliveryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.FoodDeliveryService.Model.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long>{

}
