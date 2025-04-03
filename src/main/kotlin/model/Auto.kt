package model

enum class Auto {

    COCHE, MOTO, CAMION;

    companion object {
        fun getAuto(valor: String): Auto{
            return when (valor) {
                "COCHE" ->  COCHE
                "MOTO" ->  MOTO
                "CAMION" ->  CAMION
                else -> throw IllegalArgumentException("Auto no válido: $valor")
            }
        }
    }
}