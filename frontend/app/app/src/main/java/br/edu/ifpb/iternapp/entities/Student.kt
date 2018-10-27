package br.edu.ifpb.iternapp.entities

data class Student(
        val id: Int,
        var email: String,
        var password: String,
        var name: String,
        val birthday: java.util.Date,
        var street: String,
        var number: String,
        var neighborhood: String,
        var city: String,
        var postal_code: String,
        var state: String,
        var lattes: String?,
        val rg: Int?,
        val cpf: Int?,
        val birthplace: String?,
        var citizenship: String?
)