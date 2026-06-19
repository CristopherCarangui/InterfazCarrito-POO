/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.carrito.dao;

import ec.edu.ups.ejemplocarrito.models.Producto;
import java.util.List;

/**
 *
 * @author LAB_04
 */
public interface ProductoDAO {
    void crear(Producto producto);
    Producto buscar(int codigo);
    boolean actualizar( Producto producto);
    void eliminar(int codigo);
    List<Producto> listar();
}
