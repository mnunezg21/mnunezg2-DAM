using LibreriaV5_Final.Comun;
using LibreriaV5_Final.Modelo;
using LibreriaV5_Final.Negocio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace LibreriaV5_Final
{ 
    public partial class Cuadro : Form
    {
        private ControlAccesoDAO<object> control = new ControlAccesoDAO<object>();

        public Cuadro()
        {
            InitializeComponent();
            ObtenerTodosLibros();
        }

        private void BtnNuevo_Click(object sender, EventArgs e)
        {
            VaciarPantalla();
        }

        private void BtnAlta_Click(object sender, EventArgs e)
        {
            TCuadro cuadro;
            try
            {
                if ((cuadro = RecogerDatosPantalla()) == null)
                {
                    MessageBox.Show(Mensajes.MSG_CAMPOSVACIOS);
                }
                else
                {
                    if (control.Buscar(cuadro.GetType(), cuadro.CodCuadro) != null)
                    {
                        txtMensaje.Text = Mensajes.MSG_YAEXISTE_LIBRO;
                    }
                    else
                    {
                        control.Insertar(cuadro);
                        lstLibros.Items.Add(cuadro);
                        txtMensaje.Text = Mensajes.MSG_INSERTADO_LIBRO;
                    }
                }
                lstLibros.ClearSelected();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void BtnBaja_Click(object sender, EventArgs e)
        {
            try
            {
                if (lstLibros.SelectedItem != null)
                {
                    var result = MessageBox.Show(Mensajes.MSG_PREGUNTA_BORRAR, Mensajes.MSG_ATENCION, MessageBoxButtons.YesNoCancel, MessageBoxIcon.Asterisk);
                    //Borrado virtual
                    if (result == DialogResult.Yes)
                    {
                        if (control.BorradoVirtual(lstLibros.SelectedItem))
                        {
                            txtMensaje.Text = Mensajes.MSG_BORRADO_VIRTUAL;
                            lstLibros.Items.Remove(lstLibros.SelectedItem);
                        }
                    }
                    else if (result == DialogResult.No)
                    {
                        if (control.Borrar(lstLibros.SelectedItem))
                        {
                            txtMensaje.Text = Mensajes.MSG_BORRADO_LIBRO;
                            lstLibros.Items.Remove(lstLibros.SelectedItem);
                        }
                    }
                }
                else
                {
                    MessageBox.Show(Mensajes.MSG_SELECCIONAR_LIBRO);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void BtnModificar_Click(object sender, EventArgs e)
        {
            try
            {
                TCuadro cuadro = RecogerDatosPantalla();
                if (cuadro != null)
                {
                    cuadro.Borrado = ((TCuadro)lstLibros.SelectedItem).Borrado;
                    if (control.Modificar(cuadro))
                    {
                        lstLibros.Items.Remove(lstLibros.SelectedItem);
                        lstLibros.Items.Add(cuadro);
                        txtMensaje.Text = Mensajes.MSG_MODIFICADO_LIBRO;
                        VaciarPantalla();
                    }
                }
                else
                {
                    MessageBox.Show(Mensajes.MSG_CAMPOSVACIOS);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void BtnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void LstLibros_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lstLibros.SelectedItem != null)
            {
                RellenarCampos((TCuadro)lstLibros.SelectedItem);
            }
        }
       

        private void TxtPrecio_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) &&
                (e.KeyChar != '.') && (e.KeyChar != ','))
            {
                e.Handled = true;
            }

            // only allow one decimal point
            if ((e.KeyChar == '.') && ((sender as TextBox).Text.IndexOf('.') > -1))
            {
                e.Handled = true;
            }
            if ((e.KeyChar == ',') && ((sender as TextBox).Text.IndexOf(',') > -1))
            {
                e.Handled = true;
            }
        }

       

        //------------------------METODOS PRIVADOS de la clase FrmLibro---------------------//

        private TCuadro RecogerDatosPantalla()
        {
            TCuadro cuadro = null;
            string codCuadro,nombre,pintor;
            nombre = txtTitulo.Text;
            pintor = txtAutor.Text;
        

            if (nombre.Count() != 0 && pintor.Count() != 0 )
            {
                if (((TCuadro)lstLibros.SelectedItem) == null)
                    cuadro = new TCuadro(nombre,pintor);
                else
                {
                    codCuadro = ((TCuadro)lstLibros.SelectedItem).CodCuadro;
                    cuadro = new TCuadro(codCuadro,nombre,pintor);
                }
            }
            return cuadro;
        }

        private void ObtenerTodosLibros()
        {
            try
            {
                List<object> libros = new List<object>();
                foreach (TCuadro item in control.Obtener(new TCuadro().GetType()))
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


        private void VaciarPantalla()
        {
            txtAutor.Text = "";
            //txtMensaje.Text = "";
            txtTitulo.Text = "";
        }

        private void RellenarCampos(TCuadro sender)
        {
            txtAutor.Text = sender.Pintor;
      
            txtTitulo.Text = sender.Nombre;
        }

        private void Libro_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void txtTitulo_TextChanged(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void txtAutor_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
