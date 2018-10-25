package br.edu.ifpb.iternapp.entities

import java.util.Date

data class Student (
        var id: Int?,
        var name: String,
        var birthday: Date,
        var address_street: String,
        var address_number: String,
        var address_city: String,
        var address_state: String,
        var lattes: String,
        var cpf: String,
        var rg: String,
        var birthplace: String,
        var citizenship: String,
        var email: String,
        var password: String )


