/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.carrito.dao;

import ec.edu.ups.ejemplocarrito.models.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAB_04
 */
public class ProductoDAOMemoria implements ProductoDAO {
    private List<Producto> listaProducto;
    
    public  ProductoDAOMemoria(){
        listaProducto = new ArrayList<>();
    }
    
    
    @Override
    public void crear(Producto producto) {
       listaProducto.add(producto);
    }

    @Override
    public Producto buscar(int codigo) {
        for(Producto producto:listaProducto){
            if(producto.getCodigo()== codigo){
                return producto;
            }
        }
        return null;
    }

    @Override
    public boolean actualizar( Producto producto) {
        for(int i = 0; i< listaProducto.size();i++){
            Producto productoEncontrado = listaProducto.get(i);
            if(productoEncontrado.getCodigo() == producto.getCodigo()){
                listaProducto.set(i, producto);
                return true;
            }
        }
        return false;
    }
    public boolean buscaractualizar( Producto producto) {
        for(int i = 0; i< listaProducto.size();i++){
            Producto productoEncontrado = listaProducto.get(i);
            if(productoEncontrado.getCodigo() == producto.getCodigo()){
                listaProducto.set(i, producto);
                return true;
            }
        }
        return false;
    }
   

    @Override
    public void eliminar(int codigo) {
         Producto productoEncontrado = buscar(codigo);
         if(productoEncontrado != null){
             listaProducto.remove(productoEncontrado);
         }   
    }

    @Override
    public List<Producto> listar() {
        return listaProducto;
    }
    
}
