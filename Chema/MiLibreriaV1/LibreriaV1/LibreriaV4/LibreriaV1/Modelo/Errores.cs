using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibreriaV2.Modelo
{
    class Errores : Exception
    {
        Exception _error;
        public Errores(Exception e)
        {
            _error = e;
        }

        public override string Message { get; }
    }

}
