package data

import model.Perfil
import model.Usuario

open class RepoUsuariosMem:IRepoUsuarios {

    val listUsuarios = mutableListOf<Usuario>()


    override fun agregar(usuario: Usuario): Boolean {

        val AUsuario = buscar(usuario.nombre)

        return if (AUsuario != null) {
            listUsuarios.add(usuario)
        }else{
            return false
        }

    }

    override fun buscar(nombreUsuario: String): Usuario? {

        return listUsuarios.find { it.nombre == nombreUsuario }

        return null

    }

    override fun eliminar(usuario: Usuario): Boolean {

        return listUsuarios.remove(usuario)
    }

    override fun eliminar(nombreUsuario: String): Boolean{

        val usuario= (buscar(nombreUsuario))

        return if (usuario != null){
            eliminar(nombreUsuario)
        } else {
            return false
        }

    }
    override fun obtenerTodos(): List<Usuario> {

        return listUsuarios
    }

    override fun obtener(perfil: Perfil): List<Usuario> {

        val usuariosConsulta = when(perfil){
            Perfil.ADMIN -> listUsuarios.filter { it.perfil == Perfil.ADMIN }
            Perfil.GESTION -> listUsuarios.filter { it.perfil == Perfil.GESTION }
            Perfil.CONSULTA -> listUsuarios.filter { it.perfil == Perfil.CONSULTA }
        }

        return  usuariosConsulta
    }

    override fun cambiarClave(usuario: Usuario, nuevaClave: String): Boolean {

        usuario.cambiarClave(nuevaClave)
        return true

    }
}