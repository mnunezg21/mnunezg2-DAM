package sol1;

public class sol1 {

		public static void main(String[] args) {
			String nombreAlumno="Monica Garcia";
			int notaMatematicas=6;
			int notaLengua=7;
			int notaIngles=4;
			int notaInformatica=6;
			
			System.out.println("Alumno: "+nombreAlumno);
			System.out.println("Nota de matematicas: "+notaMatematicas);
			System.out.println("Nota de lengua: "+notaLengua);
			System.out.println("Nota de ingles: "+notaIngles);
			System.out.println("Nota de informatica: "+notaInformatica);
			// SOLUCION A
			System.out.println("//SOLUCION A//");
			System.out.println("Nota media: "+(notaMatematicas+notaIngles+notaInformatica+notaLengua)/4.0);
			
			// SOLUCION B
			System.out.println("//SOLUCION B//");
			double notaMedia=(notaMatematicas+notaIngles+notaInformatica+notaLengua)/4.0;
			System.out.println("Nota media: "+notaMedia);
			
			// SOLUCION C
			System.out.println("//SOLUCION C//");
			System.out.println("Nota media: "+media(notaMatematicas,notaIngles,notaInformatica,notaLengua));
		}
 
		private static double media(int...valores) {
			double suma=0;
			for(int valor : valores) {
				suma+=valor;
			}
			return suma/valores.length;
		}
}
