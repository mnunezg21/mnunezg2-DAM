using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Reflection;

namespace LibreriaV5_Final.Persistencia
{
    public abstract class AccesoBD
    {
        private static MySqlConnection connection = null;
        private MySqlTransaction transaccion;
        private MySqlCommand comando;

        public AccesoBD()
        {
            try
            {
                connection = ConexionJDBC.AbrirConexion();
            }
            catch (Exception e)
            {
                throw;
                //throw new Exception(e.Message, e);
            }
        }


        public bool EjecutarUpdate(string sql, object objeto)
        {
            try
            {
                //"SELECT * FROM admin WHERE admin_username=@val1 AND admin_password=PASSWORD(@val2)"
                comando = new MySqlCommand(sql, connection); ///Esto es como preparedStatement
                PropertyInfo[] propertyInfo = objeto.GetType().GetProperties();
                int index = 1;

                if (sql.Contains("DELETE"))
                    {
                    comando.Parameters.AddWithValue("@1", propertyInfo[0].GetValue(objeto));
                    }
                else
                {
                    for (int i = 0; i < propertyInfo.Length; i++)
                    {
                        comando.Parameters.AddWithValue("@" + index++, propertyInfo[i].GetValue(objeto));
                    }
                    if (sql.Contains("UPDATE"))
                    {
                        comando.Parameters.AddWithValue("@" + index, propertyInfo[0].GetValue(objeto));
                    }
                }

            }
            catch (Exception) { throw; }
            return comando.ExecuteNonQuery() > 0;
        }

        public List<object> EjecutarConsulta(string sql, Type clase, string nombre)
        {
            List<object> objetos = null;
            MySqlDataReader sqlDataReader = null;
            try
            {
                comando = new MySqlCommand(sql, connection);
                if (!nombre.Equals(""))
                {
                    comando.Parameters.AddWithValue("@a1", nombre);
                }
                sqlDataReader = comando.ExecuteReader();
                if (sqlDataReader != null)
                {
                    objetos = new List<object>();
                    List<string> list = UtilSQL.ObtenerNombrePropiedades(clase);
                    {
                        while (sqlDataReader.Read())
                        {
                            object obj = Activator.CreateInstance(clase);
                            foreach (string name in list)
                            {
                                string valor = (String)sqlDataReader[name].ToString();
                                PropertyInfo propiedad = obj.GetType().GetProperty(name);
                                propiedad.SetValue(obj, Convert.ChangeType(valor, propiedad.PropertyType), null);

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
            transaccion = connection.BeginTransaction();
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
            connection.Close();
        }

        public string ObtenerCodigo(Type clase)
        {
            string sql = "SELECT MAX(Cod" + clase.Name.Substring(1) + ") FROM " + clase.Name.ToLower();
            MySqlDataReader sqlDataReader = null;
            try
            {
                comando = new MySqlCommand(sql, connection);
                sqlDataReader = comando.ExecuteReader();
                sqlDataReader.Read();
                return sqlDataReader[0].ToString();
            }
            catch (Exception) { throw; }
            finally
            {
                sqlDataReader.Close();
            }
        }
    }
}
