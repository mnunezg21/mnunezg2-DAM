using LibreriaV2.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibreriaV2.Datos
{
  public class AccesoLibro : AccesoBD , IAcceso<TLibro> {

	public Boolean insertarLibro(TLibro obLibro) {
		try {
			return ejecutarUpdate(UtilSQL.sqlInsertarLibro(obLibro));
		} catch (Exception e) {
                throw;
		}

	}
	public Boolean borrarLibro(TLibro oblibro) {
		try {
			return ejecutarUpdate(UtilSQL.sqlBorrarLibro(oblibro.Titulo));
		} catch (Exception e) {
			    throw;
		}
	}

    public object buscarLibro(string nombre) {

        try { 
            // El método First nos devuelve el primer objeto de la colección.
             return ejecutarConsulta(UtilSQL.sqlBuscarLibro(nombre), new TLibro()).First();
        } catch (Exception e) {
                throw;
        }
    }

    public List<object> obtenerLibros() {

         try{
             return ejecutarConsulta(UtilSQL.sqlObtenerLibros(), new TLibro());
         }catch (Exception e){
               throw;
            }
        }


	public Boolean modificarLibro(TLibro obLibro) {
        try {
             return ejecutarUpdate(UtilSQL.sqlModificarLibro(obLibro));
        }catch (Exception e){
                throw;
        }
	}

    //*********************************************************************************************************************
    //                                                MONTAJE SQL
    //   Todas estas SQL las traladaremos a la clase UtilSQL. También las dejaremos en la clase Estanteria para que el 
    //   alumno compruebe la modificación realizada. Estos métodos en la clase UtilSQL pasan a ser STATIC para poder acceder
    //   sin la necesidad de crear un objeto de la clase UtilSQL.
    //*********************************************************************************************************************
	/*private  String sqlInsertarLibro(TLibro obLibro) {
		return "INSERT INTO `tlibro`(`titulo`, `autor`, `tema`, `paginas`, `formatouno`, `formatodos`, `formatotres`, `estado`) VALUES ('"
				+ obLibro.Titulo + "' , '" + obLibro.Autor + "' , '" + obLibro.Tema + "' , '"
				+ obLibro.Paginas + "' , '" + obLibro.Formatouno + "' , '" + obLibro.Formatodos + "' , '"
				+ obLibro.Formatotres + "' , '" + obLibro.Estado + "')";
	}

	private String sqlBorrarLibro(String nombre) {
		return "DELETE FROM `tlibro` WHERE `titulo` = '" + nombre + "'";
	}

	private String sqlBuscarLibro(String nombre) {
            //return "SELECT `titulo`, `autor`, `tema`, `paginas`, `formatouno`, `formatodos`, `formatotres`, `estado` FROM `tlibro` WHERE `titulo` = '"
            //		+ nombre + "'";
        return "SELECT * FROM `tlibro` WHERE `titulo` = '"
        		+ nombre + "'";
        }

        private  String sqlObtenerLibros() {
            //return "SELECT `titulo`, `autor`, `tema`, `paginas`, `formatouno`, `formatodos`, `formatotres`, `estado` FROM `tlibro` ";
           return "SELECT * FROM tlibro";

    }

	private String sqlModificarLibro(TLibro obLibro) {
		return "UPDATE `tlibro` SET `titulo`= '" + obLibro.Titulo + "' ,`autor`= '" + obLibro.Autor
				+ "' ,`tema`= '" + obLibro.Tema + "' ,`paginas`= '" + obLibro.Paginas + "' ,`formatouno`= '"
				+ obLibro.Formatouno + "' ,`formatodos`= '" + obLibro.Formatodos + "' ,`formatotres`= '"
				+ obLibro.Formatotres + "' ,`estado`= '" + obLibro.Estado + "'  WHERE `titulo` = '"
				+ obLibro.Titulo + "'";
	}*/

  }   
}
