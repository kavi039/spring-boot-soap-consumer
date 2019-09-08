
package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import hello.Param0;

public class CountryClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	public Param0 getCountry(Param0 param0) {

//		GetCountryRequest request = new GetCountryRequest();
//		request.setName(country);

		log.info("Requesting location for " + param0.getRequest());

		Param0 response = null;
		try {
		response = (Param0) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries", param0);
		} catch (Exception e) {

			log.info("Requesting location for----------------------- " + e.getMessage());
		}
		return response;
	}

}
