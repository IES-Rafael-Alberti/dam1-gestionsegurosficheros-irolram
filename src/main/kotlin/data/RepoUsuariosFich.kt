package data

import model.Perfil
import model.Usuario
import utils.Ficheros

class RepoUsuariosFich: RepoUsuariosMem() {

    val fich = Ficheros()
    val repoUsuMem = RepoUsuariosMem()

    override fun agregar(usuario: Usuario): Boolean {

        for (usuariolista in listUsuarios) {
            if (usuariolista.nombre == usuario.nombre) {
                fich.agregarLinea(ruta, linea)
                return false
            }else if(){
                return repoUsuMem.agregar(usuario)
            }
        }
        return false
    }


    override fun eliminar(usuario: Usuario): Boolean {

        if (fich.escribirArchivo(rutaArchivo, usuarios.filter { it != usuario })) {
            return super.eliminar(usuario)
        }
        return false

    }


    fun cargarUsuarios():Boolean {

    }

}