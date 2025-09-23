namespace Libreria_V1
{
    partial class Libreria
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblLibreria = new System.Windows.Forms.Label();
            this.lblTitulo = new System.Windows.Forms.Label();
            this.lblAutor = new System.Windows.Forms.Label();
            this.lblTema = new System.Windows.Forms.Label();
            this.lblPaginas = new System.Windows.Forms.Label();
            this.lblPrecio = new System.Windows.Forms.Label();
            this.pnlBotones = new System.Windows.Forms.Panel();
            this.btnSalir = new System.Windows.Forms.Button();
            this.btnModificar = new System.Windows.Forms.Button();
            this.btnNuevo = new System.Windows.Forms.Button();
            this.btnBaja = new System.Windows.Forms.Button();
            this.btnAlta = new System.Windows.Forms.Button();
            this.grbFormato = new System.Windows.Forms.GroupBox();
            this.chkTapaDura = new System.Windows.Forms.CheckBox();
            this.chkRustica = new System.Windows.Forms.CheckBox();
            this.chkCartone = new System.Windows.Forms.CheckBox();
            this.gpbEstado = new System.Windows.Forms.GroupBox();
            this.rdbReedicion = new System.Windows.Forms.RadioButton();
            this.rdbNovedad = new System.Windows.Forms.RadioButton();
            this.txtTitulo = new System.Windows.Forms.TextBox();
            this.txtAutor = new System.Windows.Forms.TextBox();
            this.txtPaginas = new System.Windows.Forms.TextBox();
            this.txtPrecio = new System.Windows.Forms.TextBox();
            this.cbxTemas = new System.Windows.Forms.ComboBox();
            this.lstLibros = new System.Windows.Forms.ListBox();
            this.label1 = new System.Windows.Forms.Label();
            this.lblMensajes1 = new System.Windows.Forms.Label();
            this.txtMensaje = new System.Windows.Forms.TextBox();
            this.pnlBotones.SuspendLayout();
            this.grbFormato.SuspendLayout();
            this.gpbEstado.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblLibreria
            // 
            this.lblLibreria.AutoSize = true;
            this.lblLibreria.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblLibreria.Location = new System.Drawing.Point(43, 54);
            this.lblLibreria.Name = "lblLibreria";
            this.lblLibreria.Size = new System.Drawing.Size(243, 55);
            this.lblLibreria.TabIndex = 0;
            this.lblLibreria.Text = "LIBRERIA";
            // 
            // lblTitulo
            // 
            this.lblTitulo.AutoSize = true;
            this.lblTitulo.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTitulo.Location = new System.Drawing.Point(27, 144);
            this.lblTitulo.Name = "lblTitulo";
            this.lblTitulo.Size = new System.Drawing.Size(51, 20);
            this.lblTitulo.TabIndex = 1;
            this.lblTitulo.Text = "Titulo:";
            // 
            // lblAutor
            // 
            this.lblAutor.AutoSize = true;
            this.lblAutor.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblAutor.Location = new System.Drawing.Point(28, 176);
            this.lblAutor.Name = "lblAutor";
            this.lblAutor.Size = new System.Drawing.Size(52, 20);
            this.lblAutor.TabIndex = 2;
            this.lblAutor.Text = "Autor:";
            // 
            // lblTema
            // 
            this.lblTema.AutoSize = true;
            this.lblTema.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTema.Location = new System.Drawing.Point(25, 211);
            this.lblTema.Name = "lblTema";
            this.lblTema.Size = new System.Drawing.Size(53, 20);
            this.lblTema.TabIndex = 3;
            this.lblTema.Text = "Tema:";
            // 
            // lblPaginas
            // 
            this.lblPaginas.AutoSize = true;
            this.lblPaginas.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPaginas.Location = new System.Drawing.Point(28, 245);
            this.lblPaginas.Name = "lblPaginas";
            this.lblPaginas.Size = new System.Drawing.Size(70, 20);
            this.lblPaginas.TabIndex = 4;
            this.lblPaginas.Text = "Páginas:";
            // 
            // lblPrecio
            // 
            this.lblPrecio.AutoSize = true;
            this.lblPrecio.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPrecio.Location = new System.Drawing.Point(27, 281);
            this.lblPrecio.Name = "lblPrecio";
            this.lblPrecio.Size = new System.Drawing.Size(57, 20);
            this.lblPrecio.TabIndex = 5;
            this.lblPrecio.Text = "Precio:";
            // 
            // pnlBotones
            // 
            this.pnlBotones.Controls.Add(this.btnSalir);
            this.pnlBotones.Controls.Add(this.btnModificar);
            this.pnlBotones.Controls.Add(this.btnNuevo);
            this.pnlBotones.Controls.Add(this.btnBaja);
            this.pnlBotones.Controls.Add(this.btnAlta);
            this.pnlBotones.Location = new System.Drawing.Point(194, 381);
            this.pnlBotones.Name = "pnlBotones";
            this.pnlBotones.Size = new System.Drawing.Size(231, 129);
            this.pnlBotones.TabIndex = 6;
            // 
            // btnSalir
            // 
            this.btnSalir.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSalir.Location = new System.Drawing.Point(30, 88);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(173, 38);
            this.btnSalir.TabIndex = 4;
            this.btnSalir.Text = "Salir";
            this.btnSalir.UseVisualStyleBackColor = true;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // btnModificar
            // 
            this.btnModificar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnModificar.Location = new System.Drawing.Point(128, 49);
            this.btnModificar.Name = "btnModificar";
            this.btnModificar.Size = new System.Drawing.Size(94, 33);
            this.btnModificar.TabIndex = 3;
            this.btnModificar.Text = "Modificar";
            this.btnModificar.UseVisualStyleBackColor = true;
            this.btnModificar.Click += new System.EventHandler(this.btnModificar_Click);
            // 
            // btnNuevo
            // 
            this.btnNuevo.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnNuevo.Location = new System.Drawing.Point(18, 49);
            this.btnNuevo.Name = "btnNuevo";
            this.btnNuevo.Size = new System.Drawing.Size(87, 33);
            this.btnNuevo.TabIndex = 2;
            this.btnNuevo.Text = "Nuevo";
            this.btnNuevo.UseVisualStyleBackColor = true;
            this.btnNuevo.Click += new System.EventHandler(this.btnNuevo_Click);
            // 
            // btnBaja
            // 
            this.btnBaja.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBaja.Location = new System.Drawing.Point(128, 8);
            this.btnBaja.Name = "btnBaja";
            this.btnBaja.Size = new System.Drawing.Size(94, 35);
            this.btnBaja.TabIndex = 1;
            this.btnBaja.Text = "Baja";
            this.btnBaja.UseVisualStyleBackColor = true;
            this.btnBaja.Click += new System.EventHandler(this.btnBaja_Click);
            // 
            // btnAlta
            // 
            this.btnAlta.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnAlta.Location = new System.Drawing.Point(18, 8);
            this.btnAlta.Name = "btnAlta";
            this.btnAlta.Size = new System.Drawing.Size(87, 35);
            this.btnAlta.TabIndex = 0;
            this.btnAlta.Text = "Alta";
            this.btnAlta.UseVisualStyleBackColor = true;
            this.btnAlta.Click += new System.EventHandler(this.BtnAlta_Click);
            // 
            // grbFormato
            // 
            this.grbFormato.Controls.Add(this.chkTapaDura);
            this.grbFormato.Controls.Add(this.chkRustica);
            this.grbFormato.Controls.Add(this.chkCartone);
            this.grbFormato.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.grbFormato.Location = new System.Drawing.Point(32, 348);
            this.grbFormato.Name = "grbFormato";
            this.grbFormato.Size = new System.Drawing.Size(126, 119);
            this.grbFormato.TabIndex = 7;
            this.grbFormato.TabStop = false;
            this.grbFormato.Text = "Formato";
            // 
            // chkTapaDura
            // 
            this.chkTapaDura.AutoSize = true;
            this.chkTapaDura.Location = new System.Drawing.Point(10, 88);
            this.chkTapaDura.Name = "chkTapaDura";
            this.chkTapaDura.Size = new System.Drawing.Size(112, 24);
            this.chkTapaDura.TabIndex = 2;
            this.chkTapaDura.Text = "Tapa Dura";
            this.chkTapaDura.UseVisualStyleBackColor = true;
            // 
            // chkRustica
            // 
            this.chkRustica.AutoSize = true;
            this.chkRustica.Location = new System.Drawing.Point(10, 65);
            this.chkRustica.Name = "chkRustica";
            this.chkRustica.Size = new System.Drawing.Size(89, 24);
            this.chkRustica.TabIndex = 1;
            this.chkRustica.Text = "Rústica";
            this.chkRustica.UseVisualStyleBackColor = true;
            // 
            // chkCartone
            // 
            this.chkCartone.AutoSize = true;
            this.chkCartone.Location = new System.Drawing.Point(10, 32);
            this.chkCartone.Name = "chkCartone";
            this.chkCartone.Size = new System.Drawing.Size(92, 24);
            this.chkCartone.TabIndex = 0;
            this.chkCartone.Text = "Cartoné";
            this.chkCartone.UseVisualStyleBackColor = true;
            // 
            // gpbEstado
            // 
            this.gpbEstado.Controls.Add(this.rdbReedicion);
            this.gpbEstado.Controls.Add(this.rdbNovedad);
            this.gpbEstado.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.gpbEstado.Location = new System.Drawing.Point(462, 348);
            this.gpbEstado.Name = "gpbEstado";
            this.gpbEstado.Size = new System.Drawing.Size(113, 95);
            this.gpbEstado.TabIndex = 8;
            this.gpbEstado.TabStop = false;
            this.gpbEstado.Text = "Estado";
            // 
            // rdbReedicion
            // 
            this.rdbReedicion.AutoSize = true;
            this.rdbReedicion.Location = new System.Drawing.Point(10, 61);
            this.rdbReedicion.Name = "rdbReedicion";
            this.rdbReedicion.Size = new System.Drawing.Size(107, 24);
            this.rdbReedicion.TabIndex = 1;
            this.rdbReedicion.Text = "Reedición";
            this.rdbReedicion.UseVisualStyleBackColor = true;
            // 
            // rdbNovedad
            // 
            this.rdbNovedad.AutoSize = true;
            this.rdbNovedad.Checked = true;
            this.rdbNovedad.Location = new System.Drawing.Point(10, 31);
            this.rdbNovedad.Name = "rdbNovedad";
            this.rdbNovedad.Size = new System.Drawing.Size(97, 24);
            this.rdbNovedad.TabIndex = 0;
            this.rdbNovedad.TabStop = true;
            this.rdbNovedad.Text = "Novedad";
            this.rdbNovedad.UseVisualStyleBackColor = true;
            // 
            // txtTitulo
            // 
            this.txtTitulo.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtTitulo.Location = new System.Drawing.Point(109, 144);
            this.txtTitulo.Name = "txtTitulo";
            this.txtTitulo.Size = new System.Drawing.Size(190, 26);
            this.txtTitulo.TabIndex = 9;
            // 
            // txtAutor
            // 
            this.txtAutor.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtAutor.Location = new System.Drawing.Point(109, 178);
            this.txtAutor.Name = "txtAutor";
            this.txtAutor.Size = new System.Drawing.Size(190, 26);
            this.txtAutor.TabIndex = 10;
            // 
            // txtPaginas
            // 
            this.txtPaginas.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtPaginas.Location = new System.Drawing.Point(109, 245);
            this.txtPaginas.Name = "txtPaginas";
            this.txtPaginas.Size = new System.Drawing.Size(190, 26);
            this.txtPaginas.TabIndex = 12;
            // 
            // txtPrecio
            // 
            this.txtPrecio.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtPrecio.Location = new System.Drawing.Point(109, 281);
            this.txtPrecio.Name = "txtPrecio";
            this.txtPrecio.Size = new System.Drawing.Size(190, 26);
            this.txtPrecio.TabIndex = 13;
            // 
            // cbxTemas
            // 
            this.cbxTemas.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cbxTemas.FormattingEnabled = true;
            this.cbxTemas.Location = new System.Drawing.Point(109, 213);
            this.cbxTemas.Name = "cbxTemas";
            this.cbxTemas.Size = new System.Drawing.Size(190, 28);
            this.cbxTemas.TabIndex = 14;
            // 
            // lstLibros
            // 
            this.lstLibros.AccessibleDescription = "LstLibros_Click";
            this.lstLibros.FormattingEnabled = true;
            this.lstLibros.Location = new System.Drawing.Point(379, 117);
            this.lstLibros.Name = "lstLibros";
            this.lstLibros.Size = new System.Drawing.Size(178, 225);
            this.lstLibros.TabIndex = 15;
            this.lstLibros.Click += new System.EventHandler(this.LstLibros_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(318, 28);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(81, 20);
            this.label1.TabIndex = 16;
            this.label1.Text = "Mensajes:";
            // 
            // lblMensajes1
            // 
            this.lblMensajes1.AutoSize = true;
            this.lblMensajes1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblMensajes1.Location = new System.Drawing.Point(316, 71);
            this.lblMensajes1.Name = "lblMensajes1";
            this.lblMensajes1.Size = new System.Drawing.Size(81, 20);
            this.lblMensajes1.TabIndex = 17;
            this.lblMensajes1.Text = "Mensajes:";
            // 
            // txtMensaje
            // 
            this.txtMensaje.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtMensaje.Location = new System.Drawing.Point(397, 70);
            this.txtMensaje.Name = "txtMensaje";
            this.txtMensaje.Size = new System.Drawing.Size(218, 26);
            this.txtMensaje.TabIndex = 18;
            // 
            // Libreria
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(627, 549);
            this.Controls.Add(this.txtMensaje);
            this.Controls.Add(this.lblMensajes1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lstLibros);
            this.Controls.Add(this.cbxTemas);
            this.Controls.Add(this.txtPrecio);
            this.Controls.Add(this.txtPaginas);
            this.Controls.Add(this.txtAutor);
            this.Controls.Add(this.txtTitulo);
            this.Controls.Add(this.gpbEstado);
            this.Controls.Add(this.grbFormato);
            this.Controls.Add(this.pnlBotones);
            this.Controls.Add(this.lblPrecio);
            this.Controls.Add(this.lblPaginas);
            this.Controls.Add(this.lblTema);
            this.Controls.Add(this.lblAutor);
            this.Controls.Add(this.lblTitulo);
            this.Controls.Add(this.lblLibreria);
            this.Name = "Libreria";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Libreria";
            this.Load += new System.EventHandler(this.Libreria_Load);
            this.pnlBotones.ResumeLayout(false);
            this.grbFormato.ResumeLayout(false);
            this.grbFormato.PerformLayout();
            this.gpbEstado.ResumeLayout(false);
            this.gpbEstado.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblLibreria;
        private System.Windows.Forms.Label lblTitulo;
        private System.Windows.Forms.Label lblAutor;
        private System.Windows.Forms.Label lblTema;
        private System.Windows.Forms.Label lblPaginas;
        private System.Windows.Forms.Label lblPrecio;
        private System.Windows.Forms.Panel pnlBotones;
        private System.Windows.Forms.GroupBox grbFormato;
        private System.Windows.Forms.CheckBox chkTapaDura;
        private System.Windows.Forms.CheckBox chkRustica;
        private System.Windows.Forms.CheckBox chkCartone;
        private System.Windows.Forms.GroupBox gpbEstado;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.Button btnModificar;
        private System.Windows.Forms.Button btnNuevo;
        private System.Windows.Forms.Button btnBaja;
        private System.Windows.Forms.Button btnAlta;
        private System.Windows.Forms.TextBox txtTitulo;
        private System.Windows.Forms.TextBox txtAutor;
        private System.Windows.Forms.TextBox txtPaginas;
        private System.Windows.Forms.TextBox txtPrecio;
        private System.Windows.Forms.ComboBox cbxTemas;
        private System.Windows.Forms.ListBox lstLibros;
        private System.Windows.Forms.RadioButton rdbReedicion;
        private System.Windows.Forms.RadioButton rdbNovedad;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblMensajes1;
        private System.Windows.Forms.TextBox txtMensaje;
    }
}

