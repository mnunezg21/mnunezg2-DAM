using System;
using System.Reflection;
using System.Text;

namespace LibreriaV5_Final.Persistencia
{
    public class UtilSQL
    {
        private static StringBuilder sql = new StringBuilder();

        public static string SqlInsertar(object objeto)
        {
            sql.Clear();
            sql.Append("INSERT INTO " + objeto.GetType().Name.ToLower() + " ( ");
            RellenarSql(ObtenerPropiedades(objeto.GetType()));
            return sql.ToString();
        }

        public static string SqlBuscar(Type clase)
        {
            sql.Clear();
            sql.Append("SELECT * FROM " + clase.Name.ToLower() + " WHERE " + ObtenerClave(clase) + " = @a1 ");
            return sql.ToString();
        }

        public static string SqlBorrar(Object objeto)
        {
            sql.Clear();
            sql.Append("DELETE FROM " + objeto.GetType().Name.ToLower() + " WHERE " + ObtenerClave(objeto.GetType()) + " = @1 ");
            return sql.ToString();
        }

        public static string SqlModificar(Object objeto)
        {
            sql.Clear();
            sql.Append("UPDATE " + objeto.GetType().Name.ToLower() + " SET ");
            int index = 1;
            foreach (var item in ObtenerPropiedades(objeto.GetType()))
            {
                sql.Append(item.Name + " = @" + (index++) + " , ");
            }
            sql.Remove(sql.Length - 2, 2);
            sql.Append("WHERE " + ObtenerClave(objeto.GetType()) + " = @" + index);
            return sql.ToString();
        }

        public static string SqlObtener(Type clase)
        {
            sql.Clear();
            sql.Append("SELECT * FROM " + clase.Name.ToLower() + " WHERE Borrado LIKE 0");
            return sql.ToString();
        }


        public static string ObtenerClave(Type clase)
        {
            return "Cod" + clase.Name.ToString().Substring(1);
        }

        private static void RellenarSql(PropertyInfo[] properties)
        {
            StringBuilder cadena = new StringBuilder(" ) VALUES ( ");
            int index = 1;
            foreach (PropertyInfo property in properties)
            {
                sql.Append(property.Name + ", ");
                cadena.Append("@" + (index++) + " , ");
            }
            sql.Remove(sql.Length - 2, 2);
            sql.Append(cadena.Remove(cadena.Length - 2, 2) + " ) ");
        }

        public static string GenerarCodigo(Type clase)
        {
            String codigoGenerado;

            string codigo = new AccesoDAO<Object>().ObtenerCodigo(clase);
            if (codigo.Equals(""))
            {
                codigoGenerado = "cod001";
            }
            else
            {
                int indice = int.Parse(codigo.Substring(3)) + 1;
                if (indice >= 100)
                    codigoGenerado = "cod" + indice;
                else if (indice >= 10)
                    codigoGenerado = "cod0" + indice;
                else
                    codigoGenerado = "cod00" + indice;
            }
            return codigoGenerado;
        }

        /*
      * Se obtiene una lista con el nombre de las propiedades para, posteriormente, hacer el set
        */
        public static PropertyInfo[] ObtenerPropiedades(Type clase)
        {
            return clase.GetProperties();
        }





    }
}
