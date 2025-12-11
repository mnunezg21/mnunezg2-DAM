package main;

import java.time.LocalDate;
import java.util.Scanner;

import modelo.Artista;
import modelo.Cancion;
import modelo.MetadatosCancion;
import modelo.Playlist;
import repository.CRUD;


public class MainApp {

	private static final CRUD REPO = new CRUD();
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {		
		int opcion=0;
		do {
			opcion = mostrarMenu();
			switch(opcion) {
			case 1:
				crearAlbum();
				break;
			case 2:
				crearPlaylist();
				break;
			case 3:
				verLetraYDetalles();
				break;
			case 4:
				artistasMasContenido();
				break;
			case 5:
				eliminarCancion();
				break;
			case 6:
				reasignarCancion();
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default: 
				System.out.println("Error en la entrada de teclado");
				break;
			}
		} while(opcion != 0);
	}

	
	private static void crearAlbum() {
		String nombreArtista;
		String nacionalidadArtista;
		int cantidadCanciones;
		String tituloCancion;
		int duracionSeg;
		
		
		
		System.out.println("Introduce el nombre del artista: ");
		nombreArtista=teclado.next();
		System.out.println("Introduce la nacionalidad del artista: ");
		nacionalidadArtista = teclado.next();
		Artista artista = REPO.existeArtista(null, nombreArtista, nacionalidadArtista);
		if (artista!=null) {
			System.out.println("El artista existe en la base de datos y tiene el id: "+artista.getIdArtista());
		} else {
			System.out.println("Este artista no existe en la base de datos. \nAñadiendo artista...");
			artista =new Artista(nombreArtista,nacionalidadArtista,0L);
		}
		System.out.println("Introduce cuantas canciones tiene el album: ");
		cantidadCanciones=teclado.nextInt();
		for (int i = 0; i < cantidadCanciones; i++) {
			System.out.println("Introduce el titulo de la cancion: ");
			tituloCancion=teclado.next();
			System.out.println("Introduce la duracion en segundos de la cancion: ");
			duracionSeg=teclado.nextInt();
			Cancion cancion = new Cancion(tituloCancion,duracionSeg);
			MetadatosCancion metadatosCancion = new MetadatosCancion("Letraaa....",nombreArtista,LocalDate.now());
			cancion.setMetadatos(metadatosCancion);
			artista.addCancion(cancion);
		}
		if (REPO.guardarArtistaYAlbum(artista)) System.out.println("Artista y album agregado correctamente");
		else System.out.println("Error al guardar el artista con su album");
	}
	
	private static void crearPlaylist() {
		int idCancion;
		String nombrePlayList;
		String nombreCreador;
		String opcion;
		Boolean aniadirCancion=true;

		
		System.out.println("Introduce el nombre de la PlayList: ");
		nombrePlayList = teclado.next();
		System.out.println("Introduce el nombre del creador: ");
		nombreCreador = teclado.next();
		
		Playlist playlist = new Playlist(nombrePlayList,nombreCreador,LocalDate.now());
		
		System.out.println("Introduce el id de una cancion: ");
		idCancion = teclado.nextInt();
		Cancion cancion = null;
		cancion=REPO.buscarCancionPorId(idCancion);
		if (cancion==null) {
			System.out.println("Este id no le pertenece a ninguna cancion");
		}else {
			playlist.agregarCancion(cancion, idCancion);
			System.out.println("Cancion Agregada");
		}
		do {
			System.out.println("¿Quieres añadir otra cancion?(SI/NO)");
			opcion=teclado.next();
			if (opcion.equalsIgnoreCase("NO")) {
				aniadirCancion=false;
			} else if(opcion.equalsIgnoreCase("SI")) {
				System.out.println("Introduce el id de la cancion: ");
				idCancion=teclado.nextInt();
				
				cancion=REPO.buscarCancionPorId(idCancion);
				if (cancion==null) {
					System.out.println("Este id no le pertenece a ninguna cancion");
				}else {
					playlist.agregarCancion(cancion, idCancion);
					System.out.println("Cancion Agregada");
				}
				
			} else System.out.println("Error al introducir la opcion, vuelva a intentarlo");
			
		} while (!aniadirCancion);
		if (REPO.guardarPlaylist(playlist)) {
			System.out.println("Playlist '" + nombrePlayList + "' guardada");
		} else {
			System.err.println("Error al guardar la playlist");
		}	
	}


	private static void verLetraYDetalles() {
		int id;
		String opcion;
		Cancion cancion = null;
		
		System.out.println("Introduce el id de la Cancion: ");
		id=teclado.nextInt();
		cancion=REPO.buscarCancionPorId(id);
		if (cancion!=null) {
			System.out.println("¿Desea ver la letra y ficha técnica? (s/n)");
			opcion=teclado.next();
			if (opcion.equalsIgnoreCase("s")) {
				System.out.println("Aqui tienes la ficha tecnica: "+cancion.getMetadatos());
			} else if(opcion.equalsIgnoreCase("n")) {
				System.out.println("Volviendo al menu principal...");
			} else System.out.println("No has introducido una opcion valida");
		}else System.out.println("Error al buscar la cancion");
	}


	private static void artistasMasContenido() {
		
	}


	private static void eliminarCancion() {
		int id;
		
		System.out.println("Introduce el id de la cancion que quieres eliminar: ");
		id = teclado.nextInt();
		Cancion cancion = null;
		cancion=REPO.buscarCancionPorId(id);
		if (cancion!=null) {
			if (REPO.eliminarCancion(id)) {
				System.out.println("Cancion eliminada con exito, incluyendo lso metadatos y la asociacion con la playlist");
			} else System.out.println("Error al eliminar la Cancion");
		} else System.out.println("Error al buscar la cancion");
		
	}


	private static void reasignarCancion() {
		int idCancion;
		int idArtista;
		
		System.out.println("Introduce el id de la cancion: ");
		idCancion= teclado.nextInt();
		Cancion cancion = null;
		cancion=REPO.buscarCancionPorId(idCancion);
		if (cancion!=null) {
			System.out.println("Introduce el id del Nuevo artista: ");
			idArtista=teclado.nextInt();
			Artista artista = null;
			artista=REPO.buscarArtistaPorId(idArtista);
			if (artista!=null) {
				cancion.setArtista(artista);
				REPO.reasignarCancion(idCancion, idArtista);
			}else System.out.println("Este artista no existe");
		}else System.out.println("Esta cancion no existe");
		
	}


	private static int mostrarMenu() {
		System.out.println("1. Crear Album"+
						  "\n2. Crear Playlist"+
						  "\n3. Ver letra de cancion y Detalles"+
						  "\n4. Ver reporte de artistas"+
						  "\n5. Eliminar una cancion"+
						  "\n6. Reasignar Cancion"+
						  "\n0.  Salir");
		return teclado.nextInt();
	}
}
