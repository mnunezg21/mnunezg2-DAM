using LibreriaV3._1.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PracticaCRUD.BBDD
{
    class UtilSQL
    {

        public static string sqlInsertar(TLibro libro)
        {
            return string.Format("INSERT INTO tlibro(Autor, Titulo, Tema, Paginas, Precio, Formatouno, Formatodos, Formatotres, Estado) VALUES ('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}')",libro.Autor,libro.Titulo,libro.Tema,libro.Paginas,libro.Precio,libro.Formatouno,libro.Formatodos,libro.Formatotres,libro.Estado);
        }

        public static string sqlBorrar(TLibro libro)
        {

            return "DELETE FROM tlibro WHERE CodLibro = " + libro.CodLibro;
        }

        public static string sqlModificar(int id, TLibro libro)
        {
            return string.Format("UPDATE tlibro SET Autor='{0}',Titulo='{1}',Tema='{2}',Paginas='{3}',Precio='{4}',Formatouno='{5}',Formatodos='{6}',Formatotres='{7}',Estado='{8}' WHERE CodLibro = {9}", libro.Autor, libro.Titulo, libro.Tema, libro.Paginas, libro.Precio, libro.Formatouno, libro.Formatodos, libro.Formatotres, libro.Estado,id);
        }


        public static string sqlLeer()
        {
            return "SELECT * FROM tlibro";
        }

        public static String sqlBuscarLibro(String nombre)
        {
            return "SELECT * FROM `tlibro` WHERE `titulo` = '"
                    + nombre + "'";
        }


    }
}
