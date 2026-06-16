/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejemplocarrito.controllers;
import ec.edu.ups.ejemplocarrito.views.CrearProductoView;
import ec.edu.ups.ejemplocarrito.views.BuscarProductoView;
import ec.edu.ups.ejemplocarrito.views.ActualizarProductoView;
import ec.edu.ups.ejemplocarrito.models.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Usuario
 */
public class ProductoController {
     private CrearProductoView crearProductoView;
     private BuscarProductoView buscarProductoView;
     private ActualizarProductoView actualizarProductoView;

    public ProductoController(CrearProductoView crearProductoView) {
        this.crearProductoView = crearProductoView;
        configurarEventosCrearProducto();
    }
    
     public void crearProducto(){
        int codigo = Integer.parseInt(crearProductoView.getTxtCodigo().getText());
        String nombre = crearProductoView.getTxtNombre().getText();
        double precio = Double.parseDouble(crearProductoView.getTxtPrecio().getText());
        
        Producto producto = new Producto(codigo, nombre, precio);
        System.out.println("Producto creado exitosamente");
    }
     public void configurarEventosCrearProducto(){
        crearProductoView.getBttAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearProducto();
            }
        });
    }

    public ProductoController(BuscarProductoView buscarProductoView) {
        this.buscarProductoView = buscarProductoView;
        configurarEventosBuscarProducto();
    }
    
    public void buscarProducto(){
        String nombre = buscarProductoView.getTxtBuscarProducto().getText();
        if(buscarProductoView.getTxtBuscarProducto().getText() == nombre){
            System.out.println("Producto eliminado exitosamnete");
        }else{
            System.out.println("Producto no existe");
        }
    }
    public void configurarEventosBuscarProducto(){
        buscarProductoView.getBttBuscar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                buscarProducto();
            }
        });
    }

    public ProductoController(ActualizarProductoView actualizarProductoView) {
        this.actualizarProductoView = actualizarProductoView;
        configurarEventosActualizarProducto();
    }
    public void actualizarProducto(){
        int codigo = Integer.parseInt(crearProductoView.getTxtCodigo().getText());
        String nombre = crearProductoView.getTxtNombre().getText();
        double precio = Double.parseDouble(crearProductoView.getTxtPrecio().getText());
        int busqueda = Integer.parseInt(actualizarProductoView.getTxtCodigo().getText());
        if(busqueda == codigo){
            System.out.println("Producto actualizado exitosamente");
        }else{
            System.out.println("El producto no existe");
        }
    }
    public void configurarEventosActualizarProducto(){
        actualizarProductoView.getBttAct().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                actualizarProducto();
            }
        });
    }
    
    
}
