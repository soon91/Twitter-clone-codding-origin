package com.twitter.clone.twitterclone.register.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;
    private String emailCode;

    public void createEmailCode() {
        String randomStr = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            randomStr+=random.nextInt(9);
        }
        emailCode = randomStr;
    }

    public MimeMessage createEmail(String email) throws MessagingException, UnsupportedEncodingException {
        createEmailCode();

        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, email);
        message.setSubject("twitter-clone 회원가입 인증 번호");
        message.setText("인증 번호 : " + emailCode, "utf-8", "html");
        message.setFrom(new InternetAddress("vbc1124@naver.com","twitter-clone_Admin"));

        return message;
    }

    public String sendEmail(String email) throws MessagingException, UnsupportedEncodingException {
        MimeMessage emailForm = createEmail(email);
        emailSender.send(emailForm);

        return emailCode;
    }
}
