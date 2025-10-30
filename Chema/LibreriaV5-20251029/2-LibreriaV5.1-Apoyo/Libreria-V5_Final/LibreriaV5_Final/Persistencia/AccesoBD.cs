using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Reflection;

namespace LibreriaV5_Final.Persistencia
{
    public abstract class AccesoBD
    {
        private MySqlTransaction transaccion;
        private MySqlCommand comando;

        public AccesoBD()
        {
            try
            {
                Conexion.getConnection();
            }
            catch (Exception e)
            {
                throw;
            }
        }


        public bool EjecutarUpdate(string sql, object objeto)
        {

            StartTransaction();
            bool actualizado = false;
            try
            {
                //"SELECT * FROM admin WHERE admin_username=@val1 AND admin_password=PASSWORD(@val2)"
                comando = new MySqlCommand(sql, Conexion.getConnection()); ///Esto es como preparedStatement
                PropertyInfo[] propertyInfo = objeto.GetType().GetProperties();
                int index = 1;

                if (sql.Contains("DELETE"))
                {
                    comando.Parameters.AddWithValue("@1",propertyInfo[0].GetValue(objeto));
                }
                else
                {
                    for (int i = 0; i < propertyInfo.Length;i++)
                    {
                        comando.Parameters.AddWithValue("@" + index++, propertyInfo[i].GetValue(objeto));
                    }
                    if (sql.Contains("UPDATE"))
                    {
                        comando.Parameters.AddWithValue("@" + index, propertyInfo[0].GetValue(objeto));
                    }
                }
                actualizado = comando.ExecuteNonQuery() > 0;

                if (actualizado)
                {
                    Commit();
                }
            }
            catch (Exception) {

                RollBack();
                throw;
            }
            
            return actualizado;
        }

        public List<object> EjecutarConsulta(string sql, Type clase, string nombre)
        {
            List<object> objetos = null;
            MySqlDataReader sqlDataReader = null;
            try
            {
                comando = new MySqlCommand(sql, Conexion.getConnection());
                if (!nombre.Equals(""))
                {
                    comando.Parameters.AddWithValue("@a1", nombre);
                }
                sqlDataReader = comando.ExecuteReader();
                if (sqlDataReader != null)
                {
                    objetos = new List<object>();
                    PropertyInfo[] properties = UtilSQL.ObtenerPropiedades(clase);
                    {
                        while (sqlDataReader.Read())
                        {
                            object obj = Activator.CreateInstance(clase);
                            foreach (PropertyInfo property in properties)
                            {
                                string valor = (String)sqlDataReader[property.Name].ToString();
                                property.SetValue(obj, Convert.ChangeType(valor, property.PropertyType), null);

                            }
                            objetos.Add(obj);
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
                sqlDataReader.Close();
            }
            return objetos;
        }

        public void StartTransaction()
        {
            transaccion = Conexion.getConnection().BeginTransaction();
        }

        public void RollBack()
        {
            transaccion.Rollback();
        }

        public void Commit()
        {
            transaccion.Commit();
        }

        public void CloseConnection()
        {
            Conexion.CerrarConexion();
        }

        public class Conexion
        {
            private static MySqlConnection connection;

            /*  
             *  Abre la conexion con la base de datos
             */
            public static MySqlConnection getConnection()
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
                if (connection != null) connection.Close();

            }
        }
    }
}
