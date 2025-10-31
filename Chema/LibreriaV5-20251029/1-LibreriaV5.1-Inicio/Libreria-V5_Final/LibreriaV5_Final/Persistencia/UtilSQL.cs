using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;
//using LibreriaV5_Final.Persistencia;

namespace LibreriaV5_Final.Persistencia
{
    public class UtilSQL
    {
        private static StringBuilder sql = new StringBuilder();

        public static string SqlInsertar(object objeto)
        {
            sql.Clear();
            sql.Append("INSERT INTO " + objeto.GetType().Name.ToLower() + " ( ");
            RellenarSql(ObtenerNombrePropiedades(objeto.GetType()));
            return sql.ToString();
        }

        public static string SqlBuscar(Type clase)
        {
            sql.Clear();
            sql.Append("SELECT * FROM " + clase.Name.ToLower() + " WHERE " + obtenerClave(clase) + " = @a1 ");
            return sql.ToString();
        }

        public static string SqlBorrar(Object objeto)
        {
            sql.Clear();
            sql.Append("DELETE FROM " + objeto.GetType().Name.ToLower() + " WHERE " + obtenerClave(objeto.GetType()) + " = @1 ");
            return sql.ToString();
        }

        public static string SqlModificar(Object objeto)
        {
            sql.Clear();
            sql.Append("UPDATE " + objeto.GetType().Name.ToLower() + " SET ");
            int index = 1;
            foreach (var item in ObtenerNombrePropiedades(objeto.GetType()))
            {
                sql.Append(item+" = @" + (index++) + " , ");
            }
            sql.Remove(sql.Length - 2, 2);
            sql.Append("WHERE " + obtenerClave(objeto.GetType()) + " = @" + index);
            return sql.ToString();
        }

        public static string SqlObtener(Type clase)
        {
            sql.Clear();
            sql.Append("SELECT * FROM " + clase.Name.ToLower()+" WHERE Borrado LIKE 0");
            return sql.ToString();
        }      

        /*
         * Se obtiene una lista con el nombre de las propiedades para, posteriormente, hacer el set
         */
        public static List<string> ObtenerNombrePropiedades(Type clase)
        {
            List<string> lista = new List<string>();
            //Recorremos las propiedades y almacenamos el nombre
            foreach (PropertyInfo propiedad in clase.GetProperties())
            {
                lista.Add(propiedad.Name);
            }
            return lista;
        }
        
        public static string GenerarCodigo(Type clase)
        {
            String codigoGenerado;

            string codigo = new AccesoDAO<Object>().ObtenerCodigo(clase);
            if (codigo.Equals(""))
            {
                codigoGenerado = "cod001";
            }
            int indice = int.Parse(codigo.Substring(3)) + 1;
            if (indice >= 10)
                codigoGenerado = "cod0" + indice;
            else if (indice >= 100)
                codigoGenerado = "cod" + indice;
            else
                codigoGenerado = "cod00" + indice;
            return codigoGenerado;
        }
        //
        //********** MÉTODOS PRIVADOS DE LA CLASE UtilSQL*************************
        //
        private static void RellenarSql(List<string> list)
        {
            StringBuilder cadena = new StringBuilder(" ) VALUES ( ");
            int index = 1;
            foreach (string item in list)
            {
                sql.Append(item + ", ");
                cadena.Append("@" + (index++) + " , ");
            }
            sql.Remove(sql.Length - 2, 2);
            sql.Append(cadena.Remove(cadena.Length - 2, 2) + " ) ");
        }

        private static string obtenerClave(Type clase)
        {
            foreach (var item in ObtenerNombrePropiedades(clase))
            {
                if (item.StartsWith("Cod"))
                {
                    return item;
                }
            }
            return null;
        }

    }
}
