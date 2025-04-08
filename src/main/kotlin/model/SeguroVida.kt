package model

import java.time.LocalDate
import java.time.LocalDateTime

class SeguroVida : Seguro {
    private var fechaNac: LocalDate
    private var nivelRiesgo: Riesgo
    private var indemnizacion: Double

    companion object {
        internal var numPolizasVida = 800000

        fun crearSeguro(datos: List<String>): SeguroVida {

            val dniTitular = datos[0]
            val numPoliza = datos[1].toInt()
            val importe = datos[2].toDouble()
            val fechaNac = LocalDate.parse(datos[3])
            val nivelRiesgo = Riesgo.getRiesgo(datos[4])
            val indemnizacion = datos[5].toDouble()

            return SeguroVida(dniTitular,numPoliza, importe, fechaNac, nivelRiesgo, indemnizacion)
        }
    }

    constructor(dniTitular: String, importe: Double, fechaNac: LocalDate, nivelRiesgo: Riesgo, indemnizacion: Double)
            : super(++numPolizasVida, dniTitular, importe) {
        this.fechaNac = fechaNac
        this.nivelRiesgo = nivelRiesgo
        this.indemnizacion = indemnizacion
    }

    private constructor(dniTitular: String,numPoliza: Int, importe: Double, fechaNac: LocalDate, nivelRiesgo: Riesgo, indemnizacion: Double)
            : super(numPoliza, dniTitular, importe) {
        this.fechaNac = fechaNac
        this.nivelRiesgo = nivelRiesgo
        this.indemnizacion = indemnizacion
    }

    override fun calcularImporteAnioSiguiente(interes: Double): Double {
        val edad = LocalDate.now().year - fechaNac.year
        val interesResidual = 0.0005 * edad
        return importe * (1 + interes + interesResidual)
    }

    override fun toString(): String {
        return "SeguroVida(numPoliza=$numPoliza, dniTitular='$dniTitular', importe=$importe, fechaNac=$fechaNac, nivelRiesgo='$nivelRiesgo', indemnizacion=$indemnizacion)"
    }

    fun serializar(): String {
        return "$numPoliza;$dniTitular;$importe;$fechaNac;$nivelRiesgo;$indemnizacion"
    }
}