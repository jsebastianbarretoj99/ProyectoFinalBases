/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidades.Carro;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juansebastianbarretojimenez
 */
public class mian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CarroController carro = new CarroController();
        List<Carro> listaCarros = new ArrayList<>();
        
        listaCarros = carro.consultarCarrosBD();
        for(Carro car: listaCarros){
            System.out.println("Carro  Database: "+ car.getId());
        }
    }
    
}
