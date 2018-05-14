package be.vdab.FrituurFrida4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.FrituurFrida4.repositories.SnackRepository;
import be.vdab.FrituurFrida4.valueobjects.Snack;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultSnackService implements SnackService{
	
	private SnackRepository snackRepository;
	
	DefaultSnackService(SnackRepository snackRepository){
		this.snackRepository=snackRepository;
	}

	@Override
	public Optional<Snack> read(long id) {
		return snackRepository.read(id);
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void update(Snack snack) {
		snackRepository	.update(snack);	
	}

	@Override
	public List<Snack> findByBeginNaam(String beginNaam) {
		return snackRepository.findByBeginNaam(beginNaam);
	}
	
	@Override
	public List<Snack>findAll(){
		return snackRepository.findAll();
	}

}
