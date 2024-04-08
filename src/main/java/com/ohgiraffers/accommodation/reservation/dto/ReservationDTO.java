package com.ohgiraffers.accommodation.reservation.dto;

import java.util.Date;

public class ReservationDTO {

    private int reservationCode;        // 예약 코드

    private String clientName;          // 예약자명

    private String phone;               // 휴대폰 번호

    private int numberOfPerson;         // 예약 인원

    private int accommodationCode;      // 숙소 코드

    private Date reservationDate;       // 예약한 날짜

    public ReservationDTO() {
    }

    public ReservationDTO(int reservationCode, String clientName, String phone, int numberOfPerson, int accommodationCode, Date reservationDate) {
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

    public void setReservationCode(int reservationCode) {
        this.reservationCode = reservationCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public int getAccommodationCode() {
        return accommodationCode;
    }

    public void setAccommodationCode(int accommodationCode) {
        this.accommodationCode = accommodationCode;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "reservationCode=" + reservationCode +
                ", clientName='" + clientName + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfPerson=" + numberOfPerson +
                ", accommodationCode=" + accommodationCode +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
