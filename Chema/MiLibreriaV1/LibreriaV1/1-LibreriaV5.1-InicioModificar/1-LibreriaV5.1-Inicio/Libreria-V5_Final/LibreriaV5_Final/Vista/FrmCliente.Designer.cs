namespace LibreriaV5_Final.Vista
{
    partial class FrmCliente
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.textNombre = new System.Windows.Forms.TextBox();
            this.textDireccion = new System.Windows.Forms.TextBox();
            this.textDni = new System.Windows.Forms.TextBox();
            this.textEmail = new System.Windows.Forms.TextBox();
            this.textApellidos = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.textMensaje = new System.Windows.Forms.TextBox();
            this.listClientes = new System.Windows.Forms.ListBox();
            this.panel1 = new System.Windows.Forms.Panel();
            this.buttonSalir = new System.Windows.Forms.Button();
            this.buttonModificar = new System.Windows.Forms.Button();
            this.buttonNuevo = new System.Windows.Forms.Button();
            this.buttonBaja = new System.Windows.Forms.Button();
            this.buttonAlta = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 42F);
            this.label1.Location = new System.Drawing.Point(143, 65);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(305, 95);
            this.label1.TabIndex = 2;
            this.label1.Text = "Cliente";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.label2.Location = new System.Drawing.Point(102, 209);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(101, 29);
            this.label2.TabIndex = 3;
            this.label2.Text = "Nombre";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.label3.Location = new System.Drawing.Point(137, 325);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(54, 29);
            this.label3.TabIndex = 4;
            this.label3.Text = "DNI";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.label4.Location = new System.Drawing.Point(117, 381);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(74, 29);
            this.label4.TabIndex = 5;
            this.label4.Text = "Email";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.label5.Location = new System.Drawing.Point(81, 264);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(114, 29);
            this.label5.TabIndex = 6;
            this.label5.Text = "Apellidos";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.label6.Location = new System.Drawing.Point(89, 430);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(115, 29);
            this.label6.TabIndex = 7;
            this.label6.Text = "Direccion";
            // 
            // textNombre
            // 
            this.textNombre.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.textNombre.Location = new System.Drawing.Point(210, 209);
            this.textNombre.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.textNombre.Name = "textNombre";
            this.textNombre.Size = new System.Drawing.Size(227, 35);
            this.textNombre.TabIndex = 8;
            this.textNombre.TextChanged += new System.EventHandler(this.textNombre_TextChanged);
            // 
            // textDireccion
            // 
            this.textDireccion.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.textDireccion.Location = new System.Drawing.Point(210, 435);
            this.textDireccion.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.textDireccion.Name = "textDireccion";
            this.textDireccion.Size = new System.Drawing.Size(227, 35);
            this.textDireccion.TabIndex = 9;
            // 
            // textDni
            // 
            this.textDni.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.textDni.Location = new System.Drawing.Point(210, 325);
            this.textDni.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.textDni.Name = "textDni";
            this.textDni.Size = new System.Drawing.Size(227, 35);
            this.textDni.TabIndex = 10;
            // 
            // textEmail
            // 
            this.textEmail.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.textEmail.Location = new System.Drawing.Point(210, 381);
            this.textEmail.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.textEmail.Name = "textEmail";
            this.textEmail.Size = new System.Drawing.Size(227, 35);
            this.textEmail.TabIndex = 11;
            // 
            // textApellidos
            // 
            this.textApellidos.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.textApellidos.Location = new System.Drawing.Point(210, 269);
            this.textApellidos.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.textApellidos.Name = "textApellidos";
            this.textApellidos.Size = new System.Drawing.Size(227, 35);
            this.textApellidos.TabIndex = 12;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.label7.Location = new System.Drawing.Point(484, 105);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(123, 29);
            this.label7.TabIndex = 13;
            this.label7.Text = "Mensajes:";
            // 
            // textMensaje
            // 
            this.textMensaje.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.textMensaje.Location = new System.Drawing.Point(606, 101);
            this.textMensaje.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.textMensaje.Name = "textMensaje";
            this.textMensaje.Size = new System.Drawing.Size(299, 35);
            this.textMensaje.TabIndex = 14;
            // 
            // listClientes
            // 
            this.listClientes.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F);
            this.listClientes.FormattingEnabled = true;
            this.listClientes.ItemHeight = 22;
            this.listClientes.Location = new System.Drawing.Point(604, 188);
            this.listClientes.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.listClientes.Name = "listClientes";
            this.listClientes.Size = new System.Drawing.Size(300, 488);
            this.listClientes.TabIndex = 15;
            this.listClientes.SelectedIndexChanged += new System.EventHandler(this.listClientes_SelectedIndexChanged);
            // 
            // panel1
            // 
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel1.Controls.Add(this.buttonSalir);
            this.panel1.Controls.Add(this.buttonModificar);
            this.panel1.Controls.Add(this.buttonNuevo);
            this.panel1.Controls.Add(this.buttonBaja);
            this.panel1.Controls.Add(this.buttonAlta);
            this.panel1.Location = new System.Drawing.Point(188, 498);
            this.panel1.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(284, 238);
            this.panel1.TabIndex = 16;
            // 
            // buttonSalir
            // 
            this.buttonSalir.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.buttonSalir.Location = new System.Drawing.Point(15, 166);
            this.buttonSalir.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.buttonSalir.Name = "buttonSalir";
            this.buttonSalir.Size = new System.Drawing.Size(250, 50);
            this.buttonSalir.TabIndex = 4;
            this.buttonSalir.Text = "Salir";
            this.buttonSalir.UseVisualStyleBackColor = true;
            this.buttonSalir.Click += new System.EventHandler(this.buttonSalir_Click);
            // 
            // buttonModificar
            // 
            this.buttonModificar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.buttonModificar.Location = new System.Drawing.Point(152, 98);
            this.buttonModificar.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.buttonModificar.Name = "buttonModificar";
            this.buttonModificar.Size = new System.Drawing.Size(112, 50);
            this.buttonModificar.TabIndex = 3;
            this.buttonModificar.Text = "Modificar";
            this.buttonModificar.UseVisualStyleBackColor = true;
            this.buttonModificar.Click += new System.EventHandler(this.buttonModificar_Click);
            // 
            // buttonNuevo
            // 
            this.buttonNuevo.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.buttonNuevo.Location = new System.Drawing.Point(15, 98);
            this.buttonNuevo.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.buttonNuevo.Name = "buttonNuevo";
            this.buttonNuevo.Size = new System.Drawing.Size(112, 50);
            this.buttonNuevo.TabIndex = 2;
            this.buttonNuevo.Text = "Nuevo";
            this.buttonNuevo.UseVisualStyleBackColor = true;
            this.buttonNuevo.Click += new System.EventHandler(this.buttonNuevo_Click);
            // 
            // buttonBaja
            // 
            this.buttonBaja.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.buttonBaja.Location = new System.Drawing.Point(152, 28);
            this.buttonBaja.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.buttonBaja.Name = "buttonBaja";
            this.buttonBaja.Size = new System.Drawing.Size(112, 50);
            this.buttonBaja.TabIndex = 1;
            this.buttonBaja.Text = "Baja";
            this.buttonBaja.UseVisualStyleBackColor = true;
            this.buttonBaja.Click += new System.EventHandler(this.buttonBaja_Click);
            // 
            // buttonAlta
            // 
            this.buttonAlta.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.buttonAlta.Location = new System.Drawing.Point(15, 28);
            this.buttonAlta.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.buttonAlta.Name = "buttonAlta";
            this.buttonAlta.Size = new System.Drawing.Size(112, 50);
            this.buttonAlta.TabIndex = 0;
            this.buttonAlta.Text = "Alta";
            this.buttonAlta.UseVisualStyleBackColor = true;
            this.buttonAlta.Click += new System.EventHandler(this.buttonAlta_Click);
            // 
            // FrmCliente
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(965, 812);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.listClientes);
            this.Controls.Add(this.textMensaje);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.textApellidos);
            this.Controls.Add(this.textEmail);
            this.Controls.Add(this.textDni);
            this.Controls.Add(this.textDireccion);
            this.Controls.Add(this.textNombre);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.Name = "FrmCliente";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.FrmCliente_Load);
            this.panel1.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox textNombre;
        private System.Windows.Forms.TextBox textDireccion;
        private System.Windows.Forms.TextBox textDni;
        private System.Windows.Forms.TextBox textEmail;
        private System.Windows.Forms.TextBox textApellidos;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox textMensaje;
        private System.Windows.Forms.ListBox listClientes;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button buttonBaja;
        private System.Windows.Forms.Button buttonAlta;
        private System.Windows.Forms.Button buttonSalir;
        private System.Windows.Forms.Button buttonModificar;
        private System.Windows.Forms.Button buttonNuevo;
    }
}