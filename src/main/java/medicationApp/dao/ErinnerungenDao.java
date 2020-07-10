package medicationApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medicationApp.model.Erinnerung;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ErinnerungenDao extends JpaRepository<Erinnerung, Long> {
	Erinnerung getErinnerungByBezeichnung(String bezeichnung);
	List<Erinnerung> findAllByAnfangsdatumBeforeOrAnfangsdatumEqualsAndEnddatumAfterOrEnddatumEqualsAndAktivIsTrue(LocalDate date, LocalDate dateZwei, LocalDate dateDrei, LocalDate dateVier);
}
