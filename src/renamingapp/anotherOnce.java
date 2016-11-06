/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renamingapp;

import java.io.File;

/**
 *
 * @author p_unit
 */
public class anotherOnce {

    public static void main(String[] ar) {

        File resultt = new File("result");
        File fold = new File("punit.html");
        resultt.mkdir();
        System.out.println(resultt.getAbsolutePath());
        fold.renameTo(new File(resultt.getAbsoluteFile() + "\\punit.h"));

    }
}
