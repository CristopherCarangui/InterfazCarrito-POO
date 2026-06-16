/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejemplocarrito.models;
import ec.edu.ups.ejemplocarrito.models.ItemCarrito;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author USER
 */
public class Carrito {
    private List<ItemCarrito> items; 
    public Carrito(){
        items = new ArrayList<>();
    }
    public void agregarProducto(Producto producto, int cantidad ){
        ItemCarrito item = new ItemCarrito(producto,cantidad);
        items.add(item);
        
    }
    public ItemCarrito buscarItemCarritoPorCodigoDePorducto(int codigo){
        for(ItemCarrito item: items){
            if(item.getProsucto().getCodigo() == codigo){
                return item;
            }
        }
        return null;
    }
    public void eliminarPorducto(int codigoProducto){
        ItemCarrito item = buscarItemCarritoPorCodigoDePorducto(codigoProducto); 
        
        if(item != null){
            items.remove(item);
        }
        
    }
    
    public double calcularTotal(){
        double total = 0.00;
        for(ItemCarrito item : items){
            total += item.calcularSubTotal();
        }
        return total;
    }
}
