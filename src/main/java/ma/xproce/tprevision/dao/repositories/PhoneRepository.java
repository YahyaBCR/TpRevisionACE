package ma.xproce.tprevision.dao.repositories;

import ma.xproce.tprevision.dao.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByModel(String model);
    List<Phone> findByModelAndPrice(String model, Float price);
    Optional<Phone> findByIMEI(String IMEI);
}
