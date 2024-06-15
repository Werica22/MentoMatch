package br.com.fiap.mentomatch.model

data class Mentor(
                  val id: Int,
                  val nome: String,
                  val experiencia: String,
                  val interesses: String,
                  val disponibilidade: String,
                  val imagemResId: Int
)
