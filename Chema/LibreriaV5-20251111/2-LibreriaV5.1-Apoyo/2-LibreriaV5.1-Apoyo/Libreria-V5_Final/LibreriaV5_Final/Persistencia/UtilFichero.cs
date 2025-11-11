using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;

namespace LibreriaV5_Final.Comun
{
    public static class UtilFichero
    {
        private static string ruta = "sql.txt";
        private static Dictionary<string, string> SENTENCIAS;
        static BinaryFormatter serializer = new BinaryFormatter();

        public static string GuardarSQL(string orden, string sql)
        {
            SENTENCIAS.Add(orden, sql);
            return sql;
        }

        public static string ExisteSentencia(string orden)
        {
            String sentencia = null;
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
                if (ComprobarArchivo() && File.ReadAllLines(ruta).Count() > 0)
                {
                    using (var stream = File.OpenRead(ruta))
                    {
                        SENTENCIAS = (Dictionary<string, string>)serializer.Deserialize(stream);
                        stream.Close();
                    }

                }
                else
                {
                    SENTENCIAS = new Dictionary<string, string>();
                }
            }
            catch (Exception) { throw; }
        }

        public static void EscribirDictionarySentenciasFichero()
        {
            try
            {
                if (ComprobarArchivo() && SENTENCIAS != null)
                {
                    using (var stream = File.OpenWrite(ruta))
                    {
                        serializer.Serialize(stream, SENTENCIAS);
                        stream.Close();
                    }
                }
            }
            catch (Exception) { throw; }
        }

        private static bool ComprobarArchivo()
        {
            bool existe = false;
            if (!File.Exists(ruta))
            {
                try
                {
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
