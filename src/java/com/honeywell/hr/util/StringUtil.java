/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.util;

/**
 *
 * @author H255735
 */
public class StringUtil {
    
    public static boolean isEmpty(String string){
        return !(string != null && string.trim().length() > 0);
    }
    
}
