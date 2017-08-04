/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.controller;

import com.honeywell.hr.controller.EmployeeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author H255735
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmployeeController.class})
@WebAppConfiguration
public class TestEmplloyeeController {
    
    @Test
    public void testEmployeeByNum(){
        EmployeeController cont = new EmployeeController();
        //Object o = cont.getIdsLike("H25");
        System.out.println("");
    }
    
}
