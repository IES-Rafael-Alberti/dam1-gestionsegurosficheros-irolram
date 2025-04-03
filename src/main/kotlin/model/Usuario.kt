package model


open class Usuario(val nombre: String, clave: String,  val perfil: Perfil): IExportable {
    var clave = clave
        private set

    companion object{

        fun crearUsuario(datos: List<String>): Usuario? {

            val nombre = datos[0]
            val clave = datos[1]
            val perfil = Perfil.getPerfil(datos[2])
            return Usuario(nombre,clave, perfil)
        }
    }


    override fun serializar(separador: String): String {
        return "$nombre$separador$clave$separador$perfil"
    }

    fun cambiarClave(nuevaClaveEncriptada: String){

         clave = nuevaClaveEncriptada
    }

}