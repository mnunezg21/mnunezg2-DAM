using LibreriaV3._1.Modelo;
using System;
using System.Collections.Generic;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Windows.Forms;

public class Estanteria
{   	   
    private List<Libro> libros = new List<Libro>();

    // Nombre del fichero donde se guardan los datos
    private const string DATA_FILENAME = "data.dat"; 
    // Se encarga de serializar y deserializar los objetos, convertir a bytes
    private BinaryFormatter formatter;
    // Se encarga de manejar el flujo de lectura/escritura del fichero
    private FileStream readerFileStream = null; 

    public List<Libro> cargarLibros()
    {// LLama al metodo leerlibros para recoger los datos del fichero
        List<Libro> libros = leerLibros(); 
        return libros; //Devuelve la lista de libros leidos
    }

    private List<Libro> leerLibros()
    {
        // Crea una instancia para deserializar los datos del archivo
        formatter = new BinaryFormatter(); 
        try { 
            if (File.Exists(DATA_FILENAME)) //Si el fichero existe
            {
                // Crea un flujo que representa una conexion entre el programa y el archivo
                readerFileStream = new FileStream( 
                    DATA_FILENAME, // Nombre fichero
                    FileMode.Open, // Modo apertura,
                    FileAccess.Read // Modo lectura, 
                    );
                libros = (List<Libro>)formatter.Deserialize( // Lee bytes y los convierte en objetos
                    readerFileStream // Flujo de lectura
                    );
               
            }
        } catch (Exception ex) {
            MessageBox.Show("Error al leer los datos: " + ex.Message);
        }
        finally
        {
            cerrarFichero();
        }
        return libros;
    }

    private void escribirFichero(List<Libro> libros)
    {
        // Crea una instancia para deserializar los datos del archivo
        formatter = new BinaryFormatter(); 
        try
        {
            // Crea una instancia para serializar y convertirlos a bytes para pasarlos al archivo
            //Es un objeto de esta interface
            IFormatter formatter = new BinaryFormatter();
            // using, cierra el flujo automaticamente
            // Stream, representa el flujo de datos
            using (Stream stream = new FileStream(
                DATA_FILENAME, // Nombre fichero
                FileMode.Create, // Modo creacion, se carga todo el fichero y lo reescribe
                FileAccess.Write, // Modo escritura, se encarga de escribir en el fichero
                FileShare.None // No comparte el acceso al fichero con nadie mas
                ))
                formatter.Serialize(stream, libros); // Convierte los objetos a bytes y va directamente al fichero
        }
        catch (Exception e)
        {
            MessageBox.Show("Error fichero:" + e.Message);
        }
        finally
        {
            cerrarFichero();
        }
    }
    private void cerrarFichero()
    {
        if (readerFileStream != null) {
            readerFileStream.Flush(); // Vacia la memoria temporal y fuerza a escribir datos en el disco
            readerFileStream.Close(); // Cierra la conexion 
            readerFileStream.Dispose(); // Libera recursos no administrados del sistema operativo
        }
    }

    public Boolean insertarLibro(Libro libro)
    {
        if (buscarLibro(libro.Titulo) == null)
        {
            libros.Add(libro);
            escribirFichero(libros);
            return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean modificarLibro(Libro oblibro)
    {
        Boolean modificado= false;
        Libro libro = buscarLibro(oblibro.Titulo);
        if (libro != null)
        {
            libros.Remove(libro);
            libros.Add(oblibro);
            escribirFichero(libros); // Escribe la lista actualizada en el fichero
            modificado = true;
        }
        return modificado;
    }
    public Libro buscarLibro(String nombre)
    {
        foreach (var libro in libros) {
            if (libro.Titulo.Equals(nombre))
            {
                return libro;
            }
        }
        return null;
    }

    public Boolean borrarLibro(Libro obLibro)
    {
        Boolean borrado= false;
        Libro libro = buscarLibro(obLibro.Titulo);
        if (libro != null) 
        {
            libros.Remove(libro);
            escribirFichero(libros); // Escribe la lista actualizada en el fichero
            borrado = true;
        }
        return borrado;
    }
}
