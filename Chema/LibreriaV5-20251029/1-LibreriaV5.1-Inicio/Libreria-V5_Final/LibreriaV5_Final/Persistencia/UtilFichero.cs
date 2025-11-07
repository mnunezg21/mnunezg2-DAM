using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;

namespace LibreriaV5_Final.Comun
{
    //Gestionar el almacenamiento y cacheo de sentencias SQL en un archivo.
    public static class UtilFichero
    {
        private static string ruta = "sql.txt";
        private static Dictionary<string, string> SENTENCIAS;
        static BinaryFormatter serializer = new BinaryFormatter();


        //Se encarga de guardar el sql en el diccionario, con la clave valor
        public static string GuardarSQL(string orden, string sql)
        {
            //Guarda las sentencias ejecutadas en el diccionario
            SENTENCIAS.Add(orden, sql);
            return sql;
        }

        public static string ExisteSentencia(string orden)
        {
            String sentencia = null;
            //Si el diccionario contiene esa clave, la obtiene
            if (SENTENCIAS.ContainsKey(orden))
            {
                sentencia = SENTENCIAS[orden];
            }

            return sentencia;
        }

        public static void RellenarDictionarySentencias()
        {
            try
            {
                //Comprueba si el arhcivo binario existe o esta vacio 
                if (ComprobarArchivo() && File.ReadAllLines(ruta).Count() > 0)
                {
                    //using
                    //Abre el archivo en modo lectura
                    using (var stream = File.OpenRead(ruta))
                    {
                        //Convierte los bytes a un Dictionary<string, string>
                        SENTENCIAS = (Dictionary<string, string>)serializer.Deserialize(stream);
                        //Cierra el flujo de lectura
                        stream.Close();
                    }

                }
                else
                {
                    //Si no hay archivo o esta vacio crea un nuevo diccionario
                    SENTENCIAS = new Dictionary<string, string>();
                }
            }
            catch (Exception) { throw; }
        }

        //aqui
        public static void EscribirDictionarySentenciasFichero()
        {
            try
            {
                //Si el archivo existe y hay algo en el diccionario
                if (ComprobarArchivo() && SENTENCIAS != null)
                {
                    //Abre el archivo en modo lectura(sobrescribe)
                    using (var stream = File.OpenWrite(ruta))
                    {
                        //Serializa el diccionario (convierte el objeto en bytes)
                        serializer.Serialize(stream, SENTENCIAS);
                        stream.Close();//Cierra el flujo de escritura
                    }
                }
            }
            catch (Exception) { throw; }
        }

        //aqui
        private static bool ComprobarArchivo()
        {
            bool existe = false;
            // Si el arhcivo no existe en esa ruta
            if (!File.Exists(ruta))
            {
                try
                {
                    // Lo crea y lo cierra inmediatamente
                    File.Create(ruta).Close();
                    existe = true;
                }
                catch
                {
                    // Se deja esta línea para ver cómo se gestionarían los distintos
                    // errores en una clase Errores.
                    //Errores.controlError(new Errores(Errores.ERROR_FICHERO));
                    throw;
                }
            }
            return existe;
        }
    }
}
