package com.ohgiraffers.accommodation.reservation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accommodation")
public class Accommodation {

    @Id
    @Column(name = "accommodation_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accommodationCode;

    @Column(name = "accommodation_name")
    private String accommodationName;

    @Column(name = "accommodation_price")
    private int accommodationPrice;

    @Column(name = "event_price")
    private int eventPrice;

    @Column(name = "discount_rate")
    private int discountRate;

    @Column(name = "accommodation_address")
    private String accommodationAddress;

    @Column(name = "grade")
    private double grade;

    protected Accommodation() {}

    public Accommodation(int accommodationCode, String accommodationName, int accommodationPrice, int eventPrice, int discountRate, String accommodationAddress, double grade) {
        this.accommodationCode = accommodationCode;
        this.accommodationName = accommodationName;
        this.accommodationPrice = accommodationPrice;
        this.eventPrice = eventPrice;
        this.discountRate = discountRate;
        this.accommodationAddress = accommodationAddress;
        this.grade = grade;
    }

    public int getAccommodationCode() {
        return accommodationCode;
    }

    public String getAccommodationName() {
        return accommodationName;
    }

    public int getAccommodationPrice() {
        return accommodationPrice;
    }

    public String getAccommodationAddress() {
        return accommodationAddress;
    }

    public double getGrade() {
        return grade;
    }

    public int getEventPrice() {
        return eventPrice;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "accommodationCode=" + accommodationCode +
                ", accommodationName='" + accommodationName + '\'' +
                ", accommodationPrice=" + accommodationPrice +
                ", eventPrice=" + eventPrice +
                ", discountRate=" + discountRate +
                ", accommodationAddress='" + accommodationAddress + '\'' +
                ", grade=" + grade +
                '}';
    }
}
