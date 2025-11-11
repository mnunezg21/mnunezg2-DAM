using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace LibreriaV5_Final.Persistencia
{
    /*Generar sentencias SQL automáticamente mediante reflexión.

    Se encarga de crear las sentencias SQL para las operaciones básicas CRUD (Create, Read, Update, Delete)
    basándose en las propiedades de los objetos proporcionados, usando reflexión para inspeccionar las propiedades de los objetos.
    
    Objetivo: Facilitar la generación dinámica de sentencias SQL para interactuar con la base de datos 
    sin necesidad de escribir manualmente cada sentencia SQL.
    */
    public class UtilSQL
    {
        //StringBuider para construir las sentencias SQL forma eficiente
        private static StringBuilder sql = new StringBuilder();


        //Genera la sentencia SQL de INSERT automaticamente, pidiendo un objeto por parámetro
        public static string SqlInsertar(object objeto)
        {
            sql.Clear();//Limpiamos el StringBuilder
            sql.Append("INSERT INTO " + objeto.GetType().Name.ToLower() + " ( ");//Añade el nombre de la clase a la tabla, 
            RellenarSql(ObtenerNombrePropiedades(objeto.GetType()));// Rellena las propiedades y los valores
            return sql.ToString();// Devuelve la sentencia SQL completa, en forma de String 
        }

        //Genera la sentencia SQL de SELECT automaticamente, pidiendo una clase como parámetro
        public static string SqlBuscar(Type clase)
        {
            sql.Clear();//Limpiamos el StringBuilder
            //Construimos la sentencia SQL, añadiendo el nombre de la clase y la clave primaria
            sql.Append("SELECT * FROM " + clase.Name.ToLower() + " WHERE " + obtenerClave(clase) + " = @a1 ");
            return sql.ToString();
        }

        // Genera la sentencia sql DELETE automaticamente, pidiendo un objeto generico como parametro
        public static string SqlBorrar(Object objeto)
        {
            sql.Clear();
            // Recoge el nombre de la clase en minuscula, y la clave primaria
            sql.Append("DELETE FROM " + objeto.GetType().Name.ToLower() + " WHERE " + obtenerClave(objeto.GetType()) + " = @1 ");
            return sql.ToString(); 
        }

        // Genera la sentencia sql UPDATE automaticamente, pidiendo un objeto generico como parametro 
        public static string SqlModificar(Object objeto)
        {
            sql.Clear();
            // Recoge el nombre de la clase en minusculas
            sql.Append("UPDATE " + objeto.GetType().Name.ToLower() + " SET ");
            int index = 1;
            //Recorre todas las propiedades de un clase
            foreach (var item in ObtenerNombrePropiedades(objeto.GetType()))
            {
                // Cambia el parametro antiguo por el nuevo (item nuevo, =@ viejo
                sql.Append(item + " = @" + (index++) + " , ");

            }
            // Cuando termina de posicionar, elimina la , y el espacio despues de la ultima propiedad 
            sql.Remove(sql.Length - 2, 2);
            // Añade la clausula WHERE con la clave primaria y modifica cada parametro, hasta los que no has modificado
            sql.Append("WHERE " + obtenerClave(objeto.GetType()) + " = @" + index);
            return sql.ToString();
        }

        //Genera la sentencia sql SELECT automaticamente, pidiendo una clase como parametro
        public static string SqlObtener(Type clase)
        {
            sql.Clear();
            // Construye la sentencia SQL, añadiendo el nombre de la clase, y tiene que ser no borrado
            sql.Append("SELECT * FROM " + clase.Name.ToLower()+" WHERE Borrado LIKE 0");
            return sql.ToString();
        }      

        /*
         * Se obtiene una lista con el nombre de las propiedades para, posteriormente, hacer el set
         */

        public static List<string> ObtenerNombrePropiedades(Type clase)
        {
            List<string> lista = new List<string>();
            //Recorremos las propiedades y almacenamos el nombre,(Almacena los datos de las propiedades)
            foreach (PropertyInfo propiedad in clase.GetProperties())
            {
                lista.Add(propiedad.Name);
            }
            return lista;
        }
        
        //Genera un código nuevo para la clave primaria de un objeto
        public static string GenerarCodigo(Type clase)
        {
            String codigoGenerado;
            //Obtiene el codigo mayor de esa clase
            string codigo = new AccesoDAO<Object>().ObtenerCodigo(clase);
            if (codigo.Equals(""))//Si esta vacio genera cod001
            {
                codigoGenerado = "cod001";
            }
            //Coge la subcadena empezando desde el índice 3 hasta el final y lo parsea a entero
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
            //Recoge cada propiedad y la posiciona en su posicion en la tabla 
            foreach (string item in list)
            {
                sql.Append(item + ", ");
                cadena.Append("@" + (index++) + " , ");
            }
            // Cuando termina de posicionar, elimina la , y el espacio despues de la ultima propiedad 
            sql.Remove(sql.Length - 2, 2);
            sql.Append(cadena.Remove(cadena.Length - 2, 2) + " ) ");
        }

        private static string obtenerClave(Type clase)
        {
            //Recorre todas las propiedades de la Clase y si la propiedad existe con "Cod" al principio la devuelve
            foreach (var item in ObtenerNombrePropiedades(clase))
            {  
                if (item.StartsWith("Cod"))
                {
                    return item;
                }
            }
            return null; //Si no, devuelve null
        }

    }
}
