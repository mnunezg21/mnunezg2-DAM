using LibreriaV5_Final.Comun;
using LibreriaV5_Final.Modelo;
using LibreriaV5_Final.Negocio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace LibreriaV5_Final
{ 
    public partial class Libro : Form
    {
        private ControlAccesoDAO<object> control = new ControlAccesoDAO<object>();

        public Libro()
        {
            InitializeComponent();
            ObtenerTemas();
            ObtenerTodosLibros();
        }

        private void BtnNuevo_Click(object sender, EventArgs e)
        {
            VaciarPantalla();
        }

        private void BtnAlta_Click(object sender, EventArgs e)
        {
            TLibro libro;
            try
            {
                if ((libro = RecogerDatosPantalla()) == null)
                {
                    MessageBox.Show(Mensajes.MSG_CAMPOSVACIOS);
                }
                else
                {
                    if (control.Buscar(libro.GetType(), libro.CodLibro) != null)
                    {
                        txtMensaje.Text = Mensajes.MSG_YAEXISTE_LIBRO;
                    }
                    else
                    {
                        control.Insertar(libro);
                        lstLibros.Items.Add(libro);
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
                TLibro libro = RecogerDatosPantalla();
                if (libro != null)
                {
                    libro.Borrado = ((TLibro)lstLibros.SelectedItem).Borrado;
                    if (control.Modificar(libro))
                    {
                        lstLibros.Items.Remove(lstLibros.SelectedItem);
                        lstLibros.Items.Add(libro);
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
                RellenarCampos((TLibro)lstLibros.SelectedItem);
            }
        }
       
        private void TxtPaginas_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar))
            {
                e.Handled = true;
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

        private TLibro RecogerDatosPantalla()
        {
            TLibro libro = null;
            string codLibro,titulo, autor, paginas, precio, formatoUno, formatoDos, formatoTres, estado, tema;
            titulo = txtTitulo.Text;
            autor = txtAutor.Text;
            paginas = txtPaginas.Text;
            precio = txtPrecio.Text.Replace(".", ",");
            precio = precio.Replace("€", "");
            precio = precio.Trim();
            formatoUno = chkCartone.Checked ? chkCartone.Text : "N/A";
            formatoDos = chkRustica.Checked ? chkRustica.Text : "N/A";
            formatoTres = chkTapaDura.Checked ? chkTapaDura.Text : "N/A";
            tema = cbxTemas.SelectedItem.ToString();
            if (rbNovedad.Checked)
            {
                estado = "novedad";
            }
            else
            {
                estado = "reedicion";
            }

            if (titulo.Count() != 0 && paginas.Count() != 0 && titulo.Count() != 0 && precio.Count() != 0)
            {
                if (((TLibro)lstLibros.SelectedItem) == null)
                    libro = new TLibro(autor, titulo, tema, paginas, precio, formatoUno, formatoDos, formatoTres, estado);
                else
                {
                    codLibro = ((TLibro)lstLibros.SelectedItem).CodLibro;
                    libro = new TLibro(codLibro, autor, titulo, tema, paginas, precio, formatoUno, formatoDos, formatoTres, estado);
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
            txtAutor.Text = sender.Autor;
            txtPaginas.Text = sender.Paginas;
            txtPrecio.Text = sender.Precio + " €";
            txtTitulo.Text = sender.Titulo;
            cbxTemas.Text = sender.Tema;
            if (sender.Estado.Equals("reedicion"))
            {
                rbReedicion.Checked = true;
                rbNovedad.Checked = false;
            }
            else
            {
                rbNovedad.Checked = true;
                rbReedicion.Checked = false;
            }

            chkCartone.Checked = sender.Formatouno.Equals("Cartoné") ? true : false;
            chkRustica.Checked = sender.Formatodos.Equals("Rústica") ? true : false; ;
            chkTapaDura.Checked = sender.Formatotres.Equals("Tapa dura") ? true : false; ;
        }
    }
}
