class Vacancy (
    val id: Int,
    val company_id: Int? = null,
    val name: String? = null,
    val occupation_area: String? = null,
    val workload: Int? = null,
    val grant: Double? = null,
    val description: String? = null,
    var address_street: String? = null,
    var address_number: String? = null,
    var address_neighborhood: String? = null,
    var address_city: String? = null,
    var address_postal_code: String? = null,
    var address_state: String? = null
)