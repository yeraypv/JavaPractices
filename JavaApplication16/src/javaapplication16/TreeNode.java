package javaapplication16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author yeray
 */
public class TreeNode {

    private TSiteNode infoNodo;
    private ArrayList<TSiteNode> listaNodos;

    public TreeNode() {

    }

    public TreeNode(TSiteNode infoNodo) {
        this.infoNodo = infoNodo;
        this.listaNodos = new ArrayList<>();
    }

    public TSiteNode getInfoNodo() {
        return infoNodo;
    }

    public ArrayList<TSiteNode> getListaNodos() {
        return listaNodos;
    }

    public void setInfoNodo(TSiteNode infoNodo) {
        this.infoNodo = infoNodo;
    }

    public void setListaNodos(ArrayList<TSiteNode> listaNodos) {
        this.listaNodos = listaNodos;
    }

    public void addNode(TSiteNode nodo) {
        this.listaNodos.add(nodo);
    }

    public int getTamaño() {
        return listaNodos.size();
    }

    public TSiteNode getNode(int posicion) {
        if (posicion >= 0 && posicion < listaNodos.size()) {
            return listaNodos.get(posicion);
        } else {
            return null;
        }
    }

    public ArrayList<TSiteNode> recorridoRecursivo(ArrayList<TSiteNode> treeNode, ArrayList<TSiteNode> lista, int indiceActual, String parentId) {
        if (indiceActual == lista.size() - 1) {
            if (lista.get(indiceActual).getParent().equals(parentId)) {
                treeNode.add(indiceActual, infoNodo);
                System.out.println("Elemento -->" + treeNode.get(indiceActual).getId());
            }
            //  System.out.println ("Ultimo elemento..."+lista.get(indiceActual).getId()); 
        } else {
            // System.out.println("Leyendo... " + lista.get(indiceActual).getId());
            if (lista.get(indiceActual).getParent().equals(parentId)) {
                treeNode.add(indiceActual, infoNodo);
                System.out.println("Elemento -->" + treeNode.get(indiceActual).getId());
            }
            recorridoRecursivo(treeNode, lista, indiceActual + 1, parentId);
        }
        return treeNode;
    }

    public TreeNode getTreeNode(ArrayList<TSiteNode> listaNodos) {

        TreeNode tree = new TreeNode();
        ArrayList<TSiteNode> listaNodosResultados = null;
        TreeNode resultado = null;
        resultado.listaNodos = tree.recorridoRecursivo(listaNodosResultados, (ArrayList<TSiteNode>) listaNodos, 0, "Inicio");
        TreeNode aux = null;
        listaNodosResultados = null;
        for (int i = 0; i < resultado.getTamaño(); i++) {
            aux.listaNodos = tree.recorridoRecursivo(listaNodosResultados, (ArrayList<TSiteNode>) listaNodos, 0, resultado.infoNodo.getId());
        }
        return null;
    }
}
