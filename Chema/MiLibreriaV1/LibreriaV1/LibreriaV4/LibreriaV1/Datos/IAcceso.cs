using System;
using System.Collections.Generic;

namespace LibreriaV2.Datos
{
    interface IAcceso<obj>
    {
        //Interfaz 
        bool insertarLibro(obj objeto);
        bool borrarLibro(obj objeto);
        Object buscarLibro(String nombre);
        List<object> obtenerLibros();
        bool modificarLibro(obj objeto);
    }

}
