using System;
using MySql.Data.MySqlClient;
using System.Configuration;


namespace LibreriaV5_Final.Persistencia
{
    public class ConexionJDBC
    {
        private static MySqlConnection connection;

        /*  
         *  Abre la conexion con la base de datos
         */
        public static MySqlConnection AbrirConexion ()  
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
