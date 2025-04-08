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
        require(numDecimal != null) { errorConv }
        if (numDecimal == null) {
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
        println("Introduce un número decimal: ")

        val numEntero = readln().replace(".", ",").toIntOrNull()
        require(numEntero != null) { errorConv }
        if (numEntero == null) {
            require(debeCumplir(numEntero))
        }
        return numEntero    }

    override fun pedirInfoOculta(prompt: String): String {
        return try {
            val terminal = TerminalBuilder.builder()
                .dumb(true) // Para entornos no interactivos como IDEs
                .build()

            val reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build()

            reader.readLine(prompt, '*') // Oculta la contraseña con '*'
        } catch (e: UserInterruptException) {
            mostrarError("Entrada cancelada por el usuario (Ctrl + C).", pausa = false)
            ""
        } catch (e: EndOfFileException) {
            mostrarError("Se alcanzó el final del archivo (EOF ó Ctrl+D).", pausa = false)
            ""
        } catch (e: Exception) {
            mostrarError("Problema al leer la contraseña: ${e.message}", pausa = false)
            ""
        }    }

    override fun pausar(msj: String) {

        println("Pulsa enter para continuar: ")
        pedirInfo()

    }

    override fun limpiarPantalla(numSaltos: Int) {

            if (System.console() != null) {
                mostrar("\u001b[H\u001b[2J", false)
                System.out.flush()
            } else {
                repeat(numSaltos) {
                    mostrar("")
                }
            }
        }


    override fun preguntar(mensaje: String): Boolean {

        do {
            println(mensaje)
            val respuesta = readln().lowercase()
            if (respuesta == "s"){
                return true
            }else if (respuesta == "n"){
                return false
            }
        }while (respuesta != "s" && respuesta != "n")
        return false
    }
}