package myAPI.services;

import myAPI.model.Emporium;

public interface ServicesAPI {
	
	Emporium create(Emporium emporiumToCreate);
	Emporium findById(Long id);
	
}
