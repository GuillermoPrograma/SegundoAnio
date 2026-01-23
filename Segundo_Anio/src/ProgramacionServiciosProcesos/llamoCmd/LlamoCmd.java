package ProgramacionServiciosProcesos.llamoCmd;

import java.io.IOException;
import java.io.InputStream;

public class LlamoCmd {
public static void main(String[] args) throws IOException {
	Process ps = new ProcessBuilder("cmd", "/c", "dir").start();
	try {
		InputStream is = ps.getInputStream();
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
