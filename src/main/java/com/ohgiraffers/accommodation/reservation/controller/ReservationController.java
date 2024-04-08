package com.ohgiraffers.accommodation.reservation.controller;

import com.ohgiraffers.accommodation.common.Pagenation;
import com.ohgiraffers.accommodation.common.PagingButton;
import com.ohgiraffers.accommodation.reservation.dto.AccommodationDTO;
import com.ohgiraffers.accommodation.reservation.dto.ReservationDTO;
import com.ohgiraffers.accommodation.reservation.entity.Accommodation;
import com.ohgiraffers.accommodation.reservation.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/accommodation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/list")
    public String selectAllAccommodation(Model model, @PageableDefault Pageable pageable) {

        log.info("pageable : " + pageable);

        Page<AccommodationDTO> accommodations = reservationService.selectAllAccommodation(pageable);

        PagingButton paging = Pagenation.getPagingButtonInfo(accommodations);

        model.addAttribute("accommodations", accommodations);
        model.addAttribute("paging", paging);

        return "accommodation/list";
    }

//    @GetMapping("/{accommodationCode}")
//    public String selectAccommodation(@PathVariable int accommodationCode, Model model) {
//
//        AccommodationDTO eventAccommodation = reservationService.selectAccommodationByCode(accommodationCode);
//
//        model.addAttribute("eventAccommodation", eventAccommodation);
//
//        return "accommodation/event";
//    }

    @GetMapping("/reservation/{reservationCode}")
    public String selectReservation(@PathVariable("reservationCode") int reservationCode, Model model) {

        System.out.println(reservationCode);
        ReservationDTO reservation = reservationService.selectReservationByCode(reservationCode);

        System.out.println(reservation);

        model.addAttribute("reservation", reservation);

        return "accommodation/details";
    }

    @GetMapping("/reservation")
    public void reservation() {
    }

    @GetMapping(value = "/name", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<AccommodationDTO> selectAccommodationList() {
        return reservationService.selectAllAccommodationList();
    }

    @PostMapping("/reservation")
    public String reservationAccommodation(@RequestParam ReservationDTO reservationDTO) {

        reservationService.reservation(reservationDTO);

        return "redirect:/main";
    }

    @GetMapping("/modify")
    public void modifyAccommodation() {}

    @PostMapping("/modify")
    public String modifyReservation(ReservationDTO reservationDTO) {
        reservationService.modifyReservation(reservationDTO);
        return "redirect:/main";
    }




}