package myAPI.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import myAPI.model.Emporium;
import myAPI.services.ServicesAPI;

@RestController
@RequestMapping("/emporium")
public class EmporiumController {
	
	private final ServicesAPI emporiumServices;
	
	public EmporiumController(ServicesAPI EmporiumServices) {
		this.emporiumServices = EmporiumServices;
	}
	
	@PostMapping
	public ResponseEntity<Emporium> Create(@RequestBody Emporium emporiumToCreate) {
		var emporiumCreated = emporiumServices.create(emporiumToCreate);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(emporiumToCreate.getId())
				.toUri();
		return ResponseEntity.created(location).body(emporiumCreated);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emporium> FindById(@PathVariable Long id) {
		var emporium = emporiumServices.findById(id);
		return ResponseEntity.ok(emporium);
	}
}
