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
}
