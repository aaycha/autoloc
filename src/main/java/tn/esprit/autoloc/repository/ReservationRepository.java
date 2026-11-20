package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Reservation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository
        extends JpaRepository<Reservation, Long> {

    // Scénario 14
    List<Reservation> findByDateDebutAfter(LocalDate date);
}

