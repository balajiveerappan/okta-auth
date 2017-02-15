package com.cglean.wb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthServiceApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	public void getAccessDeniedError() {

		ResponseEntity<?> response = testRestTemplate.getForEntity("/", String.class);
		boolean statusIs4xx = response.getStatusCode().is4xxClientError();
		// Assert status is 4xx
		assertThat(statusIs4xx, is(true));

		// Assert that status is 401 - UnAuthorized.
		int val401 = 401;
		int statusCode = Integer.parseInt(response.getStatusCode().toString());
		assertThat(statusCode, is(val401));

		// Assert response is Not null
		assertThat(response, is(notNullValue()));

	}

}
