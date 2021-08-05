package objetos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Arbol {

    private String strG;
    private Nodo nodoPadre;

    public void generarArbol(Nodo nodoPadre) {
        this.nodoPadre = nodoPadre;
        generarStr();
        escribirGraphviz();
    }

    private void generarStr() {
        strG = "digraph G { \n";

        strG += "node" + nodoPadre.getNumNodo() + "[label = \"" + nodoPadre.getValor() + "\"];\n";
        List<Nodo> nodosHijo = nodoPadre.getNodosHijo();
        for (Nodo nodo : nodosHijo) {
            insertarNodo(nodo, nodoPadre);
        }

        strG += "}";
    }

    private void insertarNodo(Nodo nodo, Nodo nodoP) {
        strG += "node" + nodo.getNumNodo() + "[label = \"" + nodo.getValor() + "\"];\n";
        strG += "node" + nodoP.getNumNodo() + " -> " + "node" + nodo.getNumNodo() + ";\n";
        List<Nodo> nodosHijo = nodo.getNodosHijo();
        for (Nodo nodoI : nodosHijo) {
            insertarNodo(nodoI, nodo);
        }
    }

    private void escribirGraphviz() {
        try {
            File file = new File("arbol.dot");
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.strG);
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

    public void crearPngArbol() {
        try {
            String cmd = "dot -Tpng arbol.dot -o arbol.png"; 
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
