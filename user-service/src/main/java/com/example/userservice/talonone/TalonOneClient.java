package com.example.userservice.talonone;

import com.example.userservice.dto.UserRequestDTO;
import com.example.userservice.exception.TalonOneIntegrationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.HashMap;
import java.util.Map;

@Component
public class TalonOneClient {
    @Value("${talonone.api.url}")
    private String talonOneApiUrl;

    @Value("${talonone.api.key}")
    private String talonOneApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public void registerUserInTalonOne(UserRequestDTO userRequestDTO) {
        String url = talonOneApiUrl + "/v1/customers";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "ApiKey " + talonOneApiKey);

        Map<String, Object> body = new HashMap<>();
        body.put("integrationId", userRequestDTO.getEmail());
        body.put("attributes", Map.of(
            "name", userRequestDTO.getName(),
            "phone", userRequestDTO.getPhone(),
            "totalOrders", userRequestDTO.getTotalOrders(),
            "totalSpent", userRequestDTO.getTotalSpent()
        ));

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new TalonOneIntegrationException("Failed to register user in Talon.One: " + response.getBody());
            }
        } catch (HttpStatusCodeException e) {
            throw new TalonOneIntegrationException("Talon.One API error: " + e.getResponseBodyAsString(), e);
        } catch (Exception e) {
            throw new TalonOneIntegrationException("Error integrating with Talon.One", e);
        }
    }
}
