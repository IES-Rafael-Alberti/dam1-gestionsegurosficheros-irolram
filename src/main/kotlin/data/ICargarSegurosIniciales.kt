package data

interface ICargarSegurosIniciales {
    fun cargarSeguros(mapa: Map<String, (List<String>) -> Seguro>): Boolean
}

