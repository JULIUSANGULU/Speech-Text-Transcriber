package com.example.transcriber.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranscriptionService {

    private final String ML_SERVICE_URL = "http://localhost:5000/transcribe";

    private final RestTemplate restTemplate;

    public TranscriptionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String transcribeAudio(String audioFile) {
        return restTemplate.postForObject(ML_SERVICE_URL, audioFile, String.class);
    }
}