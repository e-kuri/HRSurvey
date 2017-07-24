/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service.impl;

import com.honeywell.hr.model.Employee;
import com.honeywell.hr.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author H255735
 */
@Service
public class MailServiceImpl implements IMailService{

    @Autowired
    private MailSender mailSender;
    
    @Override
    public void sendMail() {
        
        
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("eugenio.kuri@gmail.com");
        msg.setFrom("honeywell.tester69@gmail.com");
        msg.setSubject("test");
        msg.setText("my test");
        try{
            this.mailSender.send(msg);
        }catch(MailException e){
            System.out.println(e);
        }

    }
    
}
