/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejemplocarrito.controllers;
import ec.edu.ups.ejemplocarrito.views.CrearProductoView;
import ec.edu.ups.ejemplocarrito.views.BuscarProductoView;
import ec.edu.ups.ejemplocarrito.views.ActualizarProductoView;
import ec.edu.ups.ejemplocarrito.views.EliminarProductoView;
import ec.edu.ups.ejemplocarrito.models.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ec.edu.ups.carrito.dao.ProductoDAO;
/**
 *
 * @author Usuario
 */
public class ProductoController {

    private ProductoDAO productoDao;
    private CrearProductoView crearProductoView;
    private BuscarProductoView buscarProductoView;
    private ActualizarProductoView actualizarProductoView;
    private EliminarProductoView eliminarProductoView;

    public ProductoController(CrearProductoView crearProductoView, ProductoDAO productoDao) {
        this.crearProductoView = crearProductoView;
        this.productoDao = productoDao;
        configurarEventosCrearProducto();
    }

    public void crearProducto() {
        int codigo = Integer.parseInt(crearProductoView.getTxtCodigo().getText());
        String nombre = crearProductoView.getTxtNombre().getText();
        double precio = Double.parseDouble(crearProductoView.getTxtPrecio().getText());

        Producto producto = new Producto(codigo, nombre, precio);
        productoDao.crear(producto);
        String nombre1 = "Producto creado exitosamente";
        crearProductoView.mostrarInformacion(nombre1);
    }

    public void configurarEventosCrearProducto() {
        crearProductoView.getBttAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearProducto();
            }
        });
    }

    public ProductoController(BuscarProductoView buscarProductoView, ProductoDAO productoDao) {
        this.buscarProductoView = buscarProductoView;
        this.productoDao = productoDao;
        configurarEventosBuscarProducto();
    }

    public void buscarProducto() {
        int codigo = Integer.parseInt(buscarProductoView.getTxtBuscarProducto().getText());
        Producto producto = productoDao.buscar(codigo);
        if(producto != null){
            buscarProductoView.getTxtNombre().setText(producto.getNombre());
            buscarProductoView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
            buscarProductoView.mostrarInformacion("Producto encontrado exitosamente");
        }else{
            buscarProductoView.mostrarInformacion("No se encontro el producto");
        }
        
        
    }

    public void configurarEventosBuscarProducto() {
        buscarProductoView.getBttBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });
    }

    public ProductoController(ActualizarProductoView actualizarProductoView, ProductoDAO productoDao) {
        this.actualizarProductoView = actualizarProductoView;
        this.productoDao = productoDao;
        configurarEventosActualizarProducto();
    }

    public void actualizarProducto() {
        int codigo = Integer.parseInt(actualizarProductoView.getTxtCodigo().getText());
        String nombre = actualizarProductoView.getTxtNombre().getText();
        double precio = Double.parseDouble(actualizarProductoView.getTxtPrecio().getText());
        Producto producto = new Producto(codigo, nombre, precio);
        productoDao.actualizar(codigo, producto);
        if(actualizarProductoView.getBttBuscar()!= null){
            actualizarProductoView.getTxtCodigo().setText(String.valueOf(producto.getCodigo()));
            actualizarProductoView.getTxtNombre().setText(producto.getNombre());
            actualizarProductoView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
            actualizarProductoView.mostrarInformacion("Producto actualizado exitosamente");
        }else{
            actualizarProductoView.mostrarInformacion("Producto no encontrado");
        }
        
            
        
        
    }

    public void configurarEventosActualizarProducto() {
        actualizarProductoView.getBttAct().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });
    }

    public ProductoController(EliminarProductoView eliminarProductoView, ProductoDAO productoDao) {
        this.eliminarProductoView = eliminarProductoView;
        this.productoDao = productoDao;
        configurarEventosEliminarProducto();
    }

    public void eliminarProducto() {
        int codigo = Integer.parseInt(eliminarProductoView.getTxtCodigo().getText());
        productoDao.eliminar(codigo);
        String nombre1 = "Producto eliminado exitosamente";
        eliminarProductoView.mostrarInformacion(nombre1);
    }

    public void configurarEventosEliminarProducto() {
        eliminarProductoView.getBttEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
    }

}
