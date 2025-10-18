package rama;

import java.util.Iterator;
import java.util.Map;

public class EjPoroccesBuilder {

	public static void main(String[] args) {
		ejeEntorno();
	}

	private static void ejeEntorno() {
		ProcessBuilder pb = new ProcessBuilder();
		Map<String, String> variablesEntorno = pb.environment();
		
		System.out.println("Variables de Entorno: ");
		Iterator<String> it = variablesEntorno.keySet().iterator();
		
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println("Clave: " + key + " Valor: " + variablesEntorno.get(key));
		}
	}

}
