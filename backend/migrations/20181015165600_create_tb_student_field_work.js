
exports.up = function(knex, Promise) {
    return knex.schema.createTable('student_field_work', (table) => {
        table.increments('student_id')
        table.string('field_work_id')
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('student_field_work')
}
