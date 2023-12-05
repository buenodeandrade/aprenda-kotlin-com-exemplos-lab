enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, var email: String, val nivel: Nivel, val id: Long)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} matriculado com sucesso!")
    }
}

fun main() {
    //Lista de Conteúdos
    val conteudo1 = ConteudoEducacional("Lógica de Programação", 60)
    val conteudo2 = ConteudoEducacional("Criando Seu Currículo Online Com HTML e GitHub Pages", 60)
    val conteudo3 = ConteudoEducacional("Algoritmos", 120)
    val conteudo4 = ConteudoEducacional("UI/UX: Criando a Interface do Instagram com Figma", 120)
    val conteudo5 = ConteudoEducacional("Programação Orientada a Objetos", 180)
    val conteudo6 = ConteudoEducacional("App Android de Extrato Bancário em Kotlin com Coroutines e LiveData", 180)    
    

    //Lista de Cursos de Formação
    val formacao1 = Formacao("Desenvolvimento Web", Nivel.BASICO, listOf(conteudo1))
    val formacao2 = Formacao("Ciência de Dados", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))
    val formacao3 = Formacao("Machine Learning", Nivel.AVANCADO, listOf(conteudo1, conteudo2, conteudo3))
    
    
    //Criando os usuários
    val aluno1 = Usuario("João", "joao@mail.com", Nivel.BASICO, 10)
    val aluno2 = Usuario("Maria", "maria@mail.com", Nivel.INTERMEDIARIO, 20)
    val aluno3 = Usuario("José", "jose@mail.com", Nivel.AVANCADO, 30)

    //Matriculando
    formacao1.matricular(aluno1)
    formacao2.matricular(aluno2)
    formacao3.matricular(aluno3)

    println("Inscritos em Desenvolvimento Web ${formacao1.nome}: ${formacao1.inscritos.map { it.nome }}. Nível: ${Nivel.INTERMEDIARIO}. Conteúdos abordados: ${formacao1.conteudos.map { it.nome}}.")


}
