package objetos;
import java.util.List;
import objetos.Nodo;

public class NotPostFija {

    private String strNot;
    private Nodo nodoPadre;
    
    public NotPostFija(Nodo nodoPadre){
        this.strNot = "";
        this.nodoPadre = nodoPadre;        
    }    

    public void generarNotacion(){
        List<Nodo> nodosHijo = this.nodoPadre.getNodosHijo();
        for (Nodo nodo : nodosHijo) {
           revisarHijos(nodo); 
        }
        strNot += nodoPadre.getValor();
    }

    private void revisarHijos(Nodo nodo){
        List<Nodo> nodosHijo = nodo.getNodosHijo();
        for (Nodo nodoh : nodosHijo) {
           revisarHijos(nodoh); 
        }
        strNot += nodo.getValor() + " ";
    }

    public String getNotacion(){
        return strNot;
    }
    
}
