Attribute VB_Name = "Module1"
Option Explicit

'Declaración del registro
Type Libreria
        TTitulo As String * 25
        TAutor As String * 25
        TTema As String * 15
        TPaginas As Integer
        TFormato(1 To 3) As String * 10 'Tabla de formatos del libro
        TEstado As String * 10
End Type
Public Const MaxReg = 3
Public tlibros(1 To MaxReg) As Libreria      'Tabla de registros
Public Reg As Integer                   'Contador de registro
