package medicationApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import medicationApp.model.Erinnerung;

public interface ErinnerungenDao extends JpaRepository<Erinnerung, Long> {
	Erinnerung findErinnerungByAktivFalse();
	void countAllByBezeichnungEndingWith(String test);
}
