using LibreriaV5_Final.Modelo;
using LibreriaV5_Final.Negocio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LibreriaV5_Final.Vista
{
    public partial class FrmCliente : Form
    {
        public FrmCliente()
        {
            InitializeComponent();
        }
        private void buttonNuevo_Click(object sender, EventArgs e)
        {

        }

        private void buttonAlta_Click(object sender, EventArgs e)
        {

        }

        private void buttonBaja_Click(object sender, EventArgs e)
        {

        }

        private void buttonModificar_Click(object sender, EventArgs e)
        {

        }

        private void buttonSalir_Click(object sender, EventArgs e)
        {

        }

        private void listClientes_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        // METODOS PRIVADOS
        private TCliente RecogerDatosPantalla()
        {
            TCliente cliente = null;
            string codCliente, nombre, apellidos, email, telefono, direccion;
            nombre = textNombre.Text;
            apellidos = textApellidos.Text;
            email = textEmail.Text;
            telefono = textTelefono.Text;
            direccion = textDireccion.Text;

            if (nombre.Count() != 0 && apellidos.Count() != 0 && email.Count() != 0 && telefono.Count() != 0 && direccion.Count() != 0)
            {
                if (((TCliente)listClientes.SelectedItem) == null)
                    cliente = new TCliente(nombre, apellidos, email, telefono, direccion);
                else
                {
                    codCliente = ((TLibro)lstLibros.SelectedItem).CodLibro;
                    libro = new TLibro(codCliente, apellidos, nombre, tema, email, telefono, formatoUno, formatoDos, formatoTres, estado);
                }
            }
            return libro;
        }

        private void ObtenerTodosLibros()
        {
            try
            {
                List<object> libros = new List<object>();
                foreach (TLibro item in control.Obtener(new TLibro().GetType()))
                {
                    if (item.Borrado.Equals("0"))
                    {
                        lstLibros.Items.Add(item);
                    }
                }
                lstLibros.ClearSelected();
                VaciarPantalla();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void ObtenerTemas()
        {
            try
            {
                foreach (TTema item in control.Obtener(new TTema().GetType()))
                {
                    cbxTemas.Items.Add(item.Tema);
                }
                cbxTemas.SelectedIndex = 0;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void VaciarPantalla()
        {
            txtAutor.Text = "";
            //txtMensaje.Text = "";
            txtPaginas.Text = "";
            txtPrecio.Text = "";
            txtTitulo.Text = "";
            rbReedicion.Checked = false;
            chkCartone.Checked = false;
            chkRustica.Checked = false;
            chkTapaDura.Checked = false;
            cbxTemas.SelectedIndex = 0;
        }

        private void RellenarCampos(TLibro sender)
        {
            textNombre.Text = sender.Autor;
            textApellidos.Text = sender.apellidos;
            textDni.Text = sender.Dni;
            textEmail.Text = sender.Titulo;
            textDireccion.Text = sender.Direccion;
            
        }



















        private void textNombre_TextChanged(object sender, EventArgs e)
        {
        }

        private void FrmCliente_Load(object sender, EventArgs e)
        {

        }
    }
}
