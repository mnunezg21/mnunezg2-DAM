using LibreriaV2.Datos;
using LibreriaV2.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace LibreriaV2
{
    public partial class PantallaPrincipal : Form
    {
        // Dejaremos los mensajes informativos lblMensaje. y MessageBox() para que el alumno
        // compruebe la manera de enviar datos a pantalla. La mejor forma de gestionar los
        // mensajes informativos es hacerlo como se indica en el desarrollo de este ejercicio, 
        // crear la clase mensaje.
        // En cuanto a la gestión de los errores, se controlan en la capa de presentación.
        // Cuando se producen errores en la capa de datos, serán enviados mediante la orden throw
        // a la capa superior(capa de presentación) para que sea gestionado.
        // En este código no utilizaremos la clase Errores. Los errores serán gestionados directamente
        // con la clase Exception. Si queremos hacer un control exhaustivo de los errores que va 
        // produciendo la aplicación deberíamos codificar esta clase tal y como se ha realizado en los
        // proyectos JAVA.

        private AccesoLibro acceso = new AccesoLibro();

        public PantallaPrincipal()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // Se podría crear un método privado en esta clase para realizar la carga de 
            // los libros cargarLibros().
            // Hemos optado por introducirlo en el Form_Load(), pero podría haberse cargado 
            // en el constructor PantallaPrincipal().
            // En la version5 se realiza el método privado y la carga se hace en el constructor.
            try
            {
                List<object> libros = acceso.obtenerLibros();
                foreach (TLibro libro in libros)
                {
                    lstLibros.Items.Add(libro.Titulo);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
        private void btnNuevo_Click(object sender, EventArgs e)
        {
            VaciarPantalla();
        }

        private void btnAlta_Click(object sender, EventArgs e)
        {
            try
            {
                if (acceso.insertarLibro(RecogerDatosPantalla()))
                {
                    lstLibros.Items.Add(txtTitulo.Text);
                    //lblMensaje.Text = "Libro Creado Correctamente";
                    //MessageBox.Show("Libro Creado Correctamente");
                    MessageBox.Show(Mensajes.MSG_INSERTADO);
                }
                else
                {
                    //lblMensaje.Text = "El libro ya existe";
                    //MessageBox.Show("El libro ya existe");
                    MessageBox.Show(Mensajes.MSG_YAEXISTE);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnBaja_Click(object sender, EventArgs e)
        {
            try
            {
                if (!(lstLibros.SelectedIndex == -1))
                {
                    if (acceso.borrarLibro(RecogerDatosPantalla()))
                    {
                        lstLibros.Items.Remove(lstLibros.SelectedItem.ToString());
                        //lblMensaje.Text = "Libro Borrado Correctamente";
                        //MessageBox.Show("Libro Borrado Correctamente");
                        MessageBox.Show(Mensajes.MSG_BORRADO);
                    }
                    else
                    {
                        //lblMensaje.Text = "Libro no encontrado";
                        //MessageBox.Show("Libro no encontrado");
                        MessageBox.Show(Mensajes.MSG_NO_ENCONTRADO);
                    }
                    VaciarPantalla();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
                
        private void btnModificar_Click(object sender, EventArgs e)
        {
            try
            {
                if (acceso.modificarLibro(RecogerDatosPantalla()))
                {
                    //lblMensaje.Text = "Libro Modificado Correctamente";
                    //MessageBox.Show("Libro Modificado Correctamente");
                    MessageBox.Show(Mensajes.MSG_MODIFICADO);
                }
                else
                {
                    //lblMensaje.Text = "Libro no encontrado";
                    //MessageBox.Show("Libro no encontrado");
                    MessageBox.Show(Mensajes.MSG_NO_ENCONTRADO);
                }
                //*****  Este código no es necesario. Lo dejamos por si necesitamos utilizarlo como documentación.
                //*****  Tiene código que puede servirnos, por ejemplo, la carga de lstLibros mediante un DataSource.
                //*****  El resto de código proviene de las versiones originales de Josema. Este código
                //*****  lo hemos optimizado pero tiene órdenes que nos pueden servir.
                //*****  se modifican los valores en la base de datos.
                //this.DB.ejecutarCUD(UtilSQL.sqlModificar((((TLibro)lstLibros.SelectedItem).CodLibro), RecogerDatosPantalla()));
                //lstLibros.DataSource = null;
                //lstLibros.DataSource = this.DB.ejecutarConsulta(UtilSQL.sqlLeer(), new TLibro());
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void lstLibros_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                if (lstLibros.SelectedItem != null)
                {
                    EnviarDatosAPantalla((TLibro)acceso.buscarLibro(lstLibros.SelectedItem.ToString()));
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
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
