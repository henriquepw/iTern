package br.edu.ifpb.iternapp.entities

data class Student(
        var email: String,
        var password: String,
        var name: String,
        var birthday: String,
        var street: String,
        var number: Int,
        var neighborhood: String,
        var city: String,
        var postal_code: String,
        var state: String,
        var url_lattes: String?,
        var rg: String,
        var cpf: String,
        var birth_place: String,
        var citizenship: String
)