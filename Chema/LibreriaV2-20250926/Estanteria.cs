public class Estanteria
{


    //ArrayList donde se almacena cada LIBRO
    private List<Libro> libros = new List<Libro>();

	//------------------------------METODOS 
    /**
	* Inserta un libro en un arrayList
	* @param obLibro
	* @return True/False
	*/
    public Boolean insertarLibro(......)
    {
        if (buscarLibro(......) == null)
        {
            ?????.Add((oblibro));
            return ?????
        }//if
        else
            return false;
    }//insertarLibro

     /**
	 * Modifica un libro en el ArrayList. Primero se localiza y si se encuentra se borra y añade uno nuevo
     * con los datos procedentes del objeto.
	 */
    public Boolean  modificarLibro(........)   
    {
        Boolean modificado = false;
        ...... ...... = buscarLibro(.........);
        if (libro!=null)
        {
            ?????.Remove(libro);
            ?????.Add((oblibro));
            modificado = true;
        }
        return modificado;
    }//modificarLibro

    /**
	 * Entra por parametros una String con un titulo, y te devuelve el objeto libro exacto
	 * @param nombre
	 * @return
	 */
    public ...... buscarLibro(..........)
    {
        foreach (var libro in libros)
        {
            if (libro.Titulo.Equals(nombre))
            {
                return ?????;
            }
     
        }//foreach
        return null;
    }//buscarLibro

     /**
      * Borra un libro del arrayList a través del nombre
      * @param nombre
      * @return True/False
      */
    public Boolean borrarLibro(.........)
    {
        Boolean borrado = false;
        if (libros.Count!=0)
        {
            ???????.Remove(..............);
            borrado=true;
        }
        return borrado;
    }//borrarLibro
}//class