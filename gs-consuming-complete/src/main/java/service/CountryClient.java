
package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SerializationUtils;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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
					.marshalSendAndReceive("http://172.16.30.31:9090/gs-producing-web-service/ws/countries", param0);
			XmlMapper xmlMapper = new XmlMapper();
			JsonNode jsonNode = xmlMapper.readTree(SerializationUtils.serialize(response));
			ObjectMapper objectMapper = new ObjectMapper();
			String result = objectMapper.writeValueAsString(jsonNode);
			System.out.println(response);
			log.info("API response after converting to json : {} ", result);

			System.out.println(response);
		} catch (Exception e) {

			log.info("Requesting location for----------------------- " + e.getMessage());
		}
		return response;
	}

}
