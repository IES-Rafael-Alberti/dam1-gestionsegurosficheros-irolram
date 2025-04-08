package data

import model.IExportable
import model.Seguro
import model.SeguroAuto
import model.SeguroHogar
import model.SeguroVida
import utils.Ficheros
import utils.IUtilFicheros

class RepoSegurosFich : RepoSegurosMem() {

    object ficheroUsuaria : IUtilFicheros{
        override fun leerArchivo(ruta: String): List<String> {
            TODO("Not yet implemented")
        }

        override fun agregarLinea(ruta: String, linea: String): Boolean {
            TODO("Not yet implemented")
        }

        override fun <T : IExportable> escribirArchivo(
            ruta: String,
            elementos: List<T>
        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun existeFichero(ruta: String): Boolean {
            TODO("Not yet implemented")
        }

        override fun existeDirectorio(ruta: String): Boolean {
            TODO("Not yet implemented")
        }
    }

    val fich = Ficheros()

    override fun agregar(seguro: Seguro): Boolean {

    }

    override fun eliminar(seguro: Seguro): Boolean {
        return super.eliminar(seguro)
    }

    fun cargarUsuarios():Boolean{

    }

    private fun actualizarContadores(seguros: List<Seguro>) {
        // Actualizar los contadores de polizas del companion object según el tipo de seguro
        val maxHogar = seguros.filter { it.tipoSeguro() == "SeguroHogar" }.maxOfOrNull { it.numPoliza }
        val maxAuto = seguros.filter { it.tipoSeguro() == "SeguroAuto" }.maxOfOrNull { it.numPoliza }
        val maxVida = seguros.filter { it.tipoSeguro() == "SeguroVida" }.maxOfOrNull { it.numPoliza }

        if (maxHogar != null) SeguroHogar.numPolizasHogar = maxHogar
        if (maxAuto != null) SeguroAuto.numPolizasAuto = maxAuto
        if (maxVida != null) SeguroVida.numPolizasVida = maxVida
    }
}