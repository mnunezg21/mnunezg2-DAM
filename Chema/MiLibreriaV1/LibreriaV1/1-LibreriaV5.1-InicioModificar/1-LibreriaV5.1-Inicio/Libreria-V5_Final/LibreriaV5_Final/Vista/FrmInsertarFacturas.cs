using LibreriaV5_Final.Persistencia;
using LibreriaV5_Final.Comun;
using LibreriaV5_Final.Modelo;
using LibreriaV5_Final.Negocio;
using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace LibreriaV5_Final.Vista
{
    public partial class FrmInsertarFacturas : Form
    {

        private ControlAccesoDAO<object> control = new ControlAccesoDAO<object>();
        private List<TLineaFactura> listLineasFacturas = new List<TLineaFactura>();
        public FrmInsertarFacturas()
        {
            try
            {
                InitializeComponent();
                LlenarCombos();
                lblCodFactura.Text = UtilSQL.GenerarCodigo(new TFactura().GetType());
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void BtnOk_Click(object sender, EventArgs e)
        {
            cmbClientes.Enabled = false;
            TLibro libro = (TLibro)cmbLibros.SelectedItem;
            TLineaFactura lineaFactura = new TLineaFactura(lblCodFactura.Text, libro.Titulo, Convert.ToString(txtCantidad.Value), Convert.ToString(Convert.ToDecimal(libro.Precio) * txtCantidad.Value));
            if (!listLineasFacturas.Contains(lineaFactura))
            {
                listLineasFacturas.Add(lineaFactura);
                dataGridView1.Rows.Add(
                new object[]
                {
                        lineaFactura.Libro,
                        lineaFactura.Cantidad,
                        libro.Precio,
                        lineaFactura.Total,
                });

            }
            else
            {
                ActualizarExistentes(libro, lineaFactura);
            }

            decimal total = 0;
            foreach (TLineaFactura item in listLineasFacturas)
            {
                total += decimal.Parse(item.Total);
            }

            lblTotal.Text = Convert.ToString(total);

        }

        private void BtnInsertar_Click(object sender, EventArgs e)
        {
            try
            {
                TFactura factura = new TFactura(lblCodFactura.Text, ((TCliente)cmbClientes.SelectedItem).Nombre + " " + ((TCliente)cmbClientes.SelectedItem).Apellidos, txtFecha.Text);
                if (listLineasFacturas.Count == 0)
                {
                    MessageBox.Show(Mensajes.MSG_INSERTAR_ELEMENTOS_FACTURA);
                }
                else
                {
                    control.Insertar(factura);
                    foreach (TLineaFactura item in listLineasFacturas)
                    {
                        control.Insertar(item);
                    }
                }
                cmbClientes.Enabled = true;
                RefrescarLineas();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        //--------------------METODOS PRIVADOS-----------------------//

        private void RefrescarLineas()
        {
            try
            {
                dataGridView1.Rows.Clear();
                cmbClientes.SelectedIndex = 0;
                cmbLibros.SelectedIndex = 0;
                txtCantidad.Value = 1;
                txtFecha.Value = DateTime.Today;
                listLineasFacturas.Clear();
                lblCodFactura.Text = UtilSQL.GenerarCodigo(new TFactura().GetType());
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void LlenarCombos()
        {
            try
            {
                foreach (TCliente cliente in control.BuscarAll(new TCliente().GetType()))
                {
                    if (cliente.Borrado.Equals("0"))
                    {
                        cmbClientes.Items.Add(cliente);
                    }
                }

                foreach (TLibro libro in control.BuscarAll(new TLibro().GetType()))
                {
                    if (libro.Borrado.Equals("0"))
                    {
                        cmbLibros.Items.Add(libro);
                    }
                }
                if (cmbClientes.Items.Count > 0)
                    cmbClientes.SelectedIndex = 0;
                if (cmbLibros.Items.Count > 0)
                    cmbLibros.SelectedIndex = 0;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        public void LimpiarPantalla()
        {

            dataGridView1.Rows.Clear();
            cmbClientes.SelectedIndex = 0;
            cmbLibros.SelectedIndex = 0;
            txtCantidad.Value = 1;
            txtFecha.Value = DateTime.Today;
        }

        private void ActualizarExistentes(TLibro libro, TLineaFactura lineaFactura)
        {
            lineaFactura.Cantidad = Convert.ToString(int.Parse(listLineasFacturas[listLineasFacturas.IndexOf(lineaFactura)].Cantidad) + txtCantidad.Value);
            listLineasFacturas[listLineasFacturas.IndexOf(lineaFactura)].Cantidad = lineaFactura.Cantidad;
            lineaFactura.Total = Convert.ToString(int.Parse(lineaFactura.Cantidad) * decimal.Parse(libro.Precio));
            listLineasFacturas[listLineasFacturas.IndexOf(lineaFactura)].Total = lineaFactura.Total;
            dataGridView1["Cantidad", listLineasFacturas.IndexOf(lineaFactura)].Value = lineaFactura.Cantidad;
            dataGridView1["Subtotal", listLineasFacturas.IndexOf(lineaFactura)].Value = lineaFactura.Total;
        }
    }
}
