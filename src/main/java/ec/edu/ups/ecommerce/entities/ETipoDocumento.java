/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ecommerce.entities;

/**
 *
 * @author GABO-PC
 */
public enum ETipoDocumento {
    
    Cédula, Pasaporte, RUC;
    
    public static  ETipoDocumento get(int index){
        return ETipoDocumento.values()[index];
    }
}

