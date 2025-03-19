package com.example.transcriber.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/transcribe")
public class TranscriptionController {

    private final String ML_SERVICE_URL = "http://localhost:5000/transcribe";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<String> transcribeAudio(@RequestBody String audioFile) {
        String transcription = restTemplate.postForObject(ML_SERVICE_URL, audioFile, String.class);
        return ResponseEntity.ok(transcription);
    }
}