package data

import model.Perfil
import model.Usuario

class RepoUsuariosFich: RepoUsuariosMem() {
    override fun agregar(usuario: Usuario): Boolean {
        return super.agregar(usuario)
    }

    override fun buscar(nombreUsuario: String): Usuario? {
        return super.buscar(nombreUsuario)
    }

    override fun eliminar(usuario: Usuario): Boolean {
        return super.eliminar(usuario)
    }

    override fun eliminar(nombreUsuario: String): Boolean {
        return super.eliminar(nombreUsuario)
    }

    override fun obtenerTodos(): List<Usuario> {
        return super.obtenerTodos()
    }

    override fun obtener(perfil: Perfil): List<Usuario> {
        return super.obtener(perfil)
    }

    override fun cambiarClave(usuario: Usuario, nuevaClave: String): Boolean {
        return super.cambiarClave(usuario, nuevaClave)
    }

}