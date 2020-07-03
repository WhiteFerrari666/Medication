package medicationApp.dao;

import medicationApp.model.Medikament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedikamentDao extends JpaRepository <Medikament, Long> {

}
