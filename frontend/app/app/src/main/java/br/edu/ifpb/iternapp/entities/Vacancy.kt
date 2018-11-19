package br.edu.ifpb.iternapp.entities

class VacancyInsert(
        val company_id: Int,
        var name: String,
        var workload: Int,
        var scholarship: Double,
        var description: String,
        var street: String,
        var number: Int,
        var neighborhood: String,
        var city: String,
        var postal_code: String,
        var state: String
)

class Vacancy(
        val id: Int,
        val company_id: Int,
        var name: String,
        var workload: Int,
        var scholarship: Double,
        var description: String,
        var street: String,
        var number: Int,
        var neighborhood: String,
        var city: String,
        var postal_code: String,
        var state: String
)