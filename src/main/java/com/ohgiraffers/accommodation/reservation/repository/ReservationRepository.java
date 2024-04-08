package com.ohgiraffers.accommodation.reservation.repository;

import com.ohgiraffers.accommodation.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
