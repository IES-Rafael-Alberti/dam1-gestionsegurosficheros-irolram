package model

import java.time.LocalDate

class SeguroVida : Seguro {
    private var fechaNac: LocalDate
    private var nivelRiesgo: String
    private var indemnizacion: Double

    companion object {
        internal var numPolizasVida = 800000
    }

    constructor(dniTitular: String, importe: Double, fechaNac: LocalDate, nivelRiesgo: String, indemnizacion: Double)
            : super(numPolizasVida++, dniTitular, importe) {
        this.fechaNac = fechaNac
        this.nivelRiesgo = nivelRiesgo
        this.indemnizacion = indemnizacion
    }

    private constructor(numPoliza: Int, dniTitular: String, importe: Double, fechaNac: LocalDate, nivelRiesgo: String, indemnizacion: Double)
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