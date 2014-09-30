/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yeray
 */
public class JavaApplication16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<TSiteNode> listaNodos = new ArrayList<>();
        
        TSiteNode node = new TSiteNode();
        node.setId("Uno");
        node.setUrl("www.uno.com");
        node.setParent("Inicio");
        listaNodos.add(node);
        TSiteNode node2 = new TSiteNode();
        node2.setId("Dos");
        node2.setUrl("www.uno.com");
        node2.setParent("Inicio");
        listaNodos.add(node2);
        TSiteNode node3 = new TSiteNode();
        node3.setId("Tres");
        node3.setUrl("www.uno.com");
        node3.setParent("Dos");
        listaNodos.add(node3);
        TSiteNode node4 = new TSiteNode();
        node4.setId("Cuatro");
        node4.setUrl("www.uno.com");
        node4.setParent("Uno");
        listaNodos.add(node4);
        TSiteNode node5 = new TSiteNode();
        node5.setId("Cinco");
        node5.setUrl("www.uno.com");
        node5.setParent("Uno");
        listaNodos.add(node5);
        TreeNode tree = new TreeNode();
        TreeNode resultado = tree.getTreeNode((ArrayList<TSiteNode>) listaNodos);
        
    }

}
