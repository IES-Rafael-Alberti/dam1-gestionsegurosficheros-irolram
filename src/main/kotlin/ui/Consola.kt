package ui

class Consola : IEntradaSalida{

    override fun mostrar(msj: String, salto: Boolean, pausa: Boolean) {
        if (salto){
            println()
        }else if(pausa){
            pausar(msj)
        }
    }

    override fun mostrarError(msj: String, pausa: Boolean) {
        TODO("Not yet implemented")
    }

    override fun pedirInfo(msj: String): String {
         if (msj.isNotEmpty()){
            println(msj.trim())
             }
        return readln()
    }

    override fun pedirInfo(
        msj: String,
        error: String,
        debeCumplir: (String) -> Boolean
    ): String {
        val entradaUsuario = readln()
        require(debeCumplir(entradaUsuario)) { "Error, $error" }

        return entradaUsuario
    }

    override fun pedirDouble(
        prompt: String,
        error: String,
        errorConv: String,
        debeCumplir: (Double) -> Boolean
    ): Double {

        println("Introduce un número decimal: ")

        val numDecimal = readln().replace(".", ",").toDoubleOrNull()
        require(numDecimal == null) { errorConv }
        if (numDecimal != null) {
            require(debeCumplir(numDecimal))
        }
        return numDecimal
    }

    override fun pedirEntero(
        prompt: String,
        error: String,
        errorConv: String,
        debeCumplir: (Int) -> Boolean
    ): Int {
        TODO("Not yet implemented")
    }

    override fun pedirInfoOculta(prompt: String): String {
        TODO("Not yet implemented")
    }

    override fun pausar(msj: String) {
        TODO("Not yet implemented")
    }

    override fun limpiarPantalla(numSaltos: Int) {
        TODO("Not yet implemented")
    }

    override fun preguntar(mensaje: String): Boolean {
        TODO("Not yet implemented")
    }
}