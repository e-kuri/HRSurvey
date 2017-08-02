/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service.impl;

import com.honeywell.hr.model.Employee;
import com.honeywell.hr.service.IMailService;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 *
 * @author H255735
 */
@Service
public class MailServiceImpl implements IMailService{

    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private VelocityEngine velocityEngine;
    
    @Override
    public void createAndSendEmail(Employee receiver, int surveyId) {
        
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
               message.setTo(receiver.getEmail());
               message.setFrom("honeywell.tester69@gmail.com"); // could be parameterized...
                Map model = new HashMap();
               model.put("employee", receiver);
               String text = VelocityEngineUtils.mergeTemplateIntoString(
                  velocityEngine, "com/dns/registration-confirmation.vm", model);
               message.setText(text, true);
            }
        };
        this.mailSender.send(preparator);

    }
    
    private String getDefaultMailBody(){
        return "body";
    }
    
}
