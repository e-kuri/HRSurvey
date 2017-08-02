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
public class InvalidValueException extends Exception {

    public InvalidValueException(String string) {
        super(string);
    }

    public InvalidValueException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public InvalidValueException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
