/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author PC
 */
public class Rutas {
    private static DecimalFormat dec = new DecimalFormat("0.00");
    static String ciudades[] = Grafo.getCiudades();
    
    static void camino(int ruta[], int valor, List<String> camino){
        if (valor < 0) {
            return;
        }
        camino(ruta, ruta[valor], camino);
        camino.add(ciudades[valor]);
    }
    
    public static void caminoCorto(List<Arista> aristas, int n, int origen, int destino){
        double distancia[] = new double[n];
        int ruta[] = new int[n];
        
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origen] = 0;
        Arrays.fill(ruta, -1);
        
        for (int i = 0; i < n - 1; i++) {
            for (Arista arista : aristas) {
                int u = arista.origen;
                int v = arista.destino;
                double w = arista.distancia;

                if (distancia[u] != Integer.MAX_VALUE && distancia[u] + w < distancia[v]) {
                    distancia[v] = distancia[u] + w;
                    ruta[v] = u;
                }
            }
        }
        
        for (Arista edge : aristas) {
            int u = edge.origen;
            int v = edge.destino;
            double w = edge.distancia;

            if (distancia[u] != Integer.MAX_VALUE && distancia[u] + w < distancia[v]) {
                System.out.println("Hay un ciclo de peso negativo");
                return;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i != origen && distancia[i] < Integer.MAX_VALUE) {
                if (i == destino) {
                    List<String> camino = new ArrayList<>();
                    camino(ruta, i, camino);
                    System.out.println("La distancia de la localidad " + ciudades[origen] + " a la localidad " + ciudades[i] + " es de " + dec.format(distancia[i]) + ". Su camino es " + camino);
                }
            }
        }
    }
}
