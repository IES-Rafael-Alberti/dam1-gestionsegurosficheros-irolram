package model

abstract class Seguro(val numPoliza:Int, private val dniTitular: String, protected val importe: Double): IExportable {

    abstract fun calcularImporteAnioSiguiente(interes: Double): Double


    override fun serializar(separador: String): String {
        return "$numPoliza$separador$dniTitular$separador$importe"
    }

    override fun equals(other: Any?): Boolean {
        return numPoliza.equals(other)
    }

    override fun hashCode(): Int {
        return numPoliza.hashCode()
    }

    override fun toString(): String {
        return "Seguro(numPoliza=$numPoliza, dniTitular=$dniTitular, importe=$importe)"
    }

    fun tipoSeguro():String{
        return this::class.simpleName ?: "Desconocido"
    }
}