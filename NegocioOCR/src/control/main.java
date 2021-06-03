/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidades.Carro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juansebastianbarretojimenez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FacadeOCR carro = new FacadeOCR();
        List<Carro> listaCarros = new ArrayList<>();
        System.out.println("Creacion renta: " + carro.crearRenta());
    }
    
}
