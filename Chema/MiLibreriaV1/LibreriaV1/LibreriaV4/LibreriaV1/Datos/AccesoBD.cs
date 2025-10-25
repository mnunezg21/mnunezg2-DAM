using System;
using System.Configuration;
using System.Collections.Generic;
using MySql.Data.MySqlClient;
using System.Reflection;

namespace LibreriaV2.Datos
{
    public class AccesoBD
    {
        // Variales que se encargan de almacenar los datos datos de conexion para acceder a la base de datos
        // Estos valores se cargan desde el archivo de App.config
        private String servidor;
        private String bdNombre;
        private String usuario;
        private String contrasena;

        // Objetos para la gestion de la base de datos MySQL
        private MySqlConnection conexion; // Establece conexión a la bbdd
        private MySqlCommand comando; // Ejecuta los comandos SQL
        private MySqlTransaction transaccion; // Se encarga de hacer transacciones 

        // Constructor - Carga la configuración de conexión desde App.config
        public AccesoBD()
        {
            //Control de errores
            try // Dentro va todo el codigo que pueda fallar
            {
                servidor = ConfigurationManager.AppSettings["servidor"].ToString();
                bdNombre = ConfigurationManager.AppSettings["baseDatos"].ToString();
                usuario = ConfigurationManager.AppSettings["usuario"].ToString();
                contrasena = ConfigurationManager.AppSettings["password"].ToString();
            }
            catch (Exception e) // Si falla, entra aquí | "e" es un objeto de la clase Exception
            {
                throw; // Lanza la excepción
            }
        }

        // Método para abrir
        protected void abrirConexion()
        {
            try
            {
                conexion = new MySqlConnection(); // Crea el objeto de conexión
                // Monta la cadena de conexión
                conexion.ConnectionString = "Server=" + servidor + "; Database=" + bdNombre + "; Uid=" + usuario + "; Pwd=" + contrasena + ";SslMode=none;";
                // Abre la conexión
                conexion.Open();
            }
            catch (Exception e)
            {
                throw;
            }

        }

        // Método para cerrar la conexión
        protected void cerrarConexion()
        {
            try
            {
                conexion.Close(); // Cierra la conexión, libera recursos de conexión
            }
            catch (Exception e)
            {
                throw;
            }
        }

        // Métodos para el manejo de transacciones solo se puede usasr INSERT, UPDATE, DELETE
        protected void iniciarTransaccion()
        {
            try
            {
                transaccion = this.conexion.BeginTransaction(); // Inicia la transacción y encapsula las sentencias
            }
            catch (Exception e)
            {
                throw;
            }
        }

        // Confirma la transacción (hace commit) 
        protected void aceptarTransaccion()
        {
            try
            {
                transaccion.Commit(); // Aplica los cambios de la transación
            }
            catch (Exception e)
            {
                throw;
            }
        }

        // Cancela la transacción (hace rollback) 
        protected void cancelarTransaccion()
        {
            try
            {
                transaccion.Rollback(); // Deshace los cambios de la transación
            }
            catch (Exception e)
            {
                throw;
            }
        }

        // Ejecuta sentencias SQL de tipo INSERT, UPDATE, DELETE
        public Boolean ejecutarUpdate(String sql)
        {
            abrirConexion();
            try
            {
                // Ejecuta la sentencia SQL
                comando = new MySqlCommand(sql, conexion);
                // Devuelve el número de filas afectadas
                // Devuelve true si afecto al menos una fila
                return comando.ExecuteNonQuery() > 0;
            }
            catch (Exception e)
            {
                throw;
            }
            finally // Siempre que se haya ejecutado algo, cierra la conexión
            {
                cerrarConexion();
            }
        }

        // Ejecuta sentencias SQL de tipo SELECT
        // Devuelve una lista de objetos con los datos obtenidos de la consulta SQL
        public List<Object> ejecutarConsulta(String sql, Object objeto)
        {
            abrirConexion(); // Abre la conexión
            List<Object> objetos = new List<object>(); // Crea la lista de objetos que se devolverá
            MySqlDataReader dataReader = null; // Objeto que lee los datos devueltos por la consulta SQL
            try
            { 
                comando = new MySqlCommand(sql, conexion); // Crea la sentencia SQL 
                dataReader = comando.ExecuteReader(); // Ejecuta la consulta y obtiene los resultados

                // Obtiene los nombres de las propiedades del objeto para el mapeo
                List<String> nombrePropiedades = Mapeo.ObtenerNombrePropiedades(objeto);

                // Recorre cada fila del resultado
                while (dataReader.Read())
                {
                    // Crea un objeto de 
                    Object obj = Activator.CreateInstance(objeto.GetType());
                    
                    // Se ejecuta todo el rato , hasta que se quede sin objetos
                    // y "nombre" va cambiando a "titulo", "autor", "paginas"... 
                    
                    // Se encarga de mapear cada columna a una propiedad
                    foreach (String nombre in nombrePropiedades)
                    {
                        // Obtiene el valor de la columna que se este ejecutando en ese momento
                        // Ejemplo Titulo="Juego de Tronos" , Codigo="cod001"
                        String valor = dataReader[nombre].ToString();
                        // Guarda en propiedad el tipo de variable que tiene que ser la variable de esa columna
                        PropertyInfo propiedad = obj.GetType().GetProperty(nombre);
                        // Modifica la variable por la asignada en la linea anterior 
                        propiedad.SetValue(obj, Convert.ChangeType(valor, propiedad.PropertyType), null);
                    }
                    objetos.Add(obj); // Añade el objeto a la lista
                }
                dataReader.Close(); // Cierra el DataReader
            }
            catch (Exception e)
            {
                throw;
            }
            finally
            {
                cerrarConexion();
            }
            return objetos; // Devuelve la lista de objetos con los datos obtenidos por la consulta SQL 
        }
    }
}
