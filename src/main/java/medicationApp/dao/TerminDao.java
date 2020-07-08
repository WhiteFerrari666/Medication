package medicationApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medicationApp.model.Termin;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TerminDao extends JpaRepository<Termin, Long> {
    List<Termin> findAllByDatumIs(LocalDate date);
}
