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
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
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
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author H255735
 */
@Service
public class MailServiceImpl implements IMailService{

    private static Logger logger = Logger.getLogger(MailServiceImpl.class);
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private VelocityEngine velocityEngine;
    
    private String url = "http://localhost:8080/HREvaluationSystem/survey/answer.do";
    
    @Override
    public void createAndSendEmail(Employee receiver, int surveyId) {
        
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
               message.setTo(receiver.getEmail());
               message.setFrom("honeywell.tester69@gmail.com");
               message.setSubject("HRG evaluation");
               Map<String,Object> model = new HashMap<>();
               model.put("employee", receiver);
               model.put("idSurvey", surveyId);
               model.put("surveyUrl", url);
               String text = VelocityEngineUtils.mergeTemplateIntoString(
                  velocityEngine, "templates/surveyMailTemplate.vm", "UTF-8", model);
               message.setText(text, true);
               logger.debug("mail sent: " + text);
            }
        };
        this.mailSender.send(preparator);

    }
    
    private String getDefaultMailBody(){
        return "body";
    }
    
}
