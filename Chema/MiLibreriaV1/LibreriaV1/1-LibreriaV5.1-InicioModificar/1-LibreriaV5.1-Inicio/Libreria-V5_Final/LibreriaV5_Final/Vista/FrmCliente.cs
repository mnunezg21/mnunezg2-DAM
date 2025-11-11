using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using LibreriaV5_Final.Comun;
using LibreriaV5_Final.Modelo;
using LibreriaV5_Final.Negocio;

namespace LibreriaV5_Final.Vista
{
    public partial class FrmCliente : Form
    {
        private ControlAccesoDAO<object> control = new ControlAccesoDAO<object>();

        public FrmCliente()
        {
            InitializeComponent();
            ObtenerTodosClientes();
        }
        private void buttonNuevo_Click(object sender, EventArgs e)
        {
            VaciarPantalla();
        }

        private void buttonAlta_Click(object sender, EventArgs e)
        {
            TCliente cliente;
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
                        textMensaje.Text = Mensajes.MSG_YAEXISTE_CLIENTE;
                    }
                    else
                    {
                        control.Insertar(cliente);
                        listClientes.Items.Add(cliente);
                        textMensaje.Text = Mensajes.MSG_INSERTADO_CLIENTE;
                    }
                }
                listClientes.ClearSelected();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void buttonBaja_Click(object sender, EventArgs e)
        {
            try
            {
                if (listClientes.SelectedItem != null)
                {
                    var result = MessageBox.Show(Mensajes.MSG_PREGUNTA_BORRAR, Mensajes.MSG_ATENCION, MessageBoxButtons.YesNoCancel, MessageBoxIcon.Asterisk);
                    //Borrado virtual
                    if (result == DialogResult.Yes)
                    {
                        if (control.BorradoVirtual(listClientes.SelectedItem))
                        {
                            textMensaje.Text = Mensajes.MSG_BORRADO_VIRTUAL;
                            listClientes.Items.Remove(listClientes.SelectedItem);
                        }
                    }
                    else if (result == DialogResult.No)
                    {
                        if (control.Borrar(listClientes.SelectedItem))
                        {
                            textMensaje.Text = Mensajes.MSG_BORRADO_CLIENTE;
                            listClientes.Items.Remove(listClientes.SelectedItem);
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

        private void buttonModificar_Click(object sender, EventArgs e)
        {
            try
            {
                TCliente cliente = RecogerDatosPantalla();
                if (cliente != null)
                {
                    cliente.Borrado = ((TCliente)listClientes.SelectedItem).Borrado;
                    if (control.Modificar(cliente))
                    {
                        listClientes.Items.Remove(listClientes.SelectedItem);
                        listClientes.Items.Add(cliente);
                        textMensaje.Text = Mensajes.MSG_MODIFICADO_CLIENTE;
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

        private void buttonSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void listClientes_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listClientes.SelectedItem != null)
            {
                RellenarCampos((TCliente)listClientes.SelectedItem);
            }
        }

        // METODOS PRIVADOS
        private TCliente RecogerDatosPantalla()
        {
            TCliente cliente = null;
            string codCliente, nombre, apellidos, dNI, direccion, email,borrado;
            nombre = textNombre.Text;
            apellidos = textApellidos.Text;
            dNI = textDni.Text;
            direccion = textDireccion.Text; 
            email = textEmail.Text;
            borrado = "0";

            if (nombre.Count() != 0 && apellidos.Count() != 0 && email.Count() != 0 && dNI.Count() != 0 && direccion.Count() != 0)
            {
                if (((TCliente)listClientes.SelectedItem) == null)
                    cliente = new TCliente(nombre, apellidos, dNI, direccion, email);
                else
                {
                    codCliente = ((TCliente)listClientes.SelectedItem).CodCliente;
                    cliente = new TCliente(codCliente, nombre, apellidos, dNI, direccion, email, borrado);
                }
            }
            return cliente;
        }

        private void ObtenerTodosClientes()
        {
            try
            {
                List<object> clientes = new List<object>();
                foreach (TCliente item in control.Obtener(new TCliente().GetType()))
                {
                    if (item.Borrado.Equals("0"))
                    {
                        listClientes.Items.Add(item);
                    }
                }
                listClientes.ClearSelected();
                VaciarPantalla();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void VaciarPantalla()
        {
            textNombre.Text = "";
            textApellidos.Text = "";
            textDni.Text = "";
            textDireccion.Text = "";
            textEmail.Text = "";
        }

        private void RellenarCampos(TCliente sender)
        {
            textNombre.Text = sender.Nombre;
            textApellidos.Text = sender.Apellidos;
            textDni.Text = sender.DNI;
            textDireccion.Text = sender.Direccion;
            textEmail.Text = sender.Email;
        }

        private void textNombre_TextChanged(object sender, EventArgs e)
        {
        }

        private void FrmCliente_Load(object sender, EventArgs e)
        {

        }
    }
}
