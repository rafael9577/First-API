package myAPI.services.impl;

import java.util.NoSuchElementException;

import myAPI.model.Emporium;
import org.springframework.stereotype.Service;
import myAPI.repository.EmporiumRepository;
import myAPI.services.ServicesAPI;

@Service
public class EmporiumServiceImpl implements ServicesAPI {

	private final EmporiumRepository emporiumRepository;

	public EmporiumServiceImpl(EmporiumRepository emporiumRepository) {
		this.emporiumRepository = emporiumRepository;
	}



	@Override
	public Emporium findById(Long id) {
		return emporiumRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Emporium create(Emporium emporiumToCreate) {
		if (emporiumToCreate.getId() != null && emporiumRepository.existsById(emporiumToCreate.getId())) {
			throw new IllegalArgumentException("User id alread exists.");
		}
		return emporiumRepository.save(emporiumToCreate);
	}

}
