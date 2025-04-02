package service

import data.IRepoSeguros
import model.*
import java.time.LocalDate

class GestorSeguros(val repoSeguros: IRepoSeguros) :IServSeguros{

    override fun contratarSeguroHogar(
        dniTitular: String,
        importe: Double,
        metrosCuadrados: Int,
        valorContenido: Double,
        direccion: String,
        anioConstruccion: Int
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun contratarSeguroAuto(
        dniTitular: String,
        importe: Double,
        descripcion: String,
        combustible: String,
        tipoAuto: Auto,
        cobertura: Cobertura,
        asistenciaCarretera: Boolean,
        numPartes: Int
    ): Boolean {
       val seguro = SeguroAuto(dniTitular,importe,descripcion,combustible,tipoAuto,cobertura,asistenciaCarretera,numPartes)
      return repoSeguros.agregar(seguro)

    }

    override fun contratarSeguroVida(
        dniTitular: String,
        importe: Double,
        fechaNacimiento: LocalDate,
        nivelRiesgo: Riesgo,
        indemnizacion: Double
    ): Boolean {

    }

    override fun eliminarSeguro(numPoliza: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun consultarTodos(): List<Seguro> {
        TODO("Not yet implemented")
    }

    override fun consultarPorTipo(tipoSeguro: String): List<Seguro> {
        TODO("Not yet implemented")
    }
}