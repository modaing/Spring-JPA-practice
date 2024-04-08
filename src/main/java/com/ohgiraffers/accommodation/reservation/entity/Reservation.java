package com.ohgiraffers.accommodation.reservation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservation_code")
    private int reservationCode;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "number_of_person")
    private int numberOfPerson;

    @Column(name = "accommodation_code")
    private int accommodationCode;

    @Column(name = "reservation_date")
    private Date reservationDate;

    protected Reservation() {}

    public Reservation(int reservationCode, String clientName, String phone, int numberOfPerson, int accommodationCode, Date reservationDate) {
        this.reservationCode = reservationCode;
        this.clientName = clientName;
        this.phone = phone;
        this.numberOfPerson = numberOfPerson;
        this.accommodationCode = accommodationCode;
        this.reservationDate = reservationDate;
    }

    public int getReservationCode() {
        return reservationCode;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPhone() {
        return phone;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public int getAccommodationCode() {
        return accommodationCode;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationCode=" + reservationCode +
                ", clientName='" + clientName + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfPerson=" + numberOfPerson +
                ", accommodationCode=" + accommodationCode +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
