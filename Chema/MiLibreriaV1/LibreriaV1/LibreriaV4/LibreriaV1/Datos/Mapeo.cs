using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Reflection;

namespace LibreriaV2.Datos
{
    // Se encarga de transformar los objetos del programa a registros de la base de datos y viceversa.
    class Mapeo
    {
        //Devuelve una Lista
        public static List<String> ObtenerNombrePropiedades(Object objeto)
        {
            List<String> lista = new List<string>(); //Crea la lista vacia para almacenar los nombres
            PropertyInfo[] ee =  objeto.GetType().GetProperties(); //Obtiene el objeto.y obtiene todas las prioridades

            //Este foreach se encarga de añadir a la lista, cada nombre que ha recogido antes
            foreach(PropertyInfo info in objeto.GetType().GetProperties())
            {
                lista.Add(info.Name);
            }
            return lista;
        }

    }
}
