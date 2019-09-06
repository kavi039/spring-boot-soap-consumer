
package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import hello.GetCountryRequest;
import hello.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	public GetCountryResponse getCountry(GetCountryRequest request) {

//		GetCountryRequest request = new GetCountryRequest();
//		request.setName(country);

		log.info("Requesting location for " + request.getName());

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries", request);
		return response;
	}

}
