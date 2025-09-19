VERSION 5.00
Begin VB.Form frmBiblioteca 
   Caption         =   "Gestión Libros"
   ClientHeight    =   5520
   ClientLeft      =   6885
   ClientTop       =   3030
   ClientWidth     =   6480
   LinkTopic       =   "Form1"
   ScaleHeight     =   5520
   ScaleWidth      =   6480
   Begin VB.Frame frmEstado 
      Caption         =   "Estado"
      Height          =   975
      Left            =   4680
      TabIndex        =   21
      ToolTipText     =   "Estado del libro"
      Top             =   2640
      Width           =   1695
      Begin VB.OptionButton Reedicion 
         Caption         =   "Reedicion"
         Height          =   255
         Left            =   120
         TabIndex        =   8
         Top             =   600
         Width           =   1455
      End
      Begin VB.OptionButton Novedad 
         Caption         =   "Novedad"
         Height          =   255
         Left            =   120
         TabIndex        =   7
         Top             =   240
         Width           =   1455
      End
   End
   Begin VB.Frame frmFormato 
      Caption         =   "Formato"
      Height          =   1335
      Left            =   4680
      TabIndex        =   20
      ToolTipText     =   "Tipo de encuadernación"
      Top             =   1080
      Width           =   1695
      Begin VB.CheckBox chkTapaDura 
         Caption         =   "Tapa Dura"
         Height          =   255
         Left            =   120
         TabIndex        =   6
         Top             =   960
         Width           =   1455
      End
      Begin VB.CheckBox chkRustica 
         Caption         =   "Rústica"
         Height          =   255
         Left            =   120
         TabIndex        =   5
         Top             =   600
         Width           =   1455
      End
      Begin VB.CheckBox chkCartone 
         Caption         =   "Cartoné"
         Height          =   255
         Left            =   120
         TabIndex        =   4
         Top             =   240
         Width           =   1455
      End
   End
   Begin VB.ListBox lvwDisponible 
      Height          =   1425
      Left            =   3840
      TabIndex        =   19
      TabStop         =   0   'False
      ToolTipText     =   "Libros disponibles"
      Top             =   3960
      Width           =   2415
   End
   Begin VB.ComboBox cboTemaL 
      Height          =   315
      Left            =   1440
      TabIndex        =   13
      ToolTipText     =   "Seleccione el tema del libro"
      Top             =   2400
      Width           =   1695
   End
   Begin VB.CommandButton cmdSalir 
      Caption         =   "&Salir"
      Height          =   375
      Left            =   1680
      TabIndex        =   12
      ToolTipText     =   "Salir de la aplicacion"
      Top             =   4680
      Width           =   1215
   End
   Begin VB.CommandButton cmdBajas 
      Caption         =   "&Bajas"
      Height          =   375
      Left            =   1680
      TabIndex        =   11
      ToolTipText     =   "Borrado de libros"
      Top             =   3960
      Width           =   1215
   End
   Begin VB.CommandButton cmdAltas 
      Caption         =   "&Altas"
      Height          =   375
      Left            =   120
      TabIndex        =   10
      ToolTipText     =   "Altas de nuevos libros"
      Top             =   4680
      Width           =   1215
   End
   Begin VB.CommandButton cmdNuevo 
      Caption         =   "&Nuevo"
      Height          =   375
      Left            =   120
      TabIndex        =   9
      ToolTipText     =   "Introducción de nuevos libros"
      Top             =   3960
      Width           =   1215
   End
   Begin VB.TextBox txtPaginasL 
      Height          =   285
      Left            =   1440
      TabIndex        =   3
      ToolTipText     =   "Número de páginas"
      Top             =   3000
      Width           =   735
   End
   Begin VB.TextBox txtAutorL 
      Height          =   285
      Left            =   1440
      TabIndex        =   1
      ToolTipText     =   "Nombre del autor"
      Top             =   1800
      Width           =   2535
   End
   Begin VB.TextBox txtTituloL 
      Height          =   285
      Left            =   1440
      TabIndex        =   0
      ToolTipText     =   "Título del libro"
      Top             =   1200
      Width           =   2535
   End
   Begin VB.Label lblLibros 
      Caption         =   "Libros"
      Height          =   255
      Left            =   3840
      TabIndex        =   18
      Top             =   3720
      Width           =   1215
   End
   Begin VB.Label lblPagina 
      Alignment       =   2  'Center
      Caption         =   "Num. PÁGINAS"
      Height          =   255
      Left            =   120
      TabIndex        =   17
      Top             =   3000
      Width           =   1215
   End
   Begin VB.Label lblTema 
      Alignment       =   2  'Center
      Caption         =   "TEMA"
      Height          =   255
      Left            =   120
      TabIndex        =   16
      Top             =   2400
      Width           =   1215
   End
   Begin VB.Label lblAutor 
      Alignment       =   2  'Center
      Caption         =   "AUTOR"
      Height          =   255
      Left            =   120
      TabIndex        =   15
      Top             =   1800
      Width           =   1215
   End
   Begin VB.Label lblTitulo 
      Alignment       =   2  'Center
      Caption         =   "TÍTULO"
      Height          =   255
      Left            =   120
      TabIndex        =   14
      Top             =   1200
      Width           =   1215
   End
   Begin VB.Label lblCabecera 
      Alignment       =   2  'Center
      Caption         =   "LIBRERÍA"
      BeginProperty Font 
         Name            =   "Arial Black"
         Size            =   27.75
         Charset         =   0
         Weight          =   900
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000C0000&
      Height          =   615
      Left            =   1080
      TabIndex        =   2
      Top             =   120
      Width           =   3855
   End
