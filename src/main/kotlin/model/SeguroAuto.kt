package model
class SeguroAuto : Seguro {

    private var descripcion: String
    private var combustible: String
    private var tipoAuto: String
    private var cobertura: String
    private var asistenciaCarretera: Boolean
    private var numPartes: Int

    companion object {
        private var numPolizasAuto = 400000
    }

    private constructor(dniTitular:String,importe:Double,  descripcion:String, combustible: String, tipoAuto:String, cobertura:String, asistenciaCarretera: Boolean, numPartes:Int)
            : super(numPolizasAuto++, dniTitular, importe) {
        this.descripcion = descripcion
        this.combustible = combustible
        this.tipoAuto = tipoAuto
        this.cobertura = cobertura
        this.asistenciaCarretera = asistenciaCarretera
        this.numPartes = numPartes
    }

    private constructor(numPoliza:Int,dniTitular:String,importe:Double,  descripcion:String, combustible: String, tipoAuto:String, cobertura:String, asistenciaCarretera: Boolean, numPartes:Int)
            : super(numPoliza, dniTitular, importe) {
        this.descripcion = descripcion
        this.combustible = combustible
        this.tipoAuto = tipoAuto
        this.cobertura = cobertura
        this.asistenciaCarretera = asistenciaCarretera
        this.numPartes = numPartes
    }

    override fun calcularImporteAnioSiguiente(interes: Double): Double {
        TODO("Not yet implemented")
    }

    override fun serializar(separador: String): String {
        return "$numPoliza$separador$dniTitular$separador$importe"
    }

    override fun toString(): String {
        return "Seguro(numPoliza=$numPoliza, dniTitular=$dniTitular, importe=$importe)"
    }


}