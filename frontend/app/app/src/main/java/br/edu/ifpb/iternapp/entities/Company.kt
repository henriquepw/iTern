data class Company (
    val id: Int,
    var email: String? = null,
    var password: String? = null,
    var fantasy_name: String? = null,
    val cnpj: Int? = null,
    val razao_social: String? = null,
    var address_street: String? = null,
    var address_number: String? = null,
    var address_neighborhood: String? = null,
    var address_city: String? = null,
    var address_postal_code: String? = null,
    var address_state: String? = null,
    var address_country: String? = null
    )