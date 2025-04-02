package model

class SeguroHogar : Seguro {
    private var metrosCuadrados: Double
    private var valorContenido: Double
    private var direccion: String
    private var anioConstruccion: Int

    companion object {
        internal var numPolizasHogar = 100000
        private const val PORCENTAJE_INCREMENTO_ANIOS = 0.02
        private const val CICLO_ANIOS_INCREMENTO = 5

        fun crearSeguro(datos: List<String>): SeguroHogar {
            return try {
                if (datos.size != 6) throw IllegalArgumentException("Debe proporcionar 6 valores: dniTitular, importe, metrosCuadrados, valorContenido, direccion y anioConstruccion")

                val dniTitular = datos[0]
                val importe = datos[1].toDouble()
                val metrosCuadrados = datos[2].toDouble()
                val valorContenido = datos[3].toDouble()
                val direccion = datos[4]
                val anioConstruccion = datos[5].toInt()

                SeguroHogar(dniTitular, importe, metrosCuadrados, valorContenido, direccion, anioConstruccion)
            } catch (e: Exception) {
                throw IllegalArgumentException("Error al crear el seguro: ${'$'}${e.message}")
            }
        }


    }

    constructor(dniTitular: String, importe: Double, metrosCuadrados: Double, valorContenido: Double, direccion: String, anioConstruccion: Int)
            : super(numPolizasHogar++, dniTitular, importe) {
        this.metrosCuadrados = metrosCuadrados
        this.valorContenido = valorContenido
        this.direccion = direccion
        this.anioConstruccion = anioConstruccion
    }

    private constructor(numPoliza: Int, metrosCuadrados: Double, valorContenido: Double, direccion: String, anioConstruccion: Int,dniTitular: String,importe:Double)
            : super(numPoliza, dniTitular, importe) {
        this.metrosCuadrados = metrosCuadrados
        this.valorContenido = valorContenido
        this.direccion = direccion
        this.anioConstruccion = anioConstruccion
    }

    override fun calcularImporteAnioSiguiente(interes: Double): Double {

        val valor_5_anios = antiguedad / 5

    }

    override fun toString(): String {
        return "Seguro(numPoliza=$numPoliza, dniTitular=$dniTitular, importe=$importe)"

    }

    override fun serializar(separador: String): String {
        return "$numPoliza$separador$dniTitular$separador$importe"
    }
}