using LibreriaV2.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibreriaV2.Datos
{
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
        //**************************************************************************************************************
        // Estas SQL no se utilizarán en la aplicación, pero se tienen como documentación por si es necesario usar su
        // sintaxis.
        //**************************************************************************************************************
        /*public static string sqlInsertar(TLibro libro)
        {
            return string.Format("INSERT INTO tlibro(Autor, Titulo, Tema, Paginas, Precio, Formatouno, Formatodos, Formatotres, Estado) VALUES ('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}')",libro.Autor,libro.Titulo,libro.Tema,libro.Paginas,libro.Precio,libro.Formatouno,libro.Formatodos,libro.Formatotres,libro.Estado);
        }

        public static string sqlBorrar(TLibro libro)
        {

            return "DELETE FROM tlibro WHERE Autor = " + "'"+libro.Autor+"'";
        }

        public static string sqlModificar(int id, TLibro libro)
        {
            return string.Format("UPDATE tlibro SET Autor='{0}',Titulo='{1}',Tema='{2}',Paginas='{3}',Precio='{4}',Formatouno='{5}',Formatodos='{6}',Formatotres='{7}',Estado='{8}' WHERE CodLibro = {9}", libro.Autor, libro.Titulo, libro.Tema, libro.Paginas, libro.Precio, libro.Formatouno, libro.Formatodos, libro.Formatotres, libro.Estado,id);
        }


        public static string sqlLeer()
        {
            return "SELECT * FROM tlibro";
        }*/


    }
}
