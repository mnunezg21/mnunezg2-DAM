using LibreriaV5_Final.Comun;
using LibreriaV5_Final.Persistencia;
using System;
using System.Windows.Forms;

namespace LibreriaV5_Final.Vista
{
    public partial class FrmPrincipal : Form
    {
        public FrmPrincipal()
        {
            InitializeComponent();
            try { 
            UtilFichero.RellenarDictionarySentencias();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        //TODO: Todas las excepciones al formulario
        private void LibrosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Cuadro().ShowDialog(this);
        }


        private void ClientesToolStripMenuItem_Click(object sender, EventArgs e)
        {

            //new FrmClientes().ShowDialog(this);
            
        }

        private void Principal_FormClosed(object sender, FormClosedEventArgs e)
        {
            try
            {
                UtilFichero.EscribirDictionarySentenciasFichero();
                AccesoBD.Conexion.CerrarConexion();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void FrmPrincipal_Load(object sender, EventArgs e)
        {

        }
    }
}
