
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

            if (vehiculeRepository.count() == 0) {

                Vehicule v1 = new Vehicule();
                v1.setImmatriculation("123 TUN 4567");
                v1.setMarque("Toyota");
                v1.setModele("Yaris");
                v1.setCategorie(CategorieVehicule.CITADINE);
                v1.setTarifJournalier(new BigDecimal("80.00"));
                v1.setStatut(StatutVehicule.DISPONIBLE);
                vehiculeRepository.save(v1);

                Vehicule v2 = new Vehicule();
                v2.setImmatriculation("456 TUN 7890");
                v2.setMarque("BMW");
                v2.setModele("Serie 3");
                v2.setCategorie(CategorieVehicule.BERLINE);
                v2.setTarifJournalier(new BigDecimal("180.00"));
                v2.setStatut(StatutVehicule.DISPONIBLE);
                vehiculeRepository.save(v2);

                Vehicule v3 = new Vehicule();
                v3.setImmatriculation("789 TUN 1234");
                v3.setMarque("Hyundai");
                v3.setModele("Tucson");
                v3.setCategorie(CategorieVehicule.SUV);
                v3.setTarifJournalier(new BigDecimal("150.00"));
                v3.setStatut(StatutVehicule.LOUE);
                vehiculeRepository.save(v3);
            }
        };
    }
}
