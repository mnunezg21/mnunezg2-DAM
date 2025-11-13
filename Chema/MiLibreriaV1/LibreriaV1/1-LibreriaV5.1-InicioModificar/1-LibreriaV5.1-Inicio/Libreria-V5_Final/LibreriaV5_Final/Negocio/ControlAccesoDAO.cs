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
                return ((IAcceso<T>)accesoDAO).BorradoVirtual(objeto);
            }
            catch (Exception) { throw; }
        }

        public bool Borrar(object objeto)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).Borrar(objeto);
            }
            catch (Exception) { throw; }
        }

        public object BuscarOne(Type clase, string nombre)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).BuscarOne(clase, nombre);
            }
            catch (Exception) { throw; }
        }

        public List<object> Buscar(Type clase, string campo, string busqueda)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).Buscar(clase, campo, busqueda);
            }
            catch (Exception) { throw; }
        }

        public bool Insertar(T objeto)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).Insertar(objeto);
            }
            catch (Exception) { throw; }
        }

        public bool Modificar(T objeto)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).Modificar(objeto);
            }
            catch (Exception) { throw; }
        }

        public List<object> BuscarAll(Type clase)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).BuscarAll(clase);
            }
            catch (Exception) { throw; }
        }
    }
}
