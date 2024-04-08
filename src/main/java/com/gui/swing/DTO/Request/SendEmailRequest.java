package com.gui.swing.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendEmailRequest {
    private String toEmail;
    private String subject;
    private Map<String,Object> context;
}
