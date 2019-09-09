package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import service.CountryClient;

@RestController
public class CountryController {
	
	@Autowired
	CountryClient countryClient;
	
	@PostMapping(value = "/country", produces = MediaType.APPLICATION_XML_VALUE)
	public Param0 getCountry(@RequestBody Param0 param0) {
		param0 = countryClient.getCountry(param0);
		return param0;
	}

}
