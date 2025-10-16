using LibreriaV2.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibreriaV2.Datos
{
    // Esta clase se encarga de guardar todas las Sentencias SQL
    class UtilSQL
    {
        public static String sqlInsertarLibro(TLibro obLibro)
        {
            return "INSERT INTO `tlibro`(`titulo`, `autor`, `tema`, `paginas`,`precio`, `formatouno`, `formatodos`, `formatotres`, `estado`) VALUES ('"
                    + obLibro.Titulo + "' , '" + obLibro.Autor + "' , '" + obLibro.Tema + "' , '"
                    + obLibro.Paginas + "' , '" + obLibro.Precio + "' , '" + obLibro.Formatouno + "' , '" + obLibro.Formatodos + "' , '"
                    + obLibro.Formatotres + "' , '" + obLibro.Estado + "')";
        }

        public static String sqlBorrarLibro(String nombre)
        {
            return "DELETE FROM `tlibro` WHERE `titulo` = '" + nombre + "'";
        }

        public static String sqlBuscarLibro(String nombre)
        {
            return "SELECT * FROM `tlibro` WHERE `titulo` = '"
                    + nombre + "'";
        }

        public static String sqlObtenerLibros()
        {
            return "SELECT * FROM tlibro";

        }

        public static String sqlModificarLibro(TLibro obLibro)
        {
            return "UPDATE `tlibro` SET `titulo`= '" + obLibro.Titulo + "' ,`autor`= '" + obLibro.Autor
                    + "' ,`tema`= '" + obLibro.Tema + "' ,`paginas`= '" + obLibro.Paginas + "' ,`precio`= '" + obLibro.Precio + "' ,`formatouno`= '"
                    + obLibro.Formatouno + "' ,`formatodos`= '" + obLibro.Formatodos + "' ,`formatotres`= '"
                    + obLibro.Formatotres + "' ,`estado`= '" + obLibro.Estado + "'  WHERE `titulo` = '"
                    + obLibro.Titulo + "'";
        }
    }
}
