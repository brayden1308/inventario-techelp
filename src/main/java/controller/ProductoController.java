package controller;

import com.teechhelp.inventario.model.Producto;
import com.teechhelp.inventario.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        return productoRepository.findById(id).map(p -> {
            p.setNombre(productoActualizado.getNombre());
            p.setDescripcion(productoActualizado.getDescripcion());
            p.setPrecio(productoActualizado.getPrecio());
            p.setCategoria(productoActualizado.getCategoria());
            p.setStock(productoActualizado.getStock());
            return productoRepository.save(p);
        }).orElseGet(() -> {
            productoActualizado.setId(id);
            return productoRepository.save(productoActualizado);
        });
    }
}
