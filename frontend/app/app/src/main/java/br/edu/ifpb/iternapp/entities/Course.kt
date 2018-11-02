package br.edu.ifpb.iternapp.entities

data class Course(
        var student_id: Int,
        var institution: String,
        var name: String,
        var reference_period: String,
        var ingress_period: String,
        var ingress_way: String,
        var conclusion_year: String,
        var ira: Double,
        var shift: String
) 