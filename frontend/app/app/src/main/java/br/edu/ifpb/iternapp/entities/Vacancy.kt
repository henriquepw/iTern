package br.edu.ifpb.iternapp.entities

class Vacancy(
        val id: Int,
        val company_id: Int?,
        val name: String?,
        val occupation_area: String?,
        val workload: Int?,
        val grant: Double?,
        val description: String?,
        var address_street: String?,
        var address_number: String?,
        var address_neighborhood: String?,
        var address_city: String?,
        var address_postal_code: String?,
        var address_state: String?
)