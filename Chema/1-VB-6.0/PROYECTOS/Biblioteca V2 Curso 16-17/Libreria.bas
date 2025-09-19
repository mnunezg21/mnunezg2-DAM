Attribute VB_Name = "Module1"
Option Explicit 'declaracion del registro

Type Libreria
    TTitulo As String * 25 'creacion de las variables cadena
    TAutor As String * 25
    TTema As String * 15
    TPaginas As Integer

    TFormato(1 To 3) As String * 10
    TEstado As String * 10
    
End Type

Global Const tamano As Integer = 5
Global TLibros(1 To tamano) As Libreria 'tabla de registros
Global Reg As Integer 'declaracion del contador de registros de tipo entero
Global Pos As Integer 'posicion del registro a borrar





    
