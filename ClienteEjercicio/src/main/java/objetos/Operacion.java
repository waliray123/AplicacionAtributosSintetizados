/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user-ubunto
 */
public class Operacion {
    
    private Nodo nodoPadre;
    private int resultado;
    private List<Integer> valores;

    public Operacion(Nodo nodoP) {
        resultado = 0;
        valores = new ArrayList<>();
        this.nodoPadre = nodoP;
    }
    
    private void Operar(){
        
    }
    
}
