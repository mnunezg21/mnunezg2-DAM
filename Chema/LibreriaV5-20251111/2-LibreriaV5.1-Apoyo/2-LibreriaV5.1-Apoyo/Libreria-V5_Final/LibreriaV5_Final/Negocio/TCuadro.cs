using LibreriaV5_Final.Persistencia;

namespace LibreriaV5_Final.Modelo
{
    public class TCuadro
    {
        public string CodCuadro { get; set; }
        public string Nombre { get; set; }
        public string Pintor { get; set; }
        public string Borrado { get; set; }

        public TCuadro(string codcuadro, string nombre, string pintor)
        {
            this.CodCuadro = codcuadro;
            this.Nombre = nombre;
            this.Pintor = pintor;

        }
        public TCuadro(string nombre, string pintor)
        {   
            this.CodCuadro =UtilSQL.GenerarCodigo(this.GetType());
            this.Nombre = nombre;
            this.Pintor = pintor;
            this.Borrado = "0";
        }
        public TCuadro() { }

        public override string ToString()
        {
            return CodCuadro+": " +Nombre.ToUpper();
        }

    }

    

}