End
Attribute VB_Name = "frmBiblioteca"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Private Sub cmdAltas_Click() 'COMANDO Altas
   
    'Compruebo que el titulo del libro no esté vacío
    If txtTituloL.Text <> "" Then
        'Compruebo que caben más libros en el array
        If Reg < tamano Then
            'Compruebo si el libro ya existe
            If Buscador(txtTituloL) <= 0 Then
                
                Reg = Reg + 1
            
                TLibros(Reg).TTitulo = txtTituloL.Text
                TLibros(Reg).TAutor = txtAutorL.Text
                TLibros(Reg).TTema = cboTemaL.Text
                TLibros(Reg).TPaginas = Val(txtPaginasL.Text)
                
            
                'comprobamos el tipo de formato del libro
                If chkCartone.Value = 1 Then 'si se ha seleccionado Cartone
                  TLibros(Reg).TFormato(1) = "Cartoné"
                End If
                If chkRustica.Value = 1 Then 'si se ha seleccionado Rustica
                   TLibros(Reg).TFormato(2) = "Rústica"
                End If
                If chkTapaDura.Value = 1 Then 'si se ha seleccionado Tapa Dura
                    TLibros(Reg).TFormato(3) = "Tapa Dura"
                End If
                
                'comprobamos el estado del libro
                If Novedad.Value = True Then
                    TLibros(Reg).TEstado = "Novedad"
                End If
                If Reedicion.Value = True Then
                    TLibros(Reg).TEstado = "Reedicion"
                End If
                
                'añadimos el titulo del libro a la lista desplegable
                lvwDisponible.AddItem txtTituloL.Text
                
                'Borramos campos
                BorrarCampos
                Else
                    MsgBox ("El libro ya esta")
                End If
             Else
             MsgBox ("Alcanzado maximo libros")
            End If
      Else
          MsgBox ("Titulo vacío")
      End If
    
End Sub

Private Sub cmdBajas_Click() 'COMANDO Bajas aqui eliminamos los elementos de la lista
Dim Respuesta As Integer 'almacena el valor de la respuesta
Respuesta = MsgBox("¿Esta seguro que desea borrarlo?", vbYesNo, "ATENCION") 'pregunta si se desea borrarlo
  If Respuesta = 6 Then
    'Miro cual es el libro seleccionado y guardo su posicion
    Pos = Buscador(lvwDisponible)
   
    'Movemos todos los elementos del array una posicion hacia la izquierda
    While Pos < tamano
        TLibros(Pos) = TLibros(Pos + 1)
        Pos = Pos + 1
    Wend
    
    lvwDisponible.RemoveItem (lvwDisponible.ListIndex)
    txtTituloL.Text = ""
    txtAutorL.Text = ""
    txtPaginasL.Text = ""
    cboTemaL.Text = ""
    chkCartone.Value = 0
    chkRustica.Value = 0
    chkTapaDura.Value = 0
    Novedad.Value = False
    Reedicion.Value = False
    
    'Disminuimos la posicion del Reg
    Reg = Reg - 1

  End If
cmdBajas.Enabled = False 'desactivacion del boton bajas


End Sub

Private Sub cmdNuevo_Click() 'COMANDO Nuevo
    'Desactivamos los campos editables
    ActivarDesactivar (True)
    'Borramos los campos
    BorrarCampos
    'Activacion del boton Altas
    cmdAltas.Enabled = True
    'Desactivacion del boton Bajas
    cmdBajas.Enabled = False
    

End Sub

Private Sub cmdSalir_Click() 'COMANDO Salir
End 'instruccion que finaliza la ejecuccion del programa
End Sub

Private Sub Form_Load() 'FORMULARIO AL CARGARSE LA APLICACION
Reg = 0 'Inicializacion de la variable contador Reg a 0
    'le asignamos al cuadro combinado TemaL los diferentes temas a mostrar en el formulario
    cboTemaL.AddItem "Acción"
    cboTemaL.AddItem "Aventuras"
    cboTemaL.AddItem "Biografía"
    cboTemaL.AddItem "Ciencia"
    cboTemaL.AddItem "Ciencia Ficción"
    cboTemaL.AddItem "Cine"
    cboTemaL.AddItem "Economía"
    cboTemaL.AddItem "Gastronomía"
    cboTemaL.AddItem "Historia"
    cboTemaL.AddItem "Informática"
    cboTemaL.AddItem "Medicina"
    cboTemaL.AddItem "Misterio"
    cboTemaL.AddItem "Naturaleza"
    cboTemaL.AddItem "Policíaco"
    cboTemaL.AddItem "Política"
    cboTemaL.AddItem "Romántica"
    cboTemaL.AddItem "Teatro"
    cboTemaL.AddItem "Terror"
    
    'Desactivacion del boton Bajas
    cmdBajas.Enabled = False
    
    
End Sub

Private Sub lvwDisponible_Click() 'LISTA
 'Desactivamos los campos editables
    ActivarDesactivar (True)
'Borramos los campos
BorrarCampos

'Desactivamos los campos editables
ActivarDesactivar (False)

'busca en la tabla el libro seleccionado de la lista para visualizar en la ficha todos sus datos
Dim X As Integer 'Recoge la posicion del buscador
X = Buscador(lvwDisponible)

'Llamo al modulo que rellena los datos del libro seleccionado
Call Rellenar(X)


'Activacion del boton Bajas
cmdBajas.Enabled = True

chkCartone.Value = 0 'Inicializacion de las casillas de verificacion
chkRustica.Value = 0
chkTapaDura.Value = 0


   
End Sub

Private Function Buscador(lvwDisponible) As Integer
    Dim X  As Integer 'declaracion de la variable contador x
    Dim bandera As Boolean
    bandera = False
    X = 1
    Do
        If RTrim(lvwDisponible.Text) = RTrim(TLibros(X).TTitulo) Or (RTrim(txtTituloL.Text) = RTrim(TLibros(X).TTitulo)) Then
            bandera = True
            Buscador = X
            Else
            Buscador = -1
        End If
        X = X + 1
    Loop While (X <= tamano And bandera = False)
    
    End Function
Private Function Rellenar(X)
      
        
        txtTituloL.Text = TLibros(X).TTitulo
        txtAutorL.Text = TLibros(X).TAutor
        cboTemaL.Text = TLibros(X).TTema
        txtPaginasL.Text = TLibros(X).TPaginas
                   
        'comprobamos el tipo de formato del libro
        If RTrim(TLibros(X).TFormato(1)) = "Cartoné" Then
            chkCartone.Value = 1
        End If
        If RTrim(TLibros(X).TFormato(2)) = "Rústica" Then
            chkRustica.Value = 1
        End If
        If RTrim(TLibros(X).TFormato(3)) = "Tapa Dura" Then
            chkTapaDura.Value = 1
        End If
        
        ''comprobamos el estado del libro
        If RTrim(TLibros(X).TEstado) = "Novedad" Then
            Novedad.Value = True
        Else
            Reedicion.Value = True
        End If
        
    'Desactivacion del boton Altas
    cmdAltas.Enabled = False
End Function

Private Sub BorrarCampos()
    txtTituloL.Text = "" 'borra el contenido de la ficha inicializando los valores
    txtAutorL.Text = ""
    txtPaginasL.Text = ""
    cboTemaL.Text = ""
    chkCartone.Value = 0
    chkRustica.Value = 0
    chkTapaDura.Value = 0
    Novedad.Value = False
    Reedicion.Value = False
    txtTituloL.SetFocus 'colocamos el cursor en la caja de texto del titulo
End Sub

Private Sub ActivarDesactivar(condicion As Boolean)
        frmFormato.Enabled = condicion
        frmEstado.Enabled = condicion
        txtTituloL.Enabled = condicion
        txtAutorL.Enabled = condicion
        cboTemaL.Enabled = condicion
        txtPaginasL.Enabled = condicion
End Sub

