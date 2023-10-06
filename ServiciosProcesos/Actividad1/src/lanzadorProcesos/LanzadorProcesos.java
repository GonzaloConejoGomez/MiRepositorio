package lanzadorProcesos;

import java.io.InputStream;

public class LanzadorProcesos {
	public void ejecutar(String ruta) {

		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder(ruta);
			pb.start();
			Process p = new ProcessBuilder("CMD","/C","start","dir").start();
			Process p1 = new ProcessBuilder("calc").start();
		
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
