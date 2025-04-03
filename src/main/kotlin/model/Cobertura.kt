package model

enum class Cobertura() {

    TERCEROS, TERCEROS_AMPLIADO, FRANQUICIA_200, FRANQUICIA_300, FRANQUICIA_400, FRANQUICIA_500, TODO_RIESGO;

    companion object {
        fun getCobertura(valor: String): Cobertura{
            return when (valor.uppercase()) {
                "TERCEROS" -> TERCEROS
                "TERCEROS_AMPLIADO" -> TERCEROS_AMPLIADO
                "FRANQUICIA_200" -> FRANQUICIA_200
                "FRANQUICIA_300" -> FRANQUICIA_300
                "FRANQUICIA_400" -> FRANQUICIA_400
                "FRANQUICIA_500" -> FRANQUICIA_500
                "TODO_RIESGO" -> TODO_RIESGO
                else -> TERCEROS
            }
        }
    }
}