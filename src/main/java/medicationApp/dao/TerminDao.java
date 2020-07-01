package medicationApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medicationApp.model.Termin;

@Repository
public interface TerminDao extends JpaRepository<Termin, Long> {

}
