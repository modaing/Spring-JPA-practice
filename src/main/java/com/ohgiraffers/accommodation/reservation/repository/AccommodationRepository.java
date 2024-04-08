package com.ohgiraffers.accommodation.reservation.repository;

import com.ohgiraffers.accommodation.reservation.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Integer> {
}
