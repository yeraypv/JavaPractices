/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrepolistener;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author yeray
 */
public class JRepoListener {

    public static void main(String[] args) throws IOException, Exception {
        Path dir = Paths.get("C://repositorio");
        boolean recursive = false;
        new WatchDir(dir, recursive).processEvents();
        
    }
    
}
