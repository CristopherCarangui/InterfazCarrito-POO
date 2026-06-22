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
import ec.edu.ups.ejemplocarrito.views.ListarProductosView;
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
    private ListarProductosView listarProductosView;

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
        Producto producto = new Producto(codigo,nombre,precio);
        productoDao.actualizar(producto);
        actualizarProductoView.getTxtNombre().setText(producto.getNombre());
        actualizarProductoView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
        actualizarProductoView.mostrarInformacion("Producto actualizado exitosamente");
        
            
        
        
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
        if(productoDao.buscar(codigo) != null){
            int opcion = JOptionPane.showConfirmDialog(eliminarProductoView,"Estas seguro que lo quieres eliminar");
            if(opcion == JOptionPane.YES_OPTION){
                productoDao.eliminar(codigo);
                eliminarProductoView.mostrarInformacion("El producto fue eliminado existosamente");
                
            }
        }else{
            eliminarProductoView.mostrarInformacion("El producto no existe");
        }
        
    }

    public void configurarEventosEliminarProducto() {
        eliminarProductoView.getBttBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
    }

    public ProductoController(ListarProductosView listarProductosView) {
        this.listarProductosView = listarProductosView;
        configurarEventosListarProducto();
    }
    
    public void listarProducto(){
        listarProductosView.cargarDatos(productoDao.listar());
    }
    public void configurarEventosListarProducto(){
        listarProductosView.getBttAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                listarProductosView.getBttAgregar().setEnabled(false);
                listarProducto();
                listarProductosView.getBttAgregar().setEnabled(true);
            }
        });
    }
}
