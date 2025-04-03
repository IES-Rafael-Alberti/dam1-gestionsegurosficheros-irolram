package model

class SeguroHogar : Seguro {
    private var metrosCuadrados: Int
    private var valorContenido: Double
    private var direccion: String
    private var anioConstruccion: Int

    companion object {
        internal var numPolizasHogar = 100000
        private const val PORCENTAJE_INCREMENTO_ANIOS = 0.02
        private const val CICLO_ANIOS_INCREMENTO = 5

        fun crearSeguro(datos: List<String>): SeguroHogar {
            val numPoliza = datos[0].toInt()
            val dniTitular = datos[1]
            val importe = datos[2].toDouble()
            val metrosCuadrados = datos[3].toInt()
            val valorContenido = datos[4].toDouble()
            val direccion = datos[5]
            val anioConstruccion = datos[6].toInt()
            return SeguroHogar(dniTitular, importe,metrosCuadrados,valorContenido,direccion,anioConstruccion)
        }


    }

    constructor(dniTitular: String, importe: Double, metrosCuadrados: Int, valorContenido: Double, direccion: String, anioConstruccion: Int)
            : super(++numPolizasHogar, dniTitular, importe) {
        this.metrosCuadrados = metrosCuadrados
        this.valorContenido = valorContenido
        this.direccion = direccion
        this.anioConstruccion = anioConstruccion
    }

    private constructor(numPoliza: Int,dniTitular: String,importe:Double, metrosCuadrados: Int, valorContenido: Double, direccion: String, anioConstruccion: Int)
            : super(numPoliza, dniTitular, importe) {
        this.metrosCuadrados = metrosCuadrados
        this.valorContenido = valorContenido
        this.direccion = direccion
        this.anioConstruccion = anioConstruccion
    }

    override fun calcularImporteAnioSiguiente(interes: Double): Double {

        TODO()

    }

    override fun toString(): String {
        return "Seguro(numPoliza=$numPoliza, dniTitular=$dniTitular, importe=$importe)"

    }

    override fun serializar(separador: String): String {
        return "$numPoliza$separador$dniTitular$separador$importe"
    }
}