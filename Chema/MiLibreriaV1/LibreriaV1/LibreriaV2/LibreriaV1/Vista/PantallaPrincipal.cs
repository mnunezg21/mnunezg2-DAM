using LibreriaV3._1.Modelo;
using System;
using System.Linq;
using System.Windows.Forms;

namespace LibreriaV3._1
{
    public partial class PantallaPrincipal : Form
    {
        private Estanteria acceso = new Estanteria();

        public PantallaPrincipal()
        {
              InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            MessageBox.Show("Holaaaaaaaaaaaaaaaaaaa");
        }
        
        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
        }
        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
        }
        private void btnNuevo_Click(object sender, EventArgs e)
        {
            VaciarPantalla();
        }

        private void BtnAlta_Click(object sender, EventArgs e)
        {
            Boolean estado = false;
            estado = acceso.insertarLibro(RecogerDatosPantalla());
            if (estado)
            {
                lstLibros.Items.Add(txtTitulo.Text);
                lblMensaje.Text = "Libro Creado Correctamente";
                MessageBox.Show("Libro Creado Correctamente");
            }
            else
            {
                lblMensaje.Text = "No se ha podido añadir el libro";
                MessageBox.Show("No se ha podido añadir el libro");

            }
        }
        
        private void btnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void lstLibros_Click(object sender, EventArgs e)
        {
            EnviarDatosAPantalla(acceso.buscarLibro(lstLibros.SelectedItem.ToString()));
                    
        }
           
        private void btnBaja_Click(object sender, EventArgs e)
        {
            acceso.borrarLibro(RecogerDatosPantalla());
            lstLibros.Items.Remove(lstLibros.SelectedItem.ToString()); 
            VaciarPantalla();                    
        }
        
        private void txtPaginas_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar))
            {
                e.Handled = true;
            }
        }

        private void txtPrecio_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) &&
      (e.KeyChar != '.') && (e.KeyChar != ','))
            {
                e.Handled = true;
            }
            if ((e.KeyChar == '.') && ((sender as TextBox).Text.IndexOf('.') > -1))
            {
                e.Handled = true;
            }
            if ((e.KeyChar == ',') && ((sender as TextBox).Text.IndexOf(',') > -1))
            {
                e.Handled = true;
            }
        }
        
        private void btnModificar_Click(object sender, EventArgs e)
        {
        //*
            Boolean estado = false;
            estado=acceso.modificarLibro(RecogerDatosPantalla());
            if (estado)
            {
                lblMensaje.Text = "Libro Modificado Correctamente";
                MessageBox.Show("Libro Modificado Correctamente");
            }
            else
            {
                lblMensaje.Text = "Libro no encontrado";
                MessageBox.Show("Libro no encontrado");
            }
        }
        //*****************************  MÉTODOS  PRIVADOS INTERNOS DE LA CLASE  ******************

        /******************************************************************************************
         * Metodo para recoger los datos
         * Se encarga de montar un libro a través de los datos que introduces en la ventana gráfica
         ******************************************************************************************/

        private Libro RecogerDatosPantalla()
        {
            Libro libro = null;
            string titulo, autor, paginas, precio, formatoUno, formatoDos, formatoTres, estado, tema;
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
                libro = new Libro(autor, titulo, tema, paginas, precio, formatoUno, formatoDos, formatoTres, estado);
            }
            return libro;
        }
        /*********************************************************************************************
	     * Pasamos por parametro un libro y este método se encargará de mostrarnos en la parte gráfica
	     * todo el contenido del libro.
	     *********************************************************************************************/
        private void EnviarDatosAPantalla(Libro libro)
        {
            txtAutor.Text = libro.Autor;
            txtPaginas.Text = libro.Paginas;
            txtPrecio.Text = libro.Precio + " €";
            txtTitulo.Text = libro.Titulo;
            cbxTemas.Text = libro.Tema;
            if (libro.Estado.Equals("reedicion"))
            {
                rbReedicion.Checked = true;
                rbNovedad.Checked = false;
            }
            else
            {
                rbNovedad.Checked = true;
                rbReedicion.Checked = false;
            }

            chkCartone.Checked = libro.Formatouno.Equals("Cartoné") ? true : false;
            chkRustica.Checked = libro.Formatodos.Equals("Rústica") ? true : false; ;
            chkTapaDura.Checked = libro.Formatotres.Equals("Tapa dura") ? true : false;
        }

        /*************************************************************************************
         * Método encargado de limpiar los campos de la pantalla
         * ***********************************************************************************/

        private void VaciarPantalla()
        {
            txtAutor.Text = "";
            txtMensaje.Text = "";
            txtPaginas.Text = "";
            txtPrecio.Text = "";
            txtTitulo.Text = "";
            rbReedicion.Checked = false;
            chkCartone.Checked = false;
            chkRustica.Checked = false;
            chkTapaDura.Checked = false;
            cbxTemas.SelectedIndex = 0;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void txtTitulo_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
