package com.ohgiraffers.accommodation.reservation.repository;

import com.ohgiraffers.accommodation.reservation.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccommodationRepository extends JpaRepository<Accommodation, Integer> {
    @Query(value = "SELECT accommodation_code, accommodation_name, accommodation_price, accommodation_address, event_price, discount_rate, grade" +
                    " FROM accommodation ORDER BY accommodation_code",
                    nativeQuery = true)
    List<Accommodation> findAllAccommodation();
}
