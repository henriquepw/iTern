package br.edu.ifpb.iternapp.entities

data class Course(
        val id: Int,
        val student_id: Int,
        val institution: String,
        val name: String,
        val reference_period: String,
        val ingress_period: String,
        val ingress_way: String,
        var conclusion_year: String,
        var ira: Double,
        val shift: String
) 