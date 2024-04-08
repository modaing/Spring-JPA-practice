package com.ohgiraffers.accommodation.reservation.dto;

public class AccommodationDTO {

    private int accommodationCode;          // 숙소 코드

    private String accommodationName;       // 숙소 이름

    private int accommodationPrice;         // 숙소 원가

    private int eventPrice;                 // 이벤트가

    private int discountRate;                // 할인율

    private String accommodationAddress;    // 숙소 위치

    private int grade;                      // 평점

    public AccommodationDTO() {
    }

    public AccommodationDTO(int accommodationCode, String accommodationName, int accommodationPrice, int eventPrice, int discountRate, String accommodationAddress, int grade) {
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

    public void setAccommodationCode(int accommodationCode) {
        this.accommodationCode = accommodationCode;
    }

    public String getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(String accommodationName) {
        this.accommodationName = accommodationName;
    }

    public int getAccommodationPrice() {
        return accommodationPrice;
    }

    public void setAccommodationPrice(int accommodationPrice) {
        this.accommodationPrice = accommodationPrice;
    }

    public String getAccommodationAddress() {
        return accommodationAddress;
    }

    public void setAccommodationAddress(String accommodationAddress) {
        this.accommodationAddress = accommodationAddress;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(int eventPrice) {
        this.eventPrice = eventPrice;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return "AccommodationDTO{" +
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
