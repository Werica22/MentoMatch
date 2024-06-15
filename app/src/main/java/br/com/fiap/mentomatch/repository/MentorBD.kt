package br.com.fiap.mentomatch.repository

import br.com.fiap.mentomatch.R
import br.com.fiap.mentomatch.model.Mentor

fun getAllMentor(): List<Mentor> {
    return listOf(
        Mentor(
            1,
            "André Calvalcanti",
            "Backend Software Engineer",
            interesses = "Realizar mentorias sobre Java",
            disponibilidade = "",
            R.drawable.mentor_1
        ),
        Mentor(
            2,
            "Rafael Santos",
            "Front-end Developer - React, Vue",
            interesses = "Realizar mentorias em front-end, carreiras e curriculos",
            disponibilidade = "",
            R.drawable.mentor_2
        ),
        Mentor(
            3,
            "Leonardo Ribeiro",
            "Engenheiro de Software",
            interesses = "Realizar mentorias startups, back-end, Scrum Master e carreira",
            disponibilidade = "",
            R.drawable.mentor_3
        ),
        Mentor(
            4,
            "Natalia Regina Lima",
            "Engenheira de Software no Ítau",
            interesses = "Realizar mentorias em back-end, técnica e carreira",
            disponibilidade = "",
            R.drawable.mentor_4
        ),
        Mentor(
            5,
            "Gabriela Ribeirto",
            "UX Strategist  e Product Designer ",
            interesses = "Realizar mentorias sobre Product Design, UX Research, UX Design e carreira",
            disponibilidade = "segundas e sextas",
            R.drawable.mentor_5
        ),
        Mentor(
            6,
            "Angela Fonseca",
            "Front- End Engineer",
            interesses = "Realizar mentorias sobre Front-End, carreira e curriculo",
            disponibilidade = "",
            R.drawable.mentor_6
        ),
        Mentor(
            7,
            "Alan Kuhn",
            "Agile coach",
            interesses = "Realizar mentorias sobre Agile, product Management, Scrum Mastes e carreira",
            disponibilidade = "",
            R.drawable.mentor_7
        ),
        Mentor(
            8,
            "Aline Guerreiro",
            "Mentora de Startups e Design Sprint",
            interesses = "Realizar mentoria sobre Startups, carreira e curriculo",
            disponibilidade = "",
            R.drawable.mentor_8
        ),
    )
}
fun getAllMentorBuscas(experiencia: String): List<Mentor> {
    return getAllMentor().filter {
        it.experiencia.startsWith(prefix = experiencia, ignoreCase = true)
    }
}