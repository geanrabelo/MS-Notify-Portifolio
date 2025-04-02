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

    public Email(String to){
        this.from = "geancardosorabelomota@gmail.com";
        this.to = to;
        this.subject = "Micro service of Project Portifólio";
        this.text = "Testing ms send email";
    }
}
