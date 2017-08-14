/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.service;

import com.honeywell.hr.model.Employee;
import com.honeywell.hr.service.IMailService;
import com.honeywell.hr.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 *
 * @author H255735
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "web/WEB-INF/dispatcher-servlet.xml" })
public class TestMailService {
    
    @Configuration
    static class TestMailServiceContextConfiguration{
        @Bean
        public IMailService mailService(){
            return new MailServiceImpl();
        }
        
    }
    
    @Autowired
    private IMailService mailService;
    
    @Test
    public void testSendMail(){
        Employee receiver = new Employee();
        receiver.setEmail("e-kuri@hotmail.com");
        
        //mailService.createAndSendEmail(receiver, 1);
    }
    
}
