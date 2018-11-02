package br.edu.ifpb.iternapp.entities

data class Company(
        var email: String,
        var password: String,
        var name: String,
        var cnpj: String,
        var razao_social: String,
        var street: String,
        var number: Int,
        var neighborhood: String,
        var city: String,
        var postal_code: String,
        var state: String
)