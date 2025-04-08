package model

enum class Perfil {
    ADMIN, GESTION, CONSULTA;

    companion object {
        fun getPerfil(valor:String): Perfil {
            return when (valor) {
                "Admin" ->  ADMIN
                "Gestion" ->  GESTION
                "Consulta" ->  CONSULTA
                else -> throw IllegalArgumentException("Perfil no válido: $valor")
            }
        }
    }
}