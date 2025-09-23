namespace Prueba
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
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            fontDialog1 = new FontDialog();
            textBox1 = new TextBox();
            textBox2 = new TextBox();
            textBox3 = new TextBox();
            textBox4 = new TextBox();
            listBox1 = new ListBox();
            label8 = new Label();
            label9 = new Label();
            textBox5 = new TextBox();
            textBox6 = new TextBox();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 40F);
            label1.ForeColor = Color.Black;
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(301, 89);
            label1.TabIndex = 0;
            label1.Text = "LIBRERIA";
            label1.Click += label1_Click_1;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 15F);
            label2.Location = new Point(24, 112);
            label2.Name = "label2";
            label2.Size = new Size(82, 35);
            label2.TabIndex = 1;
            label2.Text = "Título:";
            label2.Click += this.label2_Click;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 15F);
            label3.Location = new Point(24, 309);
            label3.Name = "label3";
            label3.Size = new Size(89, 35);
            label3.TabIndex = 2;
            label3.Text = "Precio:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 15F);
            label4.Location = new Point(10, 263);
            label4.Name = "label4";
            label4.Size = new Size(105, 35);
            label4.TabIndex = 3;
            label4.Text = "Páginas:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI", 15F);
            label5.Location = new Point(24, 211);
            label5.Name = "label5";
            label5.Size = new Size(79, 35);
            label5.TabIndex = 4;
            label5.Text = "Tema:";
            label5.Click += this.label5_Click;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new Font("Segoe UI", 15F);
            label6.Location = new Point(24, 157);
            label6.Name = "label6";
            label6.Size = new Size(82, 35);
            label6.TabIndex = 5;
            label6.Text = "Autor:";
            label6.Click += label6_Click;
            // 
            // textBox1
            // 
            textBox1.Location = new Point(119, 120);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(138, 27);
            textBox1.TabIndex = 6;
            textBox1.TextChanged += textBox1_TextChanged_1;
            // 
            // textBox2
            // 
            textBox2.Location = new Point(119, 272);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(138, 27);
            textBox2.TabIndex = 7;
            // 
            // textBox3
            // 
            textBox3.Location = new Point(119, 165);
            textBox3.Name = "textBox3";
            textBox3.Size = new Size(138, 27);
            textBox3.TabIndex = 7;
            textBox3.TextChanged += this.textBox3_TextChanged;
            // 
            // textBox4
            // 
            textBox4.Location = new Point(119, 318);
            textBox4.Name = "textBox4";
            textBox4.Size = new Size(138, 27);
            textBox4.TabIndex = 8;
            // 
            // listBox1
            // 
            listBox1.FormattingEnabled = true;
            listBox1.Location = new Point(468, 108);
            listBox1.Name = "listBox1";
            listBox1.Size = new Size(201, 324);
            listBox1.TabIndex = 9;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Font = new Font("Segoe UI", 15F);
            label8.Location = new Point(345, 53);
            label8.Name = "label8";
            label8.Size = new Size(123, 35);
            label8.TabIndex = 11;
            label8.Text = "Mensajes:";
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Font = new Font("Segoe UI", 10F);
            label9.Location = new Point(378, 23);
            label9.Name = "label9";
            label9.Size = new Size(84, 23);
            label9.TabIndex = 10;
            label9.Text = "Mensajes:";
            label9.Click += label7_Click;
            // 
            // textBox5
            // 
            textBox5.Location = new Point(468, 61);
            textBox5.Name = "textBox5";
            textBox5.Size = new Size(201, 27);
            textBox5.TabIndex = 12;
            // 
            // textBox6
            // 
            textBox6.Location = new Point(468, 23);
            textBox6.Name = "textBox6";
            textBox6.Size = new Size(201, 27);
            textBox6.TabIndex = 13;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(681, 581);
            Controls.Add(textBox6);
            Controls.Add(textBox5);
            Controls.Add(label8);
            Controls.Add(label9);
            Controls.Add(listBox1);
            Controls.Add(textBox4);
            Controls.Add(textBox3);
            Controls.Add(textBox2);
            Controls.Add(textBox1);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private FontDialog fontDialog1;
        private TextBox textBox1;
        private TextBox textBox2;
        private TextBox textBox3;
        private TextBox textBox4;
        private ListBox listBox1;
        private Label label8;
        private Label label9;
        private TextBox textBox5;
        private TextBox textBox6;
    }
}
