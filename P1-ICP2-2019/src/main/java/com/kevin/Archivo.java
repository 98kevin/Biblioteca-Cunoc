/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 * 
 */
public  class Archivo implements Serializable{
    
    /**
     * Escribe objetos en archivos binarios 
     * @param path Direcion donde se escribira el objeto
     * @param objeto objeto que se escribira en el archivo binario
     */
    public static void escribirArchivoBinario(String path, Object objeto){
        try {
          FileOutputStream  fos = new FileOutputStream(path);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objeto);
             oos.close();
             fos.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "El archivo en la direccion " + path+ " no se pudo escribir", "IOException", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    /**
     * Lee objetos desde archivos binario
     * @param path Direccion del archivo que contiene el objeto. 
     * @return  Un objeto contenido en el archivo leido
     */
    public static Object leerArchivo(String path){
        Object ob =null;
        try {
           FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ob = ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException e) {
              JOptionPane.showMessageDialog(null, "El archivo en la direccion " + path+ " no se pudo leer", "IOException", JOptionPane.ERROR_MESSAGE);
        } catch(ClassNotFoundException f){
            JOptionPane.showMessageDialog(null, "No existe la clase a la que se intenta acceder", "ClassNotFoundException", JOptionPane.ERROR_MESSAGE);
        }
        return ob;
    }
    /**
     * Crea directorios, si ya existen no los crea. 
     * @param name  El nombre del nuevo directorio
     */
    public static void createDirectory(String name ){
        File file = new File(name);
        file.mkdir();
    }
    
  /**
   * Actualiza los valores de las cantidades de archivos (Libros, estudiantes, prestamos)
   * @param pathOfFile Direccion del archivo que se va a actualizar
   */
    public static void actualizarContador(String pathOfFile){
                Integer count = (Integer)Archivo.leerArchivo(pathOfFile);
                int contador;
                if(count == null){
                    contador=0;
                }else{
                    contador = count ++;
                }
              Archivo.escribirArchivoBinario(pathOfFile, contador);
    }
    
    public static File readFile(String path){
        File archivo = new File(path);
        return (archivo.exists())?archivo:null;
    }
}
