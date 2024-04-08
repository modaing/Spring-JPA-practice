package com.ohgiraffers.accommodation.reservation.repository;

import com.ohgiraffers.accommodation.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value = "SELECT reservation_code, client_name, phone, number_of_person, reservation_date, accommodation_code " +
            "FROM reservation" +
            " WHERE reservation_code =:reservation_code",
            nativeQuery = true
    )
    Reservation findMyReservation(@Param("reservation_code") int reservationCode);
}
