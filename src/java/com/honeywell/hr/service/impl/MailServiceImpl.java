/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service.impl;

import com.honeywell.hr.model.Employee;
import com.honeywell.hr.service.IMailService;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author H255735
 */
public class MailServiceImpl implements IMailService{

    @Override
    public void sendMail(Employee sender, Employee receiver, String mailBody) {
        
        /*
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
*/
    }
    
}
