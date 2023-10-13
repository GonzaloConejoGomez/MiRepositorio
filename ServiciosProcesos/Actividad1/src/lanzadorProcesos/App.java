package lanzadorProcesos;

public class App {

	public static void main(String[] args) {
		String ruta = "CMD";
		LanzadorProcesos lp = new LanzadorProcesos();
		lp.ejecutar(ruta);
		
		
		
		System.out.println("Finalizado");
	}

}
 