package data


import model.Seguro


open class RepoSegurosMem : IRepoSeguros{

    val listSeguro = mutableListOf<Seguro>()


    override fun agregar(seguro: Seguro): Boolean {
        val ASeguro = buscar(seguro.numPoliza)

        return if (ASeguro != null) {
            listSeguro.add(seguro)
        }else{
            return false
        }
    }

    override fun buscar(numPoliza: Int): Seguro? {
        return listSeguro.find { it.numPoliza == numPoliza }

    }

    override fun eliminar(seguro: Seguro): Boolean {

        return listSeguro.remove(seguro)
    }

    override fun eliminar(numPoliza: Int): Boolean {
        val ESeguro = buscar(numPoliza)
        return if (ESeguro != null) {
            listSeguro.remove(ESeguro)
        }else{
            return false
        }
    }

    override fun obtenerTodos(): List<Seguro> {
        return listSeguro
    }

    override fun obtener(tipoSeguro: String): List<Seguro> {

        return listSeguro.filter { it.tipoSeguro() == tipoSeguro }

    }
}