package Ejercicio04.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Ejercicio04.modelo.LineaPedido;
import Ejercicio04.modelo.Pedido;
import Ejercicio04.servicios.PedidosService;



public class App {
	public static void main(String[] args) {
		PedidosService service = new PedidosService();
		Pedido pedido = new Pedido();
		LineaPedido articulo1 = new LineaPedido();
		LineaPedido articulo2 = new LineaPedido();
		List<LineaPedido> articulos = new ArrayList<>();
		articulo1.setNumeroLinea(1);
		articulo1.setArticulo("PC");
		articulo1.setPrecio(new BigDecimal(1000));
		articulo2.setNumeroLinea(2);
		articulo2.setArticulo("Monitor");
		articulo2.setPrecio(new BigDecimal(150));
		articulos.add(articulo1);
		articulos.add(articulo2);
		LocalDate fechaPedido = LocalDate.of(2021, 4, 1);
		LocalDate fechaEntrega = LocalDate.of(2021, 5, 3);
	
		pedido.setFechaPedido(fechaPedido);
		pedido.setFechaEntrega(fechaEntrega);
		pedido.setCliente("Gonzalo");
		pedido.setLineasPedido(articulos);
		
		try {
			service.registrarPedido(pedido);
			System.out.println(pedido);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
