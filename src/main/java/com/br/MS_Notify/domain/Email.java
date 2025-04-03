package com.br.MS_Notify.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Email {

    private String from;
    private String to;
    private String subject;
    private String text;

    public Email(String to, String subject, String text){
        this.from = "geancardosorabelomota@gmail.com";
        this.to = to;
        this.subject = subject;
        this.text = text;
    }
}
