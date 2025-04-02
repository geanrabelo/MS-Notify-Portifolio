package com.br.MS_Notify.controller;

import com.br.MS_Notify.domain.Email;
import com.br.MS_Notify.dto.EmailDTO;
import com.br.MS_Notify.dto.MessageDTO;
import com.br.MS_Notify.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms/notify")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody EmailDTO emailDTO) throws MessagingException {
        emailService.enviarEmail(new Email(emailDTO.to()));
        return ResponseEntity.ok(new MessageDTO("Send email!"));
    }
}
