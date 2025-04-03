package service

import data.IRepoUsuarios
import data.RepoUsuariosMem
import model.Perfil
import model.Usuario
import utils.IUtilSeguridad

class GestorUsuarios(    private val repoUsuario: IRepoUsuarios,
                         private val seguridad: IUtilSeguridad
) :IServUsuarios{


    override fun iniciarSesion(nombre: String, clave: String): Perfil? {
        val usuario = buscarUsuario(nombre)
        if (usuario != null && seguridad.verificarClave(clave, usuario.clave )){
            return usuario.perfil
        }else{
            return null
        }
    }

    override fun agregarUsuario(nombre: String, clave: String, perfil: Perfil): Boolean {
        val claveEncriptada = seguridad.encriptarClave(clave)
        val usuario = Usuario(nombre,claveEncriptada, perfil)
        return repoUsuario.agregar(usuario)
    }

    override fun eliminarUsuario(nombre: String): Boolean {
        return repoUsuario.eliminar(nombre)
    }

    override fun cambiarClave(usuario: Usuario, nuevaClave: String): Boolean {

        val nuevaClaveEncriptada = seguridad.encriptarClave(nuevaClave)

        return repoUsuario.cambiarClave(usuario,nuevaClaveEncriptada)

    }

    override fun buscarUsuario(nombre: String): Usuario? {
        val nombreBuscado = repoUsuario.buscar(nombre)

        if (nombreBuscado != null){
            return nombreBuscado
        }else{
            return null
        }
    }

    override fun consultarTodos(): List<Usuario> {
        return repoUsuario.obtenerTodos()
    }

    override fun consultarPorPerfil(perfil: Perfil): List<Usuario> {

        return repoUsuario.obtener(perfil)
    }
}