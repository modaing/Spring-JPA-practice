package com.ohgiraffers.accommodation.reservation.service;

import com.ohgiraffers.accommodation.reservation.dto.AccommodationDTO;
import com.ohgiraffers.accommodation.reservation.dto.ReservationDTO;
import com.ohgiraffers.accommodation.reservation.entity.Accommodation;
import com.ohgiraffers.accommodation.reservation.entity.Reservation;
import com.ohgiraffers.accommodation.reservation.repository.AccommodationRepository;
import com.ohgiraffers.accommodation.reservation.repository.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final AccommodationRepository accommodationRepository;
    private final ReservationRepository reservationRepository;

    private final ModelMapper modelMapper;

    public ReservationService(AccommodationRepository accommodationRepository,
                              ReservationRepository reservationRepository,
                              ModelMapper modelMapper) {
        this.accommodationRepository = accommodationRepository;
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
    }

    public Page<AccommodationDTO> selectAllAccommodation(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("grade").descending());

        Page<Accommodation> accommodations = accommodationRepository.findAll(pageable);

        return accommodations.map(accommodation -> modelMapper.map(accommodation, AccommodationDTO.class));
    }

    public AccommodationDTO selectAccommodationByCode(int accommodationCode) {

        Accommodation eventAccommodation = accommodationRepository.findById(accommodationCode).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(eventAccommodation, AccommodationDTO.class);
    }

    public void reservation(ReservationDTO reservationDTO) {
        reservationRepository.save(modelMapper.map(reservationDTO,Reservation.class));
    }

    public List<AccommodationDTO> selectAllAccommodationList() {
        List<Accommodation> accommodationList = accommodationRepository.findAllAccommodation();

        return accommodationList.stream()
                .map(accommodation -> modelMapper.map(accommodation, AccommodationDTO.class))
                .collect(Collectors.toList());
    }

    public void modifyReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.findById(reservationDTO.getReservationCode()).orElseThrow();

        reservation = reservation.reservationDate(reservationDTO.getReservationDate()).builder();
        reservationRepository.save(reservation);
    }

    public ReservationDTO selectReservationByCode(int reservationCode) {

        System.out.println(reservationCode);
        Reservation myReservation = reservationRepository.findMyReservation(reservationCode);

        System.out.println(myReservation);
        return modelMapper.map(myReservation, ReservationDTO.class);
    }

    public void deleteReservation(Integer reservationCode) {
        reservationRepository.deleteById(reservationCode);
    }
}
