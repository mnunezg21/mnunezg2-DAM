using LibreriaV5_Final.Comun;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;

namespace LibreriaV5_Final.Persistencia
{
    //Instanciar un objeto generico 
    public class AccesoDAO<T> : AccesoBD, IAcceso<T> where T : new()
    {
        public bool BorradoVirtual(object objeto)
        {
            bool borrado = false;
            string sql;
            PropertyInfo[] properties = UtilSQL.ObtenerPropiedades(objeto.GetType());

            properties[properties.Length - 1].SetValue(objeto, "1");

            try 
            {
                if ((sql = UtilFichero.ExisteSentencia("BORRADOVIRTUAL" + objeto.GetType().Name)) == null) 
                {
                    sql = UtilFichero.GuardarSQL("BORRADOVIRTUAL" + objeto.GetType().Name, UtilSQL.SqlModificar(objeto));
                }

                if (EjecutarUpdate(sql, objeto))
                {
                    borrado = true;
                }
            } catch (Exception) { throw; }
            return borrado;
        }

        // 
        public bool Borrar(object objeto)
        {
            bool borrado = false;
            string sql;
            try 
            {
                if ((sql = UtilFichero.ExisteSentencia("DELETE" + objeto.GetType().Name)) == null)
                {
                    sql = UtilFichero.GuardarSQL("DELETE" + objeto.GetType().Name, UtilSQL.SqlBorrar(objeto));

                }
                if (EjecutarUpdate(sql, objeto))
                {
                    Commit();
                    borrado = true;
                }
            } catch (Exception) { RollBack(); throw; }
            return borrado;
        }

        //Se encarga de buscar el objeto completo segun el tipo de clase que se le introduzca
        public object BuscarOne(Type clase, string nombre)
        {
            List<object> list = null;
            Object obj=null;
            String sql;
            try
            {
                // Si la orden SQL no existe se guarda en un Dictionary, que al terminar
                // el programa guardará todas las órdenes en el fichero sql.txt
                //Comprueba si no existe la sentencia y si no existe la guarda
                if ((sql = UtilFichero.ExisteSentencia("SELECTONE" + clase.Name)) == null)
                {
                    //De esta forma se puede ver mejor la construcción de la orden SQL.
                    //Guarda la sentencia con SELECTONE del nombre de la clase con una sentencia
                    sql = UtilFichero.GuardarSQL("SELECTONE" + clase.Name, UtilSQL.SqlBuscar(clase));    
                }
                //if ((list = EjecutarConsulta(sql, clase, nombre)).Count != 0)
                //Si la lista que se rellena con el ejecutarConsulta contiene algo, se ejecuta3  
                if ((list=EjecutarConsulta(sql, clase, nombre)).Count != 0)
                    {
                    //Obtiene el primer objeto de la lista                                              
                     obj = list.First();
                    }                
            }
            catch (Exception) { throw; }
            return obj;
        }

        
        public List<object> Buscar(Type clase, string campo, string busqueda)
        {
            String sql = "SELECT * FROM " + clase.Name + " WHERE " + campo + " = \"" + busqueda + "\"";
            try
            {
                return EjecutarConsulta(sql, clase, "");
            }
            catch (Exception) { throw; }
        }

        //
       public bool Insertar(T objeto)
        {
            bool insertado = false;

            string sql;

                try
                {

                if ((sql = UtilFichero.ExisteSentencia("INSERTAR" + objeto.GetType().Name)) == null)
                {
                    sql = UtilFichero.GuardarSQL("INSERTAR" + objeto.GetType().Name, UtilSQL.SqlInsertar(objeto));         
                }

                if (EjecutarUpdate(sql, objeto))
                {
                    insertado = true;
                }

            }
                catch (Exception) {  throw; }
            
            return insertado;
        }
  
        //
        public bool Modificar(T objeto)
        {
            bool modificado = false;
            string sql;
                try
                {
                    if ((sql = UtilFichero.ExisteSentencia("UPDATE" + objeto.GetType().Name)) == null) 
                    {
                        sql = UtilFichero.GuardarSQL("UPDATE" + objeto.GetType().Name, UtilSQL.SqlModificar(objeto));
                    }

                    if (EjecutarUpdate(sql, objeto))
                    {
                        Commit();
                        modificado = true;
                    }
                }
                catch (Exception) { throw; }
            return modificado;
        }

        public List<Object> BuscarAll(Type clase)
        {
            List<Object> obj = null;
            string sql;
            //
            try 
            {
                if ((sql = UtilFichero.ExisteSentencia("SELECTALL" + clase.Name)) == null)
                {
                    obj = EjecutarConsulta(UtilFichero.GuardarSQL("SELECTALL" + clase.Name, UtilSQL.SqlObtener(clase)), clase, "");
                    
                }
                else
                {
                    obj = EjecutarConsulta(sql, clase, "");
                }
            }
            catch (Exception) { throw; }
            return obj;
        }
    }
}
