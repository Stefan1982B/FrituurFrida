package be.vdab.FrituurFrida4.services;

import java.util.List;
import java.util.Optional;

import be.vdab.FrituurFrida4.valueobjects.Snack;

public interface SnackService {
	Optional<Snack> read(long id);

	void update(Snack snack);

	List<Snack> findByBeginNaam(String beginNaam);
	
	List<Snack> findAll();
}
