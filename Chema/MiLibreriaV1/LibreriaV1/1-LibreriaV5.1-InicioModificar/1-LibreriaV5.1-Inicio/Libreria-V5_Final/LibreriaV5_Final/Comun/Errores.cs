using System;


namespace LibreriaV5_Final.Comun
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

