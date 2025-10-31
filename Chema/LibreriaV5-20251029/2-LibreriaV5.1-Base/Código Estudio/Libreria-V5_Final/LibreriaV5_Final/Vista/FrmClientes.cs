using LibreriaV5_Final.Comun;
using LibreriaV5_Final.Negocio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace LibreriaV5_Final.Vista
{
    public partial class FrmClientes : Form
    {

        private ControlAccesoDAO<TCliente> control = new ControlAccesoDAO<TCliente>();
        private TCliente cliente;

        public FrmClientes()
        {
            InitializeComponent();
            ObtenerTodosClientes();
        }

        private void LstLibros_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lstClientes.SelectedItem != null)
            {
                RellenarCampos((TCliente)lstClientes.SelectedItem);
            }
        }

        private void BtnAlta_Click(object sender, EventArgs e)
        {
            try
            {
                if ((cliente = RecogerDatosPantalla()) == null)
                {
                    MessageBox.Show(Mensajes.MSG_CAMPOSVACIOS);
                }
                else
                {
                    if (control.Buscar(cliente.GetType(), cliente.CodCliente) != null)
                    {
                        txtMensaje.Text = Mensajes.MSG_YAEXISTE_CLIENTE;
                    }
                    else
                    {
                        control.Insertar(cliente);
                        lstClientes.Items.Add(cliente);
                        txtMensaje.Text = Mensajes.MSG_INSERTADO_CLIENTE;
                    }
                }
                lstClientes.ClearSelected();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void BtnNuevo_Click(object sender, EventArgs e)
        {
            VaciarPantalla();
        }

        private void BtnBaja_Click(object sender, EventArgs e)
        {
            try
            {
                if (lstClientes.SelectedItem != null)
                {

                    var result = MessageBox.Show(Mensajes.MSG_PREGUNTA_BORRAR, Mensajes.MSG_ATENCION, MessageBoxButtons.YesNoCancel, MessageBoxIcon.Asterisk);
                    //Borrado virtual
                    if (result == DialogResult.Yes)
                    {
                        if (control.BorradoVirtual(lstClientes.SelectedItem))
                        {
                            txtMensaje.Text = Mensajes.MSG_BORRADO_VIRTUAL;
                            lstClientes.Items.Remove(lstClientes.SelectedItem);
                        }
                    }
                    else if (result == DialogResult.No)
                    {
                        if (control.Borrar(lstClientes.SelectedItem))
                        {
                            txtMensaje.Text = Mensajes.MSG_BORRADO_CLIENTE;
                            lstClientes.Items.Remove(lstClientes.SelectedItem);
                        }
                    }
                }
                else
                {
                    MessageBox.Show(Mensajes.MSG_SELECCIONAR_CLIENTE);
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
                TCliente cliente = RecogerDatosPantalla();
                if (cliente != null)
                {
                    cliente.CodCliente = ((TCliente)lstClientes.SelectedItem).CodCliente;
                    if (control.Modificar(cliente.CodCliente, cliente))
                    {
                        lstClientes.Items.Remove(lstClientes.SelectedItem);
                        lstClientes.Items.Add(cliente);
                        txtMensaje.Text = Mensajes.MSG_MODIFICADO_CLIENTE;
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

        //---------------------METODOS PRIVADOS-------------------//

        private void ObtenerTodosClientes()
        {
            try
            {
                List<object> clientes = new List<object>();
                foreach (TCliente item in control.BuscarTodo(new TCliente().GetType()))
                {
                    if (item.Borrado.Equals("0"))
                    {
                        lstClientes.Items.Add(item);
                    }
                }
                lstClientes.ClearSelected();
                VaciarPantalla();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void VaciarPantalla()
        {
            txtNombre.Text = "";
            txtApellidos.Text = "";
            txtDireccion.Text = "";
            txtDNI.Text = "";
            txtEmail.Text = "";
            txtMensaje.Text = "";

        }

        private TCliente RecogerDatosPantalla()
        {
            TCliente libro = null;
            string nombre, apellidos, dni, direccion, email;
            nombre = txtNombre.Text;
            apellidos = txtApellidos.Text;
            dni = txtDNI.Text;
            direccion = txtDireccion.Text;
            email = txtEmail.Text;

            if (nombre.Count() != 0 && apellidos.Count() != 0 && dni.Count() != 0 && direccion.Count() != 0 && email.Count() != 0)
            {
                libro = new TCliente(nombre, apellidos, dni, direccion, email);
            }
            return libro;
        }

        private void RellenarCampos(TCliente cliente)
        {
            txtNombre.Text = cliente.Nombre;
            txtApellidos.Text = cliente.Apellidos;
            txtDireccion.Text = cliente.Direccion;
            txtEmail.Text = cliente.Email;
            txtDNI.Text = cliente.DNI;

        }
    }
}
