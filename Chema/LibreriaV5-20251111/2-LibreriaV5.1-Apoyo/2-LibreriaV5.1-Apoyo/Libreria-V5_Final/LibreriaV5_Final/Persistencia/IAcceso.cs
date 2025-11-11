using System;
using System.Collections.Generic;

namespace LibreriaV5_Final.Persistencia
{
    interface IAcceso<obj>
    {
       bool Insertar(obj objeto) ;
       bool Borrar(Object objeto);
       bool BorradoVirtual(Object objeto);
       Object Buscar(Type clase, String nombre);
       List<object> Buscar(Type clase, string campo, string busqueda);
       List<object> Obtener(Type clase);
       bool Modificar(obj objeto);
    }

}
