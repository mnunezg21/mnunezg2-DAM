using LibreriaV2.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibreriaV2.Datos
{
    // Hereda los metodos de AccesoBD y IAcceso
  public class AccesoLibro : AccesoBD , IAcceso<TLibro> {

        // Se encarga pasar sql al ejecutar el Update y devolver a la base de datos el sql 
	public Boolean insertarLibro(TLibro obLibro) {
		try {
			return ejecutarUpdate(UtilSQL.sqlInsertarLibro(obLibro));
		} catch (Exception e) {
                throw;
		}

	}

        // Se encarga de hacer el DELETE y borrar esa informacion de la base de datos 
	public Boolean borrarLibro(TLibro oblibro) {
		try {
			return ejecutarUpdate(UtilSQL.sqlBorrarLibro(oblibro.Titulo));
		} catch (Exception e) {
			    throw;
		}
	}

        // Se encarga de hacer el Select y buscar el libro segun el nombre y devolverlo a la pantallaPrincipal
    public object buscarLibro(string nombre) {

        try { 
            // El método First nos devuelve el primer objeto de la colección.
             return ejecutarConsulta(UtilSQL.sqlBuscarLibro(nombre), new TLibro()).First();
        } catch (Exception e) {
                throw;
        }
    }

        // Se encarga de hacer todo el Select y meterlo dentro de la Lista Libros
    public List<object> obtenerLibros() {

         try{
             return ejecutarConsulta(UtilSQL.sqlObtenerLibros(), new TLibro());
         }catch (Exception e){
               throw;
            }
        }

        // Se encarga de modificar el libro seleccionado
	public Boolean modificarLibro(TLibro obLibro) {
        try {
             return ejecutarUpdate(UtilSQL.sqlModificarLibro(obLibro));
        }catch (Exception e){
                throw;
        }
	}
  }   
}
