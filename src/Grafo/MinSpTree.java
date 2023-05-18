/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public class MinSpTree {
    
    Map<Integer, Integer> mapa = new HashMap<>();

    public void makeSet(int n) {
        for (int i = 0; i < n; i++) {
            mapa.put(i, i);
        }
    }

    private int encontrar(int k) {
        if (mapa.get(k) == k) {
            return k;
        }

        return encontrar(mapa.get(k));
    }

    private void union(int a, int b) {
        int x = encontrar(a);
        int y = encontrar(b);

        mapa.put(x, y);
    }

    public static List<Arista> algortimoKruskal(List<Arista> aristas, int n) {
        List<Arista> MinSpTree = new ArrayList<>();

        MinSpTree mst = new MinSpTree();
        mst.makeSet(n);

        int index = 0;

        Collections.sort(aristas, Comparator.comparingDouble(e -> e.distancia));

        while (MinSpTree.size() != n - 1) {
            Arista sig_arista = aristas.get(index++);

            int x = mst.encontrar(sig_arista.origen);
            int y = mst.encontrar(sig_arista.destino);

            if (x != y) {
                MinSpTree.add(sig_arista);
                mst.union(x, y);
            }
        }

        return MinSpTree;
    }

    public static void imprimir(List<Arista> e) {
        String ciudades[] = Grafo.getCiudades();
        
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("| Localidad 1                    | Localidad 2                    | Peso(km) |\n");
        System.out.println("------------------------------------------------------------------------------");
        
        for (int i = 0; i < e.size(); i++) {
            System.out.printf("| %-30s | %-30s | %-9s|\n", ciudades[e.get(i).origen], ciudades[e.get(i).destino], e.get(i).distancia);
        }

        System.out.println("------------------------------------------------------------------------------");
    }
}
