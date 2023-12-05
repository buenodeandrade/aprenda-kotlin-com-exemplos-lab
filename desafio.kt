enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, var email: String, var nivel: Nivel, val id: Long)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario, formacao: Formacao) {
        if (usuario.nivel != formacao.nivel) {
            println("${usuario.nome} fora do nível do curso de ${formacao.nome}. \n")
        } else {
            inscritos.add(usuario)
            println("${usuario.nome} matriculado com sucesso em ${formacao.nome}! \n")
        }
    }
}

fun main() {
    //Lista de Conteúdos
    val conteudo1 = ConteudoEducacional("Lógica de Programação", 60)
    val conteudo2 = ConteudoEducacional("Criando Seu Currículo Online Com HTML e GitHub Pages", 60)
    val conteudo3 = ConteudoEducacional("Algoritmos", 60)
    val conteudo4 = ConteudoEducacional("HTML, CSS e Javascript", 120)
    val conteudo5 = ConteudoEducacional("UI/UX: Criando a Interface do Instagram com Figma", 120)
    val conteudo6 = ConteudoEducacional("Typescript e construção de API", 120)    
    val conteudo7 = ConteudoEducacional("Node.js e Serverless", 180)
    val conteudo8 = ConteudoEducacional("PHP para aplicações Web", 180)
    val conteudo9 = ConteudoEducacional("ReactJS, Bootstrap, Redux e SASS", 180)    
    
    //Lista de Cursos de Formação
    val formacao1 = Formacao("Desenvolvimento Web", Nivel.BASICO, listOf(conteudo1, conteudo2, conteudo3))
    val formacao2 = Formacao("Web Design e Experiência do Usuário", Nivel.INTERMEDIARIO, listOf(conteudo4, conteudo5, conteudo6))
    val formacao3 = Formacao("Desenvolvimento Front End", Nivel.AVANCADO, listOf(conteudo7, conteudo8, conteudo9))
    
    
    //Criando os usuários
    val aluno1 = Usuario("João", "joao@mail.com", Nivel.BASICO, 1)
    val aluno2 = Usuario("Maria", "maria@mail.com", Nivel.INTERMEDIARIO, 2)
    val aluno3 = Usuario("José", "jose@mail.com", Nivel.AVANCADO, 3)
    val aluno4 = Usuario("Marcos", "marcos@mail.com", Nivel.BASICO, 4)
    val aluno5 = Usuario("Gabriel", "gabriel@mail.com", Nivel.INTERMEDIARIO, 5)
    val aluno6 = Usuario("Patrícia", "patricia@mail.com", Nivel.AVANCADO, 6)
    val aluno7 = Usuario("Mariana", "mariana@mail.com", Nivel.BASICO, 7)
    val aluno8 = Usuario("Breno", "breno@mail.com", Nivel.INTERMEDIARIO, 8)
    val aluno9 = Usuario("Luiza", "luiza@mail.com", Nivel.AVANCADO, 9)

    //Matriculando
    formacao1.matricular(aluno1, formacao1)
    formacao1.matricular(aluno4, formacao2)
    formacao1.matricular(aluno7, formacao1)
    formacao2.matricular(aluno2, formacao2)
    formacao2.matricular(aluno5, formacao3)
    formacao2.matricular(aluno8, formacao2)
    formacao3.matricular(aluno3, formacao3)
    formacao3.matricular(aluno6, formacao3)
    formacao3.matricular(aluno9, formacao1)
	
    println("Dados do curso de ${formacao1.nome}: \n Nível: ${formacao1.nivel}. \n Conteúdos abordados: ${formacao1.conteudos.map { it.nome}}. \n Inscritos: ${formacao1.inscritos.map { it.nome }}.\n")
    println("Dados do curso de ${formacao2.nome}: \n Nível: ${formacao2.nivel}. \n Conteúdos abordados: ${formacao2.conteudos.map { it.nome}}. \n Inscritos: ${formacao2.inscritos.map { it.nome }}.\n")
    println("Dados do curso de ${formacao3.nome}: \n Nível: ${formacao3.nivel}. \n Conteúdos abordados: ${formacao3.conteudos.map { it.nome}}. \n Inscritos: ${formacao3.inscritos.map { it.nome }}.\n")
}
