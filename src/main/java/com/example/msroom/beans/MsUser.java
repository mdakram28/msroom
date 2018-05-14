package com.example.msroom.beans;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;

public class MsUser {

	private String baseUrl;

	public MsUser() {
	}

	@Autowired
	private HttpServletRequest request;

	public HttpEntity<String> httpEntity() {
		HttpHeaders headers = new HttpHeaders();
		String token = request.getHeader("Authorization");
		headers.set("Authorization", token);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		return entity;
	}

	public UserDetails getUserDetails() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		final String url = baseUrl + "/details";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserDetails> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity(), UserDetails.class);
		return response.getBody();
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	
}
