package com.br.MS_Notify.service;

import com.br.MS_Notify.dto.ReceiverPaymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotifyService {

    @Autowired
    private KafkaTemplate<String, ReceiverPaymentEvent> kafkaTemplate;

    @KafkaListener(topics = "payments", groupId = "notify-group")
    public void receivePaymenteEvent(ReceiverPaymentEvent receiverPaymentEvent){
        System.out.println(receiverPaymentEvent);
    }
}
