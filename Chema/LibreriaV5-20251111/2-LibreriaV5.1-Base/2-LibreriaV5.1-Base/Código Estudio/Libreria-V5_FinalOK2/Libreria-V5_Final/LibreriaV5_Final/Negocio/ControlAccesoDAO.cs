using LibreriaV5_Final.Persistencia;
using System;
using System.Collections.Generic;


namespace LibreriaV5_Final.Negocio
{
    public class ControlAccesoDAO<T> : IAcceso<T> where T : new()
    {
        AccesoDAO<T> accesoDAO = new AccesoDAO<T>();

        public bool BorradoVirtual(object objeto)
        {
            try
            {
                return accesoDAO.BorradoVirtual(objeto);
            }
            catch (Exception) { throw; }
        }

        public bool Borrar(object objeto)
        {
            try
            {
                return accesoDAO.Borrar(objeto);
            }
            catch (Exception) { throw; }
        }

        public object Buscar(Type clase, string nombre)
        {
            try
            {
                return accesoDAO.Buscar(clase, nombre);
            }
            catch (Exception) { throw; }
        }

        public List<object> Buscar(Type clase, string campo, string busqueda)
        {
            try
            {
                return accesoDAO.Buscar(clase, campo, busqueda);
            }
            catch (Exception) { throw; }
        }

        public bool Insertar(T objeto)
        {
            try
            {
                return accesoDAO.Insertar(objeto);
            }
            catch (Exception) { throw; }
        }

        public bool Modificar(string clavePrimaria, T objeto)
        {
            try
            {
                return accesoDAO.Modificar(clavePrimaria, objeto);
            }
            catch (Exception) { throw; }
        }

        public List<object> BuscarTodo(Type clase)
        {
            try
            {
                return accesoDAO.BuscarTodo(clase);
                //return ((IAcceso<T>)accesoDAO).BuscarTodo(clase);
            }
            catch (Exception) { throw; }
        }

        public void CerrarConexion()
        {
            accesoDAO.CloseConnection();
        }
    }
}
