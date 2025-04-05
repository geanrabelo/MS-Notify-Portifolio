package com.br.MS_Notify.service;

import com.br.MS_Notify.domain.Email;
import com.br.MS_Notify.dto.ReceiverPaymentEvent;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotifyService {

    @Autowired
    private KafkaTemplate<String, ReceiverPaymentEvent> kafkaTemplate;

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "payments", groupId = "notify-group")
    public void receivePaymenteEvent(ReceiverPaymentEvent receiverPaymentEvent) throws MessagingException {
        System.out.println("RECEBIDO!");
        emailService.enviarEmail(new Email(receiverPaymentEvent.getEmail(),
                "Request placed. - MS-Portfolio",
                "Total Value: "+receiverPaymentEvent.getAmount()+
                        "\n OrderID: "+receiverPaymentEvent.getOrderId()+
                        "\n PaymentId: "+receiverPaymentEvent.getPaymentId()));
    }
}
