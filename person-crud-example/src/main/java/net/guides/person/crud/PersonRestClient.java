package net.guides.person.crud;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import net.guides.person.crud.model.Person;

public class PersonRestClient {

	private static final String GET_PERSONS_ENDPOINT_URL = "http://localhost:8080/api/v1/persons";
	private static final String GET_PERSON_ENDPOINT_URL = "http://localhost:8080/api/v1/persons/{id}";
	private static final String CREATE_PERSON_ENDPOINT_URL = "http://localhost:8080/api/v1/persons";
	private static final String UPDATE_PERSON_ENDPOINT_URL = "http://localhost:8080/api/v1/persons/{id}";
	private static final String DELETE_PERSON_ENDPOINT_URL = "http://localhost:8080/api/v1/persons/{id}";
	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		PersonRestClient personRestClient = new PersonRestClient();
		
		// Step1: first create a new person
		personRestClient.createPerson();
		
		// Step 2: get new created person from step1
		personRestClient.getPersonById();
		
		// Step3: get all persons
		personRestClient.getPersons();
		
		// Step4: Update person with id = 1
		personRestClient.updatePerson();
		
		// Step5: Delete person with id = 1
		personRestClient.deletePerson();
	}

	private void getPersons() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_PERSONS_ENDPOINT_URL, HttpMethod.GET, entity,
				String.class);

		System.out.println(result);
	}

	private void getPersonById() {

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");

		RestTemplate restTemplate = new RestTemplate();
		Person result = restTemplate.getForObject(GET_PERSON_ENDPOINT_URL, Person.class, params);

		System.out.println(result);
	}

	private void createPerson() {

		Person newPerson = new Person("admin", "admin", "admin@gmail.com");

		RestTemplate restTemplate = new RestTemplate();
		Person result = restTemplate.postForObject(CREATE_PERSON_ENDPOINT_URL, newPerson, Person.class);

		System.out.println(result);
	}

	private void updatePerson() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		Person updatedPerson = new Person("admin123", "admin123", "admin123@gmail.com");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(UPDATE_PERSON_ENDPOINT_URL, updatedPerson, params);
	}

	private void deletePerson() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(DELETE_PERSON_ENDPOINT_URL, params);
	}
}
