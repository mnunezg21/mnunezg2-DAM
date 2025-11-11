using LibreriaV5_Final.Comun;
using System;
using System.Collections.Generic;
using System.Linq;

namespace LibreriaV5_Final.Persistencia
{
    //Instanciar un objeto generico 
    public class AccesoDAO<T> : AccesoBD, IAcceso<T> where T : new()
    {

        //aqui 
        public bool BorradoVirtual(object objeto)
        {
            bool borrado = false;
            StartTransaction();
            string sql;
            //Recore las propiedades del objeto, 
            foreach (var item in objeto.GetType().GetProperties())
            {
                if (item.Name.Contains("Borra"))//Si la propiedad contiene "Borra"
                {
                    item.SetValue(objeto, "1");//Marca el objeto como borrado
                }
            }//Si la sentencia sql BorrradoVirtual existe
            if ((sql = UtilFichero.ExisteSentencia("BORRADOVIRTUAL" + objeto.GetType().Name)) == null)
            {
                try
                {   // Ejecuta el update con el Borrado Virtual actualizado
                    // Guarda el sql de Borrado en el diccionario                                          // crea el update con la clave 
                    if (EjecutarUpdate(UtilFichero.GuardarSQL("BORRADOVIRTUAL" + objeto.GetType().Name, UtilSQL.SqlModificar(objeto)), objeto))
                    {
                        Commit();
                        borrado = true;
                    }
                }
                catch (Exception) { RollBack(); throw; }
            }
            else
            {
                try
                {//Si exitia el sql en el diccionario, ejecuta ese sql
                    if (EjecutarUpdate(sql, objeto))
                    {
                        Commit();
                        borrado = true;
                    }
                }
                catch (Exception) { RollBack(); throw; }
            }

            return borrado;
        }

        // 
        public bool Borrar(object objeto)
        {
            bool borrado = false;
            //Inicia la transaccion
            StartTransaction();
            string sql;
            //Si la sentencia sql DELETE existe 
            if ((sql = UtilFichero.ExisteSentencia("DELETE" + objeto.GetType().Name)) == null)
            {
                try
                { //
                    if (EjecutarUpdate(UtilFichero.GuardarSQL("DELETE" + objeto.GetType().Name, UtilSQL.SqlBorrar(objeto)), objeto))
                    {
                        Commit();// realiza el commit del sql
                        borrado = true;
                    }
                }
                catch (Exception) { RollBack(); throw; }
            }
            else
            {
                try
                { //Ejecuta la sentencia sql si ya estaba guardado en el diccionario
                    if (EjecutarUpdate(sql, objeto))
                    {
                        Commit();
                        borrado = true;
                    }
                }
                catch (Exception) { RollBack(); throw; }
            }

            return borrado;
        }

        //Se encarga de buscar el objeto completo segun el tipo de clase que se le introduzca
        public object Buscar(Type clase, string nombre)
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

        //
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

            StartTransaction();
            string sql;
            if ((sql = UtilFichero.ExisteSentencia("INSERTAR" + objeto.GetType().Name)) == null)
            {
                try
                {
                    if (EjecutarUpdate(UtilFichero.GuardarSQL("INSERTAR" + objeto.GetType().Name, UtilSQL.SqlInsertar(objeto)), objeto))
                    {
                        Commit();
                        insertado = true;
                    }
                }
                catch (Exception) { RollBack(); throw; }
            }
            else
            {
                try
                {
                    if (EjecutarUpdate(sql, objeto))
                    {
                        Commit();
                        insertado = true;
                    }
                }
                catch (Exception) { RollBack(); throw; }
            }
            return insertado;

        }
  
        //
        public bool Modificar(T objeto)
        {
            bool modificado = false;
            StartTransaction();
            string sql;
            //
            if ((sql = UtilFichero.ExisteSentencia("UPDATE" + objeto.GetType().Name)) == null)
            {
                try
                {//
                    if (EjecutarUpdate(UtilFichero.GuardarSQL("UPDATE" + objeto.GetType().Name, UtilSQL.SqlModificar(objeto)), objeto))
                    {
                        Commit();
                        modificado = true;
                    }
                }
                catch (Exception) { RollBack(); throw; }
            }
            else
            {
                try
                {//
                    if (EjecutarUpdate(sql, objeto))
                    {
                        Commit();
                        modificado = true;
                    }
                }
                catch (Exception) { RollBack(); throw; }
            }

            return modificado;
        }

        //
        public List<Object> Obtener(Type clase)
        {
            List<Object> obj = null;
            string sql;
            //
            if ((sql = UtilFichero.ExisteSentencia("SELECTALL" + clase.Name)) == null)
            {
                try
                {//
                    obj = EjecutarConsulta(UtilFichero.GuardarSQL("SELECTALL" + clase.Name, UtilSQL.SqlObtener(clase)), clase, "");
                }
                catch (Exception) { throw; }
            }
            else
            {
                try
                {//
                    obj = EjecutarConsulta(sql, clase, "");
                }
                catch (Exception) { throw; }
            }

            return obj;

        }
    }
}
