package com.prueba.root.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.root.models.Articulo;
import com.prueba.root.models.Cliente;
import com.prueba.root.models.OrdenesCabecera;
import com.prueba.root.models.OrdenesDetalle;
import com.prueba.root.repository.ClienteImplement;
import com.prueba.root.repository.OrdenDetalleImplement;
import com.prueba.root.repository.OrdenImplement;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/ordenes")
public class OrdenController {
	
	@Autowired
	private OrdenImplement ordenImplement;
	
	@Autowired
	private OrdenDetalleImplement ordenDetalleImplement;
	
	@Autowired
	private ClienteImplement clienteImplement;
	
	@GetMapping(value = "/index")
	public List<OrdenesCabecera> index(){
		System.out.println("listado");
		return ordenImplement.findAll();
	}
	
	@GetMapping(value = "/detalles/{id}")
	public List<OrdenesDetalle> ordenesDetalle(@PathVariable Long id){
		return ordenDetalleImplement.ordenesDetalleList(id);
	}
	
	@PostMapping(value = "/create")
	public void create(@RequestBody Map<String, Object> request) {
		String cliente_id 	= request.get("cliente_id").toString();
		if(cliente_id!=null && cliente_id.length()>0) {
			//CON EL ID DEL CLIENTE, OBTENEMOS TODOS LOS DATOS DEL CLIENTE
			Cliente cliente = clienteImplement.findById(Long.parseLong(cliente_id));
			//Se añade el cliente y los detalles a la orden
			OrdenesCabecera cabecera = new OrdenesCabecera();
			cabecera.setCliente(cliente);
			//SE CREA UNA NUEVA ORDEN
			OrdenesCabecera ordenesCabecera = ordenImplement.save(cabecera);
			//OBTENEMOS LOS DETALLES DE LA ORDEN
			List<OrdenesDetalle> detalles = new ArrayList<>();
			@SuppressWarnings("unchecked")
			List<Map<Object,Object>> productslist = (List<Map<Object, Object>>) request.get("detalles");
			for(Map<Object, Object> entry: productslist) {
				//Se obtiene los parametros a variables
				Long id = Long.parseLong(entry.get("id").toString());
				String codigo = entry.get("codigo").toString();
				String nombre = entry.get("codigo").toString();
				Double precio = Double.parseDouble(entry.get("precio_unitario").toString() );
				//Creamos una instancia del articulo con los datos recibidos
				Articulo articulo = new Articulo();
				articulo.setId(id);
				articulo.setCodigo(codigo);
				articulo.setNombre(nombre);
				articulo.setPrecio_unitario(precio);
				//Se añade el articulo a los detalles de la orden
				OrdenesDetalle detalle = new OrdenesDetalle();
				detalle.setArticulo(articulo);
				detalle.setOrdenesCabecera(ordenesCabecera);
				//AGREGAMOS UN DETALLE A LA ORDEN
				ordenDetalleImplement.save(detalle);
				//Agregamos cada detalle al cuerpo de la orden detalle
				detalles.add(detalle);
		    }
		}
	}

}
