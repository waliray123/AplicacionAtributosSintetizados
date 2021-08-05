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
    private List<String> valores;
    private List<Integer> enteros;

    public Operacion(Nodo nodoP) {
        resultado = 0;
        valores = new ArrayList<>();
        enteros = new ArrayList<>();
        this.nodoPadre = nodoP;
        Operar();
    }
    
    private void Operar(){
        insertarValores();
        for (String valor : valores) {
            if (isNumeric(valor)) {
                enteros.add(Integer.parseInt(valor));
            }else{                
                int val1 = enteros.get(enteros.size()-1);
                int val2 = enteros.get(enteros.size()-2);
                if (valor.contains("*")) {
                    int res = (val1*val2);
                    enteros.remove(enteros.size()-1);
                    enteros.remove(enteros.size()-1);
                    enteros.add(0, res);
                }else if(valor.contains("+")){
                    int res = (val1+val2);
                    enteros.remove(enteros.size()-1);
                    enteros.remove(enteros.size()-1);
                    enteros.add(0, res);
                }else{
                    enteros.add(0);
                }
            }
        }
        this.resultado = enteros.get(0);
    }
    
    private boolean isNumeric(String cadena){
        try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    private void insertarValores(){
        List<Nodo> nodosHijo = this.nodoPadre.getNodosHijo();
        for (Nodo nodo : nodosHijo) {
           revisarHijos(nodo); 
        }
        valores.add(nodoPadre.getValor());
    }
    
    private void revisarHijos(Nodo nodo){
        List<Nodo> nodosHijo = nodo.getNodosHijo();
        for (Nodo nodoh : nodosHijo) {
           revisarHijos(nodoh); 
        }
        valores.add(nodo.getValor());
    }

    public int getResultado() {
        return resultado;
    }
    
    
}
