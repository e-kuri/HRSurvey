/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.exception;

/**
 *
 * @author H255735
 */
public class ClosedSurveyException extends Exception{

    public ClosedSurveyException() {
        super("This survey has already been answered.");
    }
    
}
