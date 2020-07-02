package medicationApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medicationApp.model.Erinnerung;
import org.springframework.stereotype.Repository;

@Repository
public interface ErinnerungenDao extends JpaRepository<Erinnerung, Long> {
	Erinnerung findErinnerungByAktivFalse();
	void countAllByBezeichnungEndingWith(String test);
	Erinnerung getErinnerungByBezeichnungIsNotNull();
}
