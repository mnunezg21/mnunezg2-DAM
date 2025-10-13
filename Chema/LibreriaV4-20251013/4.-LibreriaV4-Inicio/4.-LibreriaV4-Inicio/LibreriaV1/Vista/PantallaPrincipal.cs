using LibreriaV3._1.Modelo;
using PracticaCRUD.BBDD;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace LibreriaV3._1
{
    public partial class PantallaPrincipal : Form
    {
        AccesoBD acceso = new AccesoBD();

        public PantallaPrincipal()
        {
            InitializeComponent();
        }              

        private void Form1_Load(object sender, EventArgs e)
        {
            //
            String sql = "SELECT * FROM tlibro";
            List<object> libros = acceso.ejecutarConsulta(sql, new TLibro());
            //List<object> libros = acceso.ejecutarConsulta(UtilSQL.sqlLeer(), new TLibro());            
            //
            foreach (TLibro libro in libros)
            {
                lstLibros.Items.Add(libro.Titulo);
            }
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            VaciarPantalla();
        }

        private void btnAlta_Click(object sender, EventArgs e)
        {
            // En este método falta la gestión de errores que proceden de AccesoBD     
            TLibro libro= RecogerDatosPantalla();           
            String sql = string.Format("INSERT INTO tlibro(Autor, Titulo, Tema, Paginas, Precio, Formatouno, Formatodos, Formatotres, Estado) VALUES ('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}')", libro.Autor, libro.Titulo, libro.Tema, libro.Paginas, libro.Precio, libro.Formatouno, libro.Formatodos, libro.Formatotres, libro.Estado);
            //
            if (acceso.ejecutarUpdate(sql))
            //if (acceso.ejecutarUpdate(UtilSQL.sqlInsertar(RecogerDatosPantalla())))               
            {
                lstLibros.Items.Add(txtTitulo.Text);                
                MessageBox.Show("Libro Creado Correctamente");
            }
            else
            {                
                MessageBox.Show("Insercción no válida");
            }
        }

        private void btnModificar_Click(object sender, EventArgs e)
        {
            //  
            TLibro libro = RecogerDatosPantalla();
            String titulo = lstLibros.SelectedItem.ToString();              
            //sql=string.Format("UPDATE tlibro SET Autor='{0}',Titulo='{1}',Tema='{2}',Paginas='{3}',Precio='{4}',Formatouno='{5}',Formatodos='{6}',Formatotres='{7}',Estado='{8}' WHERE titulo = '{9}'", libro.Autor, libro.Titulo, libro.Tema, libro.Paginas, libro.Precio, libro.Formatouno, libro.Formatodos, libro.Formatotres, libro.Estado,titulo);
            //
            // Quitamos el Titulo de la sentencia UPDATE, para que no pueda ser modificado.
            String sql=string.Format("UPDATE tlibro SET Autor='{0}',Tema='{1}',Paginas='{2}',Precio='{3}',Formatouno='{4}',Formatodos='{5}',Formatotres='{6}',Estado='{7}' WHERE titulo = '{8}'", libro.Autor, libro.Tema, libro.Paginas, libro.Precio, libro.Formatouno, libro.Formatodos, libro.Formatotres, libro.Estado,titulo);
            //
            if (acceso.ejecutarUpdate(sql))
            //if (acceso.ejecutarCRUD(UtilSQL.sqlModificar((((TLibro)lstLibros.SelectedItem).CodLibro), RecogerDatosPantalla())))
            {
                //lstLibros.Items.Add(txtTitulo.Text);
                MessageBox.Show("Libro Modificado Correctamente");                
            }
            else
            {
                MessageBox.Show("Modificación no válida");
            }
        }

        private void btnBaja_Click(object sender, EventArgs e)
        {
            //
            String titulo = lstLibros.SelectedItem.ToString();                      
            String sql = "DELETE FROM `tlibro` WHERE `titulo` = '" + titulo + "'";
            //
            if (acceso.ejecutarUpdate(sql))
            //if (acceso.ejecutarCRUD(UtilSQL.sqlBorrar((TLibro)lstLibros.SelectedItem)))
            {
                lstLibros.Items.Remove(lstLibros.SelectedItem.ToString());
                MessageBox.Show("Libro Borrado Correctamente");
            }
            else
            {
                MessageBox.Show("Borrado no válido");
            }
            VaciarPantalla();            
        }
       
        private void btnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        // Se deja este evento como documentación por si lo necesitamos
        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
        }
        // Se deja este evento como documentación por si lo necesitamos
        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
        }
        // Se deja este evento como documentación por si lo necesitamos
        private void txtMensaje_TextChanged(object sender, EventArgs e)
        {
        }
        private void lstLibros_Click(object sender, EventArgs e)
        {
            if (lstLibros.SelectedItem != null)
            {
                String titulo = lstLibros.SelectedItem.ToString();               
                String sql = "SELECT * FROM `tlibro` WHERE `titulo` = '" + titulo + "'";
                TLibro libro = (TLibro)acceso.ejecutarConsulta(sql, new TLibro()).First();
                //
                //TLibro libro = (TLibro)acceso.ejecutarConsulta(UtilSQL.sqlBuscarLibro(lstLibros.SelectedItem.ToString()), new TLibro()).First();
                EnviarDatosAPantalla(libro);
            }
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
        //*****************************  MÉTODOS  PRIVADOS INTERNOS DE LA CLASE  ******************

        /******************************************************************************************
         * Metodo para recoger los datos
         * Se encarga de montar un libro a través de los datos que introduces en la ventana gráfica
         ******************************************************************************************/
        private TLibro RecogerDatosPantalla()
        {
            TLibro libro = null;
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
                libro = new TLibro(autor, titulo, tema, paginas, precio, formatoUno, formatoDos, formatoTres, estado);
            }
            return libro;
        }
        /*********************************************************************************************
	     * Pasamos por parametro un libro y este método se encargará de mostrarnos en la parte gráfica
	     * todo el contenido del libro.
	     *********************************************************************************************/
        private void EnviarDatosAPantalla(TLibro sender)
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
            chkTapaDura.Checked = sender.Formatotres.Equals("Tapa dura") ? true : false;
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
    }
}
