/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Grafo.Arista;
import Grafo.Grafo;
import Grafo.MinSpTree;
import Grafo.Rutas;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author xfs85
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Arista> aristas = Arrays.asList(
            new Arista(11, 12, 50.0), new Arista(11, 15, 82.0), new Arista(11, 7, 139.0), 
            new Arista(11, 9, 135.0), new Arista(3, 5, 9.0), new Arista(3, 1, 70.0),
            new Arista(3, 4, 84.0),new Arista(3, 2, 27.0) ,new Arista(10, 9, 20.0), 
            new Arista(9, 7, 13.0), new Arista(9, 10, 20.0), new Arista(9, 11, 135.0), 
            new Arista(1, 3, 70.0), new Arista(1, 0, 40.0), new Arista(1, 2, 40.0), 
            new Arista(7, 6, 67.0), new Arista(7, 8, 47.0), new Arista(7, 9, 13.0), 
            new Arista(18, 19, 98.0), new Arista(18, 17, 177.0), new Arista(19, 17, 150.0), 
            new Arista(19, 18, 98.0), new Arista(23, 22, 81.0), new Arista(23, 24, 146.0),
            new Arista(23, 26, 79.0), new Arista(26, 24, 79.0), new Arista(26, 31, 74.0),
            new Arista(26, 27, 54.0), new Arista(29, 28, 27.0), new Arista(29, 30, 41.0),
            new Arista(20, 22, 22.0), new Arista(20, 16, 17.0), new Arista(20, 21, 46.0),
            new Arista(22, 24, 81.0), new Arista(22, 23, 65.0), new Arista(22, 20, 22.0),
            new Arista(14, 13, 74.0), new Arista(14, 4, 68.0), new Arista(14, 12, 87.0),
            new Arista(16, 15, 102.0), new Arista(16, 20, 17.0), new Arista(16, 17, 104.0),
            new Arista(5, 6, 39.0), new Arista(5, 3, 9.0), new Arista(12, 13, 74.0), new Arista(27, 28, 116));
        
        Grafo graph = new Grafo(aristas);
        graph.aristas();
        Mapa mapa = new Mapa();
        Scanner tec = new Scanner(System.in, "ISO-8859-1");
        int op = -1;
        boolean ciclo = true;
        String ciudad1 ="" , ciudad2 ="";
        
        while (op != 0) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar grafo");
            System.out.println("2. Mostrar árbol de esparcimiento mínimo");
            System.out.println("3. Mostrar la ruta mas corta entre dos ciudades dadas");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = tec.nextInt();
            switch (op) {
                case 1:
                    System.out.println("");
                    Grafo.ciudades(graph);
                    mapa.setVisible(true);
                    break;
                case 2:
                    System.out.println("");
                    List<Arista> e = MinSpTree.algortimoKruskal(aristas, 32);
                    MinSpTree.imprimir(e);
                    break;
                case 3:
                    tec.nextLine();
                    while (ciclo) {
                        System.out.print("Ingrese la localidad origen: ");
                        ciudad1 = tec.nextLine();
                        System.out.print("Ingrese la localidad destino: ");
                        ciudad2 = tec.nextLine();
                        if (graph.ubicarCiudad(ciudad2) < 0 || graph.ubicarCiudad(ciudad2) < 0) {
                            System.out.println("Error: Localidad no encontrada, revise los nombres en el grafo");
                        } else {
                            ciclo = false;
                        }
                    }
                    ciclo = true;
                    Rutas.caminoCorto(Grafo.getAristasTotales(), Grafo.getCiudades().length, graph.ubicarCiudad(ciudad1), graph.ubicarCiudad(ciudad2));
                    break;
                case 0:
                    System.out.println("Adiós...");
                    mapa.dispose();
                    break;
            }
            System.out.println("");
        }
    }
    
}
