using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Reflection;

namespace LibreriaV5_Final.Persistencia
{
    public abstract class AccesoBD
    {
        private static MySqlConnection connection = null; //Objeto conexion a la base de datos
        private MySqlTransaction transaccion; //Objeto transaccion
        private MySqlCommand comando; //Objeto comando SQL

        // Mediante un construcutor abre la conexion a la base de datos
        public AccesoBD()
        {
            try
            {
                connection = ConexionBD.AbrirConexion();
            }
            catch (Exception e)
            {
                throw;
                //throw new Exception(e.Message, e);
            }
        }

        // Ejecuta sentencias SQL de tipo UPDATE, DELETE o INSERT y pide un sql y un objeto
        public bool EjecutarUpdate(string sql, object objeto)
        {
            try
            {
                comando = new MySqlCommand(sql, connection);
                PropertyInfo[] propertyInfo = objeto.GetType().GetProperties(); // Obtiene las propiedades del objeto
                int index = 1;// Indice para los parametros SQL

                //Si el sql contiene DELETE
                if (sql.Contains("DELETE"))
                {
                    //Añade el parametro del codigo del objeto, que es la primera propiedad, para borrarla
                    comando.Parameters.AddWithValue("@1", propertyInfo[0].GetValue(objeto));
                }
                else
                {
                    for (int i = 0; i < propertyInfo.Length; i++)
                    {
                        //INSERT
                        //Rellena los parametros SQL con los valores de las propiedades del objeto
                        comando.Parameters.AddWithValue("@" + index++, propertyInfo[i].GetValue(objeto));
                    }
                    if (sql.Contains("UPDATE")) //Si el sql contiene UPDATE
                    {
                        //Añade el parametro del codigo del objeto, que es la primera propiedad, para actualizarla
                        comando.Parameters.AddWithValue("@" + index, propertyInfo[0].GetValue(objeto));
                    }
                }

            }
            catch (Exception) { throw; }
            //ejecuta el comando
            return comando.ExecuteNonQuery() > 0;
        }

        // Ejecuta sentencias SQL de tipo SELECT y pide un sql, una clase y el çnombre 
        public List<object> EjecutarConsulta(string sql, Type clase, string nombre)
        {
            List<object> objetos = null; // Lista de objetos que se devolveran
            MySqlDataReader sqlDataReader = null; // Objeto para leer los datos devueltos por la consulta
            try
            {
                comando = new MySqlCommand(sql, connection);
                //Si el nombre no es vacio, añade el parametro al comando SQL
                if (!nombre.Equals(""))
                {
                    comando.Parameters. ("@a1", nombre);
                }
                sqlDataReader = comando.ExecuteReader(); // Ejecuta la consulta, devuelve un el resultado y lo lee con el DataReader
                if (sqlDataReader != null)
                {
                    objetos = new List<object>();// Inicializa la lista de objetos a devolver
                    List<string> list = UtilSQL.ObtenerNombrePropiedades(clase); // Obtiene los nombres de las propiedades de la clase
                    {
                        while (sqlDataReader.Read())// Recorre todas las filas devueltas por la consulta
                        {
                            object obj = Activator.CreateInstance(clase); // Crea una instancia de la clase, para cada fila devuelta
                            // Recorre todas las columnas de la fila devuelta
                            foreach (string name in list)
                            {
                                // Obtiene el valor de la columna y lo asigna a la propiedad correspondiente del objeto
                                string valor = (String)sqlDataReader[name].ToString();
                                PropertyInfo propiedad = obj.GetType().GetProperty(name); // Obtiene la propiedad del objeto
                                // Asigna el valor a la propiedad del objeto, convirtiendolo al tipo adecuado
                                propiedad.SetValue(obj, Convert.ChangeType(valor, propiedad.PropertyType), null);

                            }
                            objetos.Add(obj); // Añade el objeto a la lista de objetos devueltos
                        }
                    }
                }

            }
            catch (Exception)
            {
                throw;
            }
            finally
            {
                sqlDataReader.Close(); // Cierra el DataReader
            }
            return objetos; // Devuelve la lista de objetos obtenidos
        }

        // Inicia una transaccion
        public void StartTransaction()
        {
            transaccion = connection.BeginTransaction();
        }

        // Realiza un Rollback de la transaccion
        public void RollBack()
        {
            transaccion.Rollback();
        }

        // Realiza un Commit de la transaccion
        public void Commit()
        {
            transaccion.Commit();
        }

        // Cierra la conexion a la base de datos
        public void CloseConnection()
        {
            connection.Close();
        }

        // Obtiene el ultimo codigo de una tabla
        public string ObtenerCodigo(Type clase)
        {
            //Construye la sentencia SQL, para obtener el codigo maximo de la tabla
            string sql = "SELECT MAX(Cod" + clase.Name.Substring(1) + ") FROM " + clase.Name.ToLower();
            MySqlDataReader sqlDataReader = null; // Objeto para leer los datos devueltos por la consulta
            try
            {
                comando = new MySqlCommand(sql, connection);
                sqlDataReader = comando.ExecuteReader(); // Ejecuta la consulta, devuelve un el resultado y lo lee con el DataReader
                sqlDataReader.Read(); // Lee la primera fila devuelta
                return sqlDataReader[0].ToString(); // Devuelve el codigo maximo de la tabla
            }
            catch (Exception) { throw; }
            finally
            {
                sqlDataReader.Close(); // Cierra el DataReader 
            }
        }
    }

    public class ConexionBD 
    {

        private static MySqlConnection connection;

        public static MySqlConnection AbrirConexion()
        {
            if (connection == null)
            {
                try
                {
                    connection = new MySqlConnection();
                    connection.ConnectionString =
                        "Server=" + ConfigurationManager.AppSettings["servidor"].ToString()
                        + ";Database=" + ConfigurationManager.AppSettings["baseDatos"].ToString()
                        + ";Uid=" + ConfigurationManager.AppSettings["usuario"].ToString()
                        + ";Pwd=" + ConfigurationManager.AppSettings["password"].ToString() + ";";
                    connection.Open();
                }
                catch (Exception)
                {
                    throw;
                }
            }
            return connection;
        }

        public static void CerrarConexion()
        {
            if(connection!=null) connection.Close();
            
        }
    }
        
}