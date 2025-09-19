VERSION 5.00
Begin VB.Form fmdBiblioteca 
   Caption         =   "."
   ClientHeight    =   5535
   ClientLeft      =   60
   ClientTop       =   435
   ClientWidth     =   6480
   LinkTopic       =   "Form1"
   ScaleHeight     =   5535
   ScaleWidth      =   6480
   StartUpPosition =   3  'Windows Default
   Begin VB.Frame frmEstado 
      Caption         =   "Estado"
      Height          =   975
      Left            =   4680
      TabIndex        =   21
      ToolTipText     =   "Estado del libro"
      Top             =   2640
      Width           =   1695
      Begin VB.OptionButton optReedicion 
         Caption         =   "Reedición"
         Height          =   255
         Left            =   120
         TabIndex        =   8
         Top             =   600
         Width           =   1335
      End
      Begin VB.OptionButton optNovedad 
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
   Begin VB.ListBox lstDisponible 
      Height          =   1425
      Left            =   3840
      TabIndex        =   19
      TabStop         =   0   'False
      ToolTipText     =   "Libros disponibles"
      Top             =   3960
      Width           =   2415
   End
   Begin VB.ComboBox cmbTemaL 
      Height          =   315
      Left            =   1440
      TabIndex        =   2
      ToolTipText     =   "Seleccione el tema del libro"
      Top             =   2400
      Width           =   1695
   End
   Begin VB.CommandButton cmdSalir 
      Caption         =   "&Salir"
      Height          =   375
      Left            =   1680
      TabIndex        =   12
      ToolTipText     =   "Salir de la aplicación"
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
      Caption         =   " &Nuevo"
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
      Caption         =   "Num PÁGINAS"
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
      TabIndex        =   13
      Top             =   120
      Width           =   3855
   End
End
Attribute VB_Name = "fmdBiblioteca"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Option Explicit
Private pos As Integer
'Añade un nuevo libro
Private Sub cmdAltas_Click()
    'Comprueba si la lista está llena
    If Reg < MaxReg Then
        'Comprueba si ya esta el libro escrito en la lista
        pos = BuscarLibro(tlibros(), txtTituloL.Text)
        If pos = -1 Then    'El valor -1 significa no encontrado
            Reg = Reg + 1
            tlibros(Reg).TTitulo = txtTituloL.Text
            tlibros(Reg).TAutor = txtAutorL.Text
            tlibros(Reg).TTema = cmbTemaL.Text
            tlibros(Reg).TPaginas = Val(txtPaginasL.Text)
        
            'Comprueba el tipo de formato del libro
            If chkCartone.Value = 1 Then
                tlibros(Reg).TFormato(1) = "Cartoné"
            End If
            If chkRustica.Value = 1 Then
                tlibros(Reg).TFormato(2) = "Rustica"
            End If
            If chkTapaDura.Value = 1 Then
                tlibros(Reg).TFormato(3) = "Tapa Dura"
            End If
        
            'Comprueba el estado del libro
            If optNovedad.Value = True Then
                tlibros(Reg).TEstado = "Novedad"
            End If
            If optReedicion.Value = True Then
                tlibros(Reg).TEstado = "Reedición"
            End If
        
            'Añade el título del libro a la lista
            lstDisponible.AddItem txtTituloL.Text
            
        Else
            MsgBox ("El libro ya se encuentra en la lista")
        End If
    Else
        MsgBox ("La tabla está llena")
    End If
End Sub
'Elimina un elemento de la lista
Private Sub cmdBajas_Click()
        Dim Respuesta As Integer 'Almacena el valor de la respuesta
        Respuesta = MsgBox("¿Está seguro de borrarlo?", vbYesNo, "ATENCIÓN")
        If Respuesta = 6 Then
                Call BorrarDatos(tlibros(), pos)
        End If
        cmdBajas.Enabled = False 'Desactivación del botón bajas
End Sub

'Borra el contenido de la ficha inicializando los valores
Private Sub cmdNuevo_Click()
        txtTituloL.Text = ""
        txtAutorL.Text = ""
        txtPaginasL.Text = ""
        cmbTemaL.Text = ""
        chkCartone.Value = 0
        chkRustica.Value = 0
        chkTapaDura.Value = 0
        optNovedad.Value = False
        optReedicion.Value = False
        'Coloca el cursor en la caja del texto del título
        txtTituloL.SetFocus
End Sub

Private Sub cmdSalir_Click()
        End 'Finaliza el programa
End Sub

Private Sub Form_Load()
        Reg = 0
        cmbTemaL.AddItem "Acción"
        cmbTemaL.AddItem "Aventuras"
        cmbTemaL.AddItem "Biografía"
        cmbTemaL.AddItem "Ciencia"
        cmbTemaL.AddItem "Ciencia Ficción"
        cmbTemaL.AddItem "Cine"
        cmbTemaL.AddItem "Economía"
        cmbTemaL.AddItem "Gastronomía"
        cmbTemaL.AddItem "Historia"
        cmbTemaL.AddItem "Informática"
        cmbTemaL.AddItem "Medicina"
        cmbTemaL.AddItem "Misterio"
        cmbTemaL.AddItem "Naturaleza"
        cmbTemaL.AddItem "Policíaco"
        cmbTemaL.AddItem "Política"
        cmbTemaL.AddItem "Romántica"
        cmbTemaL.AddItem "Teatro"
        cmbTemaL.AddItem "Terror"
        
        'Desactivación del botón Bajas
        cmdBajas.Enabled = False
End Sub

'Busca en la tabla el libro seleccionado de la lista
'para visualizar en la ficha todos sus datos
Private Sub lstDisponible_Click()
        'Activación del botón Bajas
        cmdBajas.Enabled = True
        pos = BuscarLibro(tlibros(), lstDisponible.Text)
        Call CargarDatos(tlibros(), pos)
End Sub

Private Function BuscarLibro(tlibros() As Libreria, ByVal titulo As String) As Integer
    Dim i As Integer
  
    BuscarLibro = -1
    i = 1
    Do While i <= Reg And Reg <> 0 And BuscarLibro = -1
       If RTrim(tlibros(i).TTitulo) = RTrim(titulo) Then
          BuscarLibro = i
       End If
       i = i + 1
    Loop
    
End Function

Private Sub CargarDatos(tlibros() As Libreria, ByVal pos As Integer)
        
        'Inicialización de casillas de verificación
        chkCartone.Value = 0
        chkRustica.Value = 0
        chkTapaDura.Value = 0
        txtTituloL.Text = tlibros(pos).TTitulo
        txtAutorL.Text = tlibros(pos).TAutor
        cmbTemaL.Text = tlibros(pos).TTema
        txtPaginasL.Text = Str(tlibros(pos).TPaginas)
                        
        'Comprueba el tipo de formato del libro
        If RTrim(tlibros(pos).TFormato(1)) = "Cartoné" Then
            chkCartone.Value = 1
        End If
        If RTrim(tlibros(pos).TFormato(2)) = "Rustica" Then
            chkRustica.Value = 1
        End If
        If RTrim(tlibros(pos).TFormato(3)) = "Tapa Dura" Then
            chkTapaDura.Value = 1
        End If
        
        'Comprueba el estado del libro
        If RTrim(tlibros(pos).TEstado) = "Novedad" Then
            optNovedad.Value = True
        Else
            optReedicion.Value = True
        End If
                        
End Sub

Private Sub BorrarDatos(tlibros() As Libreria, pos As Integer)
    'Comprueba que no sea el ultimo registro
    If Reg <> pos Then
        tlibros(pos).TTitulo = tlibros(Reg).TTitulo
        tlibros(pos).TAutor = tlibros(Reg).TAutor
        tlibros(pos).TPaginas = tlibros(Reg).TPaginas
        tlibros(pos).TTema = tlibros(Reg).TTema
        tlibros(pos).TFormato(1) = tlibros(Reg).TFormato(1)
        tlibros(pos).TFormato(2) = tlibros(Reg).TFormato(2)
        tlibros(pos).TFormato(3) = tlibros(Reg).TFormato(3)
        tlibros(pos).TEstado = tlibros(Reg).TEstado
        '****** Estas ordenes se pueden sustituir por
        '****** por tlibros(pos)=tlibros(Reg) **********************
    End If
    
    Reg = Reg - 1   'Disminuye el total del registro borrando la última entrada
    'Elimina la posición de la lista
    lstDisponible.RemoveItem lstDisponible.ListIndex
End Sub
