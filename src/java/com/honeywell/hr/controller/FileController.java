/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author H255735
 */
@Controller
@RequestMapping("/file")
public class FileController {
    
    @RequestMapping("/htmlSignature")
    public void getHtmlSignature( 
           HttpServletResponse response){
        
        File file = new File("C:\\Users\\H255735\\Documents\\Projects\\Twain\\twain-samples\\TWAIN-Samples\\Twain_DS_sample01\\README.txt");
        response.setContentType("text/html");
        response.setHeader("Content-Disposition", "attachment; filename=\"somefile.txt\"");
        try(FileInputStream fis = new FileInputStream(file)){
            FileCopyUtils.copy(fis, response.getOutputStream());
            response.flushBuffer();
        }catch(IOException e){
            
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "output.pdf";
        
    }
    
}
