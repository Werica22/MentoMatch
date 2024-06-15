package br.com.fiap.mentomatch.repository



import br.com.fiap.mentomatch.R
import br.com.fiap.mentomatch.model.Mentorado

fun getAllMentorado(): List<Mentorado> {
    return listOf(
        Mentorado(
            1,
            "Priscilla Carvalho",
            "Programação",
            "",
            R.drawable.img_estudante
        ),
        Mentorado(
            2,
            "Luana Andrade",
            "React, Vue",
            "",
            R.drawable.img_estudante1
        ),
        Mentorado(
            3,
            "Juliana Ferreira",
            "Desenvolvimento Web, Java",
            "",
            R.drawable.img_estudante3
        ),
        Mentorado(
            4,
            "Edmilson Rodrigues",
            "UX Design, Pesquisa do Usuário",
            "",
            R.drawable.img_estudante2
        ),
        Mentorado(
            5,
            "Gabriel Fonseca",
            "UI Design, Testes de Usabilidade",
            "",
            R.drawable.img_estudante4
        ),
        Mentorado(
            6,
            "Vinicius Morais",
            "Front-end Development, CSS",
            "",
            R.drawable.img_estudante5
        ),
        Mentorado(
            7,
            "Gabrielle Bustamante",
            "Scrum, Kanban",
            "",
            R.drawable.img_estudante6
        ),
        Mentorado(
            8,
            "Wérica Barbosa",
            "Empreendedorismo, Inovação",
            "",
            R.drawable.img_estudante7
        )
    )
}

fun getAllMentoradoBuscar(interesses: String): List<Mentorado> {
    return getAllMentorado().filter {
        it.interesses.startsWith(prefix = interesses, ignoreCase = true)
    }
}




