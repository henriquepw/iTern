data class Course(
        val id: Int,
        val student_id: Int,
        val institution_id: Int,
        val name: String,
        val reference_period: String,
        val ingress_period: String,
        val ingress_year: String,
        val ingress_way: String,
        var conclusion_year: String,
        var ira: Double,
        val shift: String
) 