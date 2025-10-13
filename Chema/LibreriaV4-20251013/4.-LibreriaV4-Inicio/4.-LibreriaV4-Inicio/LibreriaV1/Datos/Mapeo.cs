using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Reflection;

namespace PracticaCRUD.BBDD
{
    class Mapeo
    {

        public static List<String> ObtenerNombrePropiedades(Object objeto)
        {
            List<String> lista = new List<string>();
            PropertyInfo[] ee =  objeto.GetType().GetProperties();
            foreach(PropertyInfo info in objeto.GetType().GetProperties())
            {
                lista.Add(info.Name);
            }
            return lista;
        }

    }
}
