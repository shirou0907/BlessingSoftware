/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.model;

/**
 *
 * @author MY PC
 */
public class GlobalData {
    static String id;

    public GlobalData(String id) {
        this.id = id;
    }
    
    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        GlobalData.id = id;
    }  
}

