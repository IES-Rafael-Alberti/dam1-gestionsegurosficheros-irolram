package model

import kotlin.collections.get

open class Usuario(val nombre: String,protected var clave: String,  val perfil: String): IExportable {

    companion object{

        val usuarios = mutableSetOf<String>()
        fun crearUsuario(datos: List<String>): Usuario? {
            return try {
                if (datos.size != 3) throw IllegalArgumentException("Debe tener 3 valores: nombre, clave y perfil")

                val nombre = datos[0]
                val clave = datos[1]
                val perfil = datos[2]

                if (usuarios.contains(nombre)) {
                    throw IllegalArgumentException("El nombre de usuario ya existe.")
                }

                val usuario = Usuario(nombre, clave, perfil)
                if (usuarios.add(nombre)) usuario else throw IllegalStateException("Error al registrar el usuario.")
            } catch (e: Exception) {
                println("Error al crear usuario: ${'$'}${e.message}")
                null
            }
        }
    }


    override fun serializar(separador: String): String {
        return "$nombre$separador$clave$separador$perfil"
    }

    fun cambiarClave(nuevaClaveEncriptada: String){

         clave = nuevaClaveEncriptada
    }

}