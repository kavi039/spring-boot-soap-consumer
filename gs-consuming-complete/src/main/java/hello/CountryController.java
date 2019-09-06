package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import service.CountryClient;

@RestController
public class CountryController {
	
	@Autowired
	CountryClient countryClient;
	
	@PostMapping("/country")
	public GetCountryResponse getCountry(@RequestBody GetCountryRequest getCountryRequest) {
		GetCountryResponse countryResponse = countryClient.getCountry(getCountryRequest);
		return countryResponse;
	}

}
