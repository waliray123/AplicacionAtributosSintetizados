package objetos;
import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private int numNodo;
    private Nodo nodoPadre;
    private List<Nodo> nodosHijo;
    private String valor;

    public Nodo(){
        this.numNodo = -1;
        inicializarNodo();
    }

    public Nodo(String valor,int numNodo){        
        this.valor = valor;
        this.numNodo = numNodo;
        inicializarNodo();
    }

    private void inicializarNodo(){
        this.nodoPadre = null;
        this.nodosHijo = new ArrayList<>();
    }
    
    public void insertarValor(String val){
        this.valor = val;
    }

    public void insertarNodoPadre(Nodo nodop){
        this.nodoPadre = nodop;
    }

    public void insertarNodoHijo(Nodo nodo){
        this.nodosHijo.add(nodo);
    }    

    public Nodo getNodoPadre(){
        return this.nodoPadre;
    }

    public List<Nodo> getNodosHijo(){
        return this.nodosHijo;
    }

    public String getValor(){
        return this.valor;
    }

    public int getNumNodo(){
        return this.numNodo;
    }

    public void setNumNodo(int num){
        this.numNodo = num;
    }
}
