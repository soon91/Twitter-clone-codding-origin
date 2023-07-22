package com.twitter.clone.twitterclone.register.controller;

import com.twitter.clone.twitterclone.register.model.request.EmailRequest;
import com.twitter.clone.twitterclone.register.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send/email")
    public String sendEmail(@RequestBody EmailRequest request) throws MessagingException, UnsupportedEncodingException {
        String emailCode = emailService.sendEmail(request.getEmail());
        return emailCode;
    }
}
