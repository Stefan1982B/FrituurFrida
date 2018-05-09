package be.vdab.FrituurFrida4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import be.vdab.FrituurFrida4.repositories.SausRepository;
import be.vdab.FrituurFrida4.valueobjects.Saus;

@Service
class DefaultSausService implements SausService{
	
	private final SausRepository sausRepository;
	
	DefaultSausService(@Qualifier("prop") SausRepository sausRepository){
		this.sausRepository = sausRepository;
	}

	@Override
	public List<Saus> findAll() {
		return sausRepository.findAll();
	}
	
	}

