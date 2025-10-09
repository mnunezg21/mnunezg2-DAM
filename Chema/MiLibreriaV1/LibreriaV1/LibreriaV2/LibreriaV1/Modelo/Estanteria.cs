using LibreriaV3._1.Modelo;
using System;
using System.Collections.Generic;

public class Estanteria
{   	   
    private List<Libro> libros = new List<Libro>();
    
    public Boolean insertarLibro(Libro libro)
    {
        if (buscarLibro(libro.Titulo) == null)
        {
            libros.Add(libro);
            return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean  modificarLibro(Libro oblibro)
    {
        Boolean modificado= false;
        Libro libro = buscarLibro(oblibro.Titulo);
        if (libro != null)
        {
            libros.Remove(libro);
            libros.Add(oblibro);
            modificado=true;
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
            borrado = true;
        }
        return borrado;
    }
}
