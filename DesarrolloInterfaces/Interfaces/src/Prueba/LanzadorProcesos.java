package Prueba;

public class LanzadorProcesos {
	public void ejecutarNotepad() {

		try {

			ProcessBuilder p = new ProcessBuilder("notepad");
			p.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ejecutarCalc() {

		try {

			ProcessBuilder p = new ProcessBuilder("calc");
			p.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}