using LibreriaV5_Final.Vista;
using System;
using System.Windows.Forms;

namespace LibreriaV5_Final
{
    static class Program
    {
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new FrmPrincipal());
           
        }
    }
}
