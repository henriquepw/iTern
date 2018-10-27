package br.edu.ifpb.iternapp.entities

data class Company(
        val id: Int,
        var email: String?,
        var password: String?,
        val cnpj: Int?,
        val razao_social: String?,
        var street: String?,
        var number: String?,
        var neighborhood: String?,
        var city: String?,
        var postal_code: String?,
        var state: String?
)