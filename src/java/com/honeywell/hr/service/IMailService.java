/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service;

import com.honeywell.hr.model.Employee;

/**
 *
 * @author H255735
 */
public interface IMailService {
    void createAndSendEmail(Employee receiver, String mailBody, int surveyId);
}
