package tn.esprit.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class AutolocApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutolocApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(VehiculeRepository vehiculeRepository) {
        return args -> {

            vehiculeRepository.save(new Vehicule(
                    null,
                    "123 TUN 4567",
                    "Toyota",
                    "Yaris",
                    CategorieVehicule.CITADINE,
                    new BigDecimal("80.00"),
                    StatutVehicule.DISPONIBLE
            ));

            vehiculeRepository.save(new Vehicule(
                    null,
                    "456 TUN 7890",
                    "BMW",
                    "Serie 3",
                    CategorieVehicule.BERLINE,
                    new BigDecimal("180.00"),
                    StatutVehicule.DISPONIBLE
            ));

            vehiculeRepository.save(new Vehicule(
                    null,
                    "789 TUN 1234",
                    "Hyundai",
                    "Tucson",
                    CategorieVehicule.SUV,
                    new BigDecimal("150.00"),
                    StatutVehicule.LOUE
            ));
        };
    }
}