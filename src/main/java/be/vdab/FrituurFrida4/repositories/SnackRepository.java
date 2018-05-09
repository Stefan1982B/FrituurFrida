package be.vdab.FrituurFrida4.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.FrituurFrida4.valueobjects.Snack;

public interface SnackRepository {
	 Optional<Snack> read(long id) ;
	 void update(Snack snack) ;
	 List<Snack> findByBeginNaam(String beginNaam) ;
}
