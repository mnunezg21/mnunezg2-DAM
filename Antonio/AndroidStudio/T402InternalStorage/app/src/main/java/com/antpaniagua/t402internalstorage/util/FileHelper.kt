package com.antpaniagua.t402internalstorage.util

import android.content.Context
import java.io.File

/**
 * FileHelper
 *
 * Biblioteca que recoge varias operaciones de gestión de archivos
 * * https://developer.android.com/training/data-storage/app-specific
 */

/**
 * createFile
 *
 * Genera un archivo con el contenido indicado
 *
 * context: el contexto donde se va a crear el archivo
 * filename: nombre del archivo
 * content: contenido del archivo
 * Función llamada desde una expresión lambda
 */
fun createFile(context: Context, filename: String, content: String) {
    context.openFileOutput(filename, Context.MODE_PRIVATE).use {
        it.write(content.toByteArray())
    }
}

/**
 * Lectura de un archivo
 */
fun readFile(context: Context, filename: String): String {
    return context.openFileInput(filename
    ).bufferedReader().useLines { lines ->
        lines.fold("") { some, text ->
            "$some\n$text"
        }
    }
}

/**
 * Actualiza el contenido de un archivo existente eliminando el anterior
 *
 * Lo más directo es sobreescribir
 */
fun updateFile(context: Context, filename: String, newContent: String) {
    createFile(context, filename, newContent)
}

/**
 * Añade contenido a un archivo existente
 */
fun appendToFile(context: Context, filename: String, newContent: String) {
    // Usamos el modo MODE_APPEND para añadir contenido en lugar de sobreescribir
    context.openFileOutput(filename, Context.MODE_APPEND).use {
        it.write(newContent.toByteArray())
    }
}

/**
 * Borrado de un archivo en la carpeta raiz
 */
fun deleteFile(context: Context, filename: String) {
    val file = File(context.filesDir, filename)
    file.delete()
}

/**
 * Sobrecarga del borrado, usando el nombre de la carpeta
 */
fun deleteFile(context: Context, folder: String, filename: String) {
    // Construir la ruta al directorio de la carpeta
    val directory = File(context.filesDir, folder)
    // Crear el objeto File dentro de ese directorio
    val file = File(directory, filename)
    file.delete()
}

/** Funciones para carpetas */

/**
 * Generar una carpeta en el raíz, fuera de files
 */
fun createMainFolder(context: Context, foldername: String) {
    context.getDir(foldername, Context.MODE_PRIVATE)
}

/**
 * Genera una carpeta en la carpeta files
 */
fun createFolder(context: Context, foldername: String) {
    val folder = File(context.filesDir, foldername)
    folder.mkdir()
}

/**
 * Leer el contenido de una carpeta
 * returns: Array de nombres de archivos y carpetas
 */
fun readFolder(context: Context): Array<String> {
    return context.fileList()
}

/**
 * Leer el contenido de una subcarpeta y devuelve sólo subcarpetas
 * returns: Array de nombres de archivos y carpetas
 */
fun readSubFolders(context: Context, subFolder: String): Array<File> {
    val path = subFolder
    val folders = File(path).listFiles { pathname -> pathname.isDirectory }
    return folders
}

/**
 * Borrado de una carpeta
 */
fun deleteFolder(context: Context, folderName: String) {
    // Ruta a la carpeta dentro del directorio filesDir
    val folder = File(context.filesDir, folderName)
    // deleteRecursively borra la carpeta y su contenido
    folder.deleteRecursively()
}


/**
 * Crea un archivo de prueba en la carpeta de descargas del móvil
 */
fun createTestFileInDownloads(filename: String, content: String) {
    val downloadsDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS)
    val file = File(downloadsDir, filename)
    file.writeText(content)
}


/** Espacios comunes */

/**
 * Crea una carpeta en la carpeta de Descargas del móvil
 */
fun createDownloadFolder(foldername: String) {
    val downloadsDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS)
    val folder = File(downloadsDir, foldername)
    if (!folder.exists()) {
        folder.mkdir()
    }
}

