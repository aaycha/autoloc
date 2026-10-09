package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService reservationService;

    @GetMapping
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation retrieveReservation(@PathVariable Long id) {
        return reservationService.retrieveReservation(id);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(
            @PathVariable Long id,
            @RequestBody Reservation reservation) {
        reservation.setIdReservation(id);
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void removeReservation(@PathVariable Long id) {
        reservationService.removeReservation(id);
    }

    @PostMapping("/batch")
    public List<Reservation> addReservations(
            @RequestBody List<Reservation> reservations) {
        return reservationService.addReservations(reservations);
    }
}

