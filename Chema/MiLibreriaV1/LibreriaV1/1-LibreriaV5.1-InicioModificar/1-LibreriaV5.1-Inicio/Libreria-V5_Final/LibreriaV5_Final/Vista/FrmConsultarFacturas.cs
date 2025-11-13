using LibreriaV5_Final.Comun;
using LibreriaV5_Final.Negocio;
using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace LibreriaV5_Final.Vista
{
    public partial class FrmConsultarFacturas : Form
    {
        ControlAccesoDAO<object> control = new ControlAccesoDAO<object>();
        List<object> listLineasFactura;

        public FrmConsultarFacturas()
        {
            InitializeComponent();
            LlenarCombo();
        }

        private void BtnEliminar_Click_1(object sender, EventArgs e)
        {
            try
            {
                var result = MessageBox.Show(Mensajes.MSG_PREGUNTA_BORRAR_FACTURA, Mensajes.MSG_ATENCION, MessageBoxButtons.YesNo, MessageBoxIcon.Asterisk);
                if (result == DialogResult.Yes)
                {
                    control.BorradoVirtual(cmbFactura.SelectedItem);
                    cmbFactura.Items.Remove(cmbFactura.SelectedItem);
                }
                LimpiarPantalla();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void CmbFactura_SelectedIndexChanged_1(object sender, EventArgs e)
        {
            try
            {
                LimpiarPantalla();
                TFactura factura = (TFactura)cmbFactura.SelectedItem;
                lblCliente.Text = factura.Cliente;
                lblFecha.Text = factura.FechaFactura;
                listLineasFactura = control.Buscar(new TLineaFactura().GetType(), "CodFactura", factura.CodFactura);
                RefrescarLineas();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        //-------------------METODOS PRIVADOS-----------------//

        private void LlenarCombo()
        {
            try
            {
                cmbFactura.Items.Clear();
                foreach (TFactura factura in control.BuscarAll(new TFactura().GetType()))
                {
                    if (factura.Borrado.Equals("0"))
                        cmbFactura.Items.Add(factura);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void RefrescarLineas()
        {
            decimal contador = 0;
            dataGridView1.Rows.Clear();
            foreach (TLineaFactura linea in listLineasFactura)
            {
                dataGridView1.Rows.Add(
                    new object[]
                    {
                        linea.Libro,
                        linea.Cantidad,
                        Convert.ToString(decimal.Parse(linea.Total)/int.Parse(linea.Cantidad)),
                        linea.Total
                    });
                contador += decimal.Parse(linea.Total);
            }
            lblTotal.Text = contador + " €";
        }

        public void LimpiarPantalla()
        {
            dataGridView1.Rows.Clear();
            lblCliente.Text = "";
            lblFecha.Text = "";
        }
    }
}
