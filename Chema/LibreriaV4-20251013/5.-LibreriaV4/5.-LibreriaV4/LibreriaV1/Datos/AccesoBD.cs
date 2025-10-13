using System;
using System.Configuration;
using System.Collections.Generic;
using MySql.Data.MySqlClient;
using System.Reflection;

namespace LibreriaV2.Datos
{
    public class AccesoBD
    {

        private String servidor;
        private String bdNombre;
        private String usuario;
        private String contrasena;
        private MySqlConnection conexion;
        private MySqlCommand comando;
        private MySqlTransaction transaccion;

        //Carga los datos de la conexion
        public AccesoBD()
        {
            try
            {
                servidor = ConfigurationManager.AppSettings["servidor"].ToString();
                bdNombre = ConfigurationManager.AppSettings["baseDatos"].ToString();
                usuario = ConfigurationManager.AppSettings["usuario"].ToString();
                contrasena = ConfigurationManager.AppSettings["password"].ToString();
            }
            catch (Exception e)
            {
                throw;
            }
        }

        protected void abrirConexion()
        {
            try
            {
                conexion = new MySqlConnection();
                conexion.ConnectionString = "Server=" + servidor + "; Database=" + bdNombre + "; Uid=" + usuario + "; Pwd=" + contrasena + ";SslMode=none;";
                conexion.Open();
            }
            catch (Exception e)
            {
                throw;
            }

        }

        protected void cerrarConexion()
        {
            try
            {
                conexion.Close();
            }
            catch (Exception e)
            {
                throw;
            }
        }

        protected void iniciarTransaccion()
        {
            try
            {
                transaccion = this.conexion.BeginTransaction();
            }
            catch (Exception e)
            {
                throw;
            }
        }

        protected void aceptarTransaccion()
        {
            try
            {
                transaccion.Commit();
            }
            catch (Exception e)
            {
                throw;
            }
        }

        protected void cancelarTransaccion()
        {
            try
            {
                transaccion.Rollback();
            }
            catch (Exception e)
            {
                throw;
            }
        }

        public Boolean ejecutarUpdate(String sql)
        {
            abrirConexion();
            try
            {
                comando = new MySqlCommand(sql, conexion);
                return comando.ExecuteNonQuery() > 0;
            }
            catch (Exception e)
            {
                throw;
            }
            finally
            {
                cerrarConexion();
            }
        }

        public List<Object> ejecutarConsulta(String sql, Object objeto)
        {
            abrirConexion();
            List<Object> objetos = new List<object>();
            MySqlDataReader dataReader = null;
            try
            {
                comando = new MySqlCommand(sql, conexion);
                dataReader = comando.ExecuteReader();
                List<String> nombrePropiedades = Mapeo.ObtenerNombrePropiedades(objeto);

                while (dataReader.Read())
                {
                    Object obj = Activator.CreateInstance(objeto.GetType());
                    foreach (String nombre in nombrePropiedades)
                    {
                        String valor = dataReader[nombre].ToString();
                        PropertyInfo propiedad = obj.GetType().GetProperty(nombre);
                        propiedad.SetValue(obj, Convert.ChangeType(valor, propiedad.PropertyType), null);
                    }
                    objetos.Add(obj);
                }
                dataReader.Close();
            }
            catch (Exception e)
            {
                throw;
            }
            finally
            {
                cerrarConexion();
            }
            return objetos;
        }

        //*******************************************************************************************************************
        // Este método no se utiliza ya que ExecuteScalar() devuelve el valor de la primera columna de la tabla.
        // Nuestro objetivo es devolver todos las columnas de la tabla y cargar objetos. Se usa mejor DataReader
        //*******************************************************************************************************************
       
        /*public object ejecutarConsulta(String sql)
        {
            try
            {
                abrirConexion();
                comando = new MySqlCommand(sql, conexion);
                return comando.ExecuteScalar();
            }
            catch (Exception e)
            {
                throw;
            }
            finally
            {
                cerrarConexion();
            }
        }*/

    }
}
