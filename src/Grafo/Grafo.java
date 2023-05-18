/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Grafo {
    List<List<Vertice>> lista = new ArrayList<>();
    static String[] ciudades = new String[32];
    static List<Arista> aristasTotales = new ArrayList<>();
    
    public Grafo(List<Arista> aristas){
        int n = 0;
        ciudades[0] = "Alamos";
        ciudades[1] = "Navojoa";
        ciudades[2] = "Fundicion";
        ciudades[3] = "Cd. Obregon";
        ciudades[4] = "Rosario";
        ciudades[5] = "Esperanza";
        ciudades[6] = "Vicam";
        ciudades[7] = "Empalme";
        ciudades[8] = "Ortiz";
        ciudades[9] = "Guaymas";
        ciudades[10] = "San Carlos";
        ciudades[11] = "Hermosillo";
        ciudades[12] = "La Colorada";
        ciudades[13] = "Tecoripa";
        ciudades[14] = "San Nicolas";
        ciudades[15] = "Carbó";
        ciudades[16] = "Santa Ana";
        ciudades[17] = "Caborca";
        ciudades[18] = "Puerto Peñasco";
        ciudades[19] = "Sonoyta";
        ciudades[20] = "Magdalena";
        ciudades[21] = "Cucurpe";
        ciudades[22] = "Imuris";
        ciudades[23] = "Nogales";
        ciudades[24] = "Cananea";
        ciudades[25] = "Bacoachi";
        ciudades[26] = "Agua Prieta";
        ciudades[27] = "Fronteras";
        ciudades[28] = "Cumpas";
        ciudades[29] = "Moctezuma";
        ciudades[30] = "Tepache";
        ciudades[31] = "Esqueda";
        
        for(Arista ar : aristas){
            n = Integer.max(n, Integer.max(ar.origen, ar.destino));
        }
        
        for(int i = 0; i <=n; i++){
            lista.add(i, new ArrayList<>());
        }
        
        for(Arista ar: aristas){
            lista.get(ar.origen).add(new Vertice(ar.destino, ar.distancia));
            lista.get(ar.destino).add(new Vertice(ar.origen, ar.distancia));
        }
    }
    
    public static void ciudades(Grafo grafo){
        int origen = 0;
        int n = grafo.lista.size();
        
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("| Ciudad 1                    | Ciudad 2                    | Distancia(km) |\n");
        System.out.println("------------------------------------------------------------------------------");
        
        while(origen < n){
            for (Vertice arista : grafo.lista.get(origen)){
                System.out.printf("| %-30s | %-30s | %-9s|\n", ciudades[origen], ciudades[arista.valor], arista.precio);
            }
            origen++;
        }
        System.out.println("------------------------------------------------------------------------------"); 
    }
    
    public void aristas(){
        int origen = 0;
        int n = this.lista.size();
        
        while (origen < n){
            for(Vertice arista : this.lista.get(origen)){
                aristasTotales.add(new Arista(origen, arista.valor, arista.precio));
            }
            origen++;
        }
    }
    
    public static String[] getCiudades(){
        return ciudades;
    }
    
    public static List<Arista> getAristasTotales(){
        return aristasTotales;
    }
    
    public int ubicarCiudad(String ciudad){
        for(int i = 0; i < ciudades.length; i++){
            if(ciudades[i].equalsIgnoreCase(ciudad)){
                return i;
            }
        }
        return -1;
    }
}
