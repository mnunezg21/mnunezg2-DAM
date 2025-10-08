namespace MiLibreria2
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            lblMensajes = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label8 = new Label();
            label6 = new Label();
            txtTitulo = new TextBox();
            txtPagina = new TextBox();
            txtPrecios = new TextBox();
            txtAutor = new TextBox();
            textBox5 = new TextBox();
            lstLibros = new ListBox();
            cbxTemas = new ComboBox();
            chkCartone = new CheckBox();
            btnAlta = new Button();
            rbNovedad = new RadioButton();
            panel1 = new Panel();
            btnSalir = new Button();
            btnNuevo = new Button();
            btnBaja = new Button();
            btnModificar = new Button();
            Formato = new GroupBox();
            chkTapaDura = new CheckBox();
            chkRustica = new CheckBox();
            Estado = new GroupBox();
            rbReedicion = new RadioButton();
            panel1.SuspendLayout();
            Formato.SuspendLayout();
            Estado.SuspendLayout();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Microsoft Sans Serif", 36F, FontStyle.Bold);
            label1.Location = new Point(95, 20);
            label1.Name = "label1";
            label1.Size = new Size(236, 69);
            label1.TabIndex = 0;
            label1.Text = "Libreria";
            // 
            // lblMensajes
            // 
            lblMensajes.AutoSize = true;
            lblMensajes.Font = new Font("Microsoft Sans Serif", 7.8F);
            lblMensajes.Location = new Point(469, 20);
            lblMensajes.Name = "lblMensajes";
            lblMensajes.Size = new Size(69, 16);
            lblMensajes.TabIndex = 1;
            lblMensajes.Text = "Mensajes:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Microsoft Sans Serif", 12F);
            label2.Location = new Point(416, 50);
            label2.Name = "label2";
            label2.Size = new Size(103, 25);
            label2.TabIndex = 2;
            label2.Text = "Mensajes:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Microsoft Sans Serif", 12F);
            label3.Location = new Point(29, 118);
            label3.Name = "label3";
            label3.Size = new Size(66, 25);
            label3.TabIndex = 3;
            label3.Text = "Título:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Microsoft Sans Serif", 12F);
            label4.Location = new Point(30, 152);
            label4.Name = "label4";
            label4.Size = new Size(65, 25);
            label4.TabIndex = 4;
            label4.Text = "Autor:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Microsoft Sans Serif", 12F);
            label5.Location = new Point(29, 256);
            label5.Name = "label5";
            label5.Size = new Size(83, 25);
            label5.TabIndex = 6;
            label5.Text = "Precios:";
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Font = new Font("Microsoft Sans Serif", 12F);
            label8.Location = new Point(29, 186);
            label8.Name = "label8";
            label8.Size = new Size(69, 25);
            label8.TabIndex = 7;
            label8.Text = "Tema:";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new Font("Microsoft Sans Serif", 12F);
            label6.Location = new Point(29, 221);
            label6.Name = "label6";
            label6.Size = new Size(89, 25);
            label6.TabIndex = 8;
            label6.Text = "Páginas:";
            // 
            // txtTitulo
            // 
            txtTitulo.Location = new Point(131, 118);
            txtTitulo.Name = "txtTitulo";
            txtTitulo.Size = new Size(278, 27);
            txtTitulo.TabIndex = 9;
            // 
            // txtPagina
            // 
            txtPagina.Location = new Point(131, 221);
            txtPagina.Name = "txtPagina";
            txtPagina.Size = new Size(278, 27);
            txtPagina.TabIndex = 10;
            // 
            // txtPrecios
            // 
            txtPrecios.Location = new Point(131, 257);
            txtPrecios.Name = "txtPrecios";
            txtPrecios.Size = new Size(278, 27);
            txtPrecios.TabIndex = 11;
            txtPrecios.TextChanged += textBox3_TextChanged;
            // 
            // txtAutor
            // 
            txtAutor.Location = new Point(131, 153);
            txtAutor.Name = "txtAutor";
            txtAutor.Size = new Size(278, 27);
            txtAutor.TabIndex = 12;
            // 
            // textBox5
            // 
            textBox5.Location = new Point(525, 48);
            textBox5.Name = "textBox5";
            textBox5.Size = new Size(275, 27);
            textBox5.TabIndex = 13;
            textBox5.TextChanged += textBox5_TextChanged;
            // 
            // lstLibros
            // 
            lstLibros.FormattingEnabled = true;
            lstLibros.Location = new Point(469, 97);
            lstLibros.Name = "lstLibros";
            lstLibros.Size = new Size(331, 424);
            lstLibros.TabIndex = 14;
            lstLibros.SelectedIndexChanged += listBox1_SelectedIndexChanged;
            // 
            // cbxTemas
            // 
            cbxTemas.BackColor = SystemColors.Window;
            cbxTemas.FormattingEnabled = true;
            cbxTemas.Location = new Point(131, 187);
            cbxTemas.Name = "cbxTemas";
            cbxTemas.Size = new Size(278, 28);
            cbxTemas.TabIndex = 15;
            // 
            // chkCartone
            // 
            chkCartone.AutoSize = true;
            chkCartone.Font = new Font("Microsoft Sans Serif", 12F, FontStyle.Bold);
            chkCartone.Location = new Point(6, 26);
            chkCartone.Name = "chkCartone";
            chkCartone.Size = new Size(111, 29);
            chkCartone.TabIndex = 16;
            chkCartone.Text = "Cartoné";
            chkCartone.UseVisualStyleBackColor = true;
            // 
            // btnAlta
            // 
            btnAlta.Font = new Font("Microsoft Sans Serif", 12F);
            btnAlta.Location = new Point(16, 15);
            btnAlta.Name = "btnAlta";
            btnAlta.Size = new Size(118, 38);
            btnAlta.TabIndex = 17;
            btnAlta.Text = "Alta";
            btnAlta.UseVisualStyleBackColor = true;
            btnAlta.Click += btnAlta_Click;
            // 
            // rbNovedad
            // 
            rbNovedad.AutoSize = true;
            rbNovedad.Checked = true;
            rbNovedad.Location = new Point(6, 29);
            rbNovedad.Name = "rbNovedad";
            rbNovedad.Size = new Size(119, 29);
            rbNovedad.TabIndex = 18;
            rbNovedad.TabStop = true;
            rbNovedad.Text = "Novedad";
            rbNovedad.UseVisualStyleBackColor = true;
            // 
            // panel1
            // 
            panel1.Controls.Add(btnSalir);
            panel1.Controls.Add(btnNuevo);
            panel1.Controls.Add(btnBaja);
            panel1.Controls.Add(btnModificar);
            panel1.Controls.Add(btnAlta);
            panel1.Location = new Point(151, 502);
            panel1.Name = "panel1";
            panel1.Size = new Size(273, 157);
            panel1.TabIndex = 19;
            // 
            // btnSalir
            // 
            btnSalir.Font = new Font("Microsoft Sans Serif", 12F);
            btnSalir.Location = new Point(16, 103);
            btnSalir.Name = "btnSalir";
            btnSalir.Size = new Size(241, 38);
            btnSalir.TabIndex = 24;
            btnSalir.Text = "Salir";
            btnSalir.UseVisualStyleBackColor = true;
            btnSalir.Click += btnSalir_Click;
            // 
            // btnNuevo
            // 
            btnNuevo.Font = new Font("Microsoft Sans Serif", 12F);
            btnNuevo.Location = new Point(16, 59);
            btnNuevo.Name = "btnNuevo";
            btnNuevo.Size = new Size(118, 38);
            btnNuevo.TabIndex = 25;
            btnNuevo.Text = "Nuevo";
            btnNuevo.UseVisualStyleBackColor = true;
            btnNuevo.Click += btnNuevo_Click;
            // 
            // btnBaja
            // 
            btnBaja.Font = new Font("Microsoft Sans Serif", 12F);
            btnBaja.Location = new Point(140, 15);
            btnBaja.Name = "btnBaja";
            btnBaja.Size = new Size(118, 38);
            btnBaja.TabIndex = 22;
            btnBaja.Text = "Baja";
            btnBaja.UseVisualStyleBackColor = true;
            btnBaja.Click += btnBaja_Click;
            // 
            // btnModificar
            // 
            btnModificar.Font = new Font("Microsoft Sans Serif", 12F);
            btnModificar.Location = new Point(140, 59);
            btnModificar.Name = "btnModificar";
            btnModificar.Size = new Size(118, 38);
            btnModificar.TabIndex = 23;
            btnModificar.Text = "Modificar";
            btnModificar.UseVisualStyleBackColor = true;
            btnModificar.Click += btnModificar_Click;
            // 
            // Formato
            // 
            Formato.Controls.Add(chkTapaDura);
            Formato.Controls.Add(chkRustica);
            Formato.Controls.Add(chkCartone);
            Formato.Font = new Font("Microsoft Sans Serif", 12F, FontStyle.Bold);
            Formato.Location = new Point(30, 314);
            Formato.Name = "Formato";
            Formato.Size = new Size(193, 150);
            Formato.TabIndex = 20;
            Formato.TabStop = false;
            Formato.Text = "Formato";
            // 
            // chkTapaDura
            // 
            chkTapaDura.AutoSize = true;
            chkTapaDura.Font = new Font("Microsoft Sans Serif", 12F, FontStyle.Bold);
            chkTapaDura.Location = new Point(6, 96);
            chkTapaDura.Name = "chkTapaDura";
            chkTapaDura.Size = new Size(133, 29);
            chkTapaDura.TabIndex = 18;
            chkTapaDura.Text = "Tapa dura";
            chkTapaDura.UseVisualStyleBackColor = true;
            chkTapaDura.CheckedChanged += checkBox3_CheckedChanged;
            // 
            // chkRustica
            // 
            chkRustica.AutoSize = true;
            chkRustica.Font = new Font("Microsoft Sans Serif", 12F, FontStyle.Bold);
            chkRustica.Location = new Point(6, 61);
            chkRustica.Name = "chkRustica";
            chkRustica.Size = new Size(105, 29);
            chkRustica.TabIndex = 17;
            chkRustica.Text = "Rústica";
            chkRustica.UseVisualStyleBackColor = true;
            // 
            // Estado
            // 
            Estado.Controls.Add(rbReedicion);
            Estado.Controls.Add(rbNovedad);
            Estado.Font = new Font("Microsoft Sans Serif", 12F, FontStyle.Bold);
            Estado.Location = new Point(247, 314);
            Estado.Name = "Estado";
            Estado.Size = new Size(193, 150);
            Estado.TabIndex = 21;
            Estado.TabStop = false;
            Estado.Text = "Estado";
            // 
            // rbReedicion
            // 
            rbReedicion.AutoSize = true;
            rbReedicion.Location = new Point(6, 64);
            rbReedicion.Name = "rbReedicion";
            rbReedicion.Size = new Size(128, 29);
            rbReedicion.TabIndex = 19;
            rbReedicion.TabStop = true;
            rbReedicion.Text = "Reedición";
            rbReedicion.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(840, 743);
            Controls.Add(Estado);
            Controls.Add(Formato);
            Controls.Add(panel1);
            Controls.Add(cbxTemas);
            Controls.Add(lstLibros);
            Controls.Add(textBox5);
            Controls.Add(txtAutor);
            Controls.Add(txtPrecios);
            Controls.Add(txtPagina);
            Controls.Add(txtTitulo);
            Controls.Add(label6);
            Controls.Add(label8);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(lblMensajes);
            Controls.Add(label1);
            Name = "Form1";
            Text = "MiLibreria2";
            panel1.ResumeLayout(false);
            Formato.ResumeLayout(false);
            Formato.PerformLayout();
            Estado.ResumeLayout(false);
            Estado.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label lblMensajes;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label8;
        private Label label6;
        private TextBox txtTitulo;
        private TextBox txtPagina;
        private TextBox txtPrecios;
        private TextBox txtAutor;
        private TextBox textBox5;
        private ListBox lstLibros;
        private ComboBox cbxTemas;
        private CheckBox chkCartone;
        private Button btnAlta;
        private RadioButton rbNovedad;
        private Panel panel1;
        private GroupBox Formato;
        private CheckBox chkTapaDura;
        private CheckBox chkRustica;
        private Button btnNuevo;
        private Button btnModificar;
        private GroupBox Estado;
        private RadioButton rbReedicion;
        private Button btnSalir;
        private Button btnBaja;
    }
}
