package br.com.fiap.mentomatch.model

data class Mentorado(
    val id: Int,
    val nome: String,
    val interesses: String,
    val disponibilidade: String,
    val imagemResId: Int
)
