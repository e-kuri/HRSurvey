/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service.impl;

import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Survey;
import com.honeywell.hr.service.IMailService;
import com.honeywell.hr.util.StringUtil;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author H255735
 */
@Service
@Transactional
public class MailServiceImpl implements IMailService{

    private static Logger logger = Logger.getLogger(MailServiceImpl.class);
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private VelocityEngine velocityEngine;
    
    private String url = "http://localhost:8080/HREvaluationSystem/survey/answer.do";
    private static final String defaultBody = "<h3>Dear ${employee.firstName}, thank you for getting in touch with the HR department.<br/>Please help us answering the following survey so we can improve.</h3>";
    
    @Override
    public void createAndSendEmail(Survey survey, String subject, String body) {
        
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
               message.setTo(survey.getEvaluator().getEmail());
               message.setFrom("honeywell.tester69@gmail.com");
               message.setSubject(StringUtil.isEmpty(subject) ? "HRG evaluation" : subject );
               Map<String,Object> model = new HashMap<>();
               model.put("gradeId", survey.getGrades().get(0).getId());
               model.put("employee", survey.getEvaluator());
               model.put("surveyUrl", url);
               model.put("body", StringUtil.isEmpty(body) ? defaultBody : body );
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
