
exports.up = function(knex, Promise) {
    return knex.schema.createTable('student_vacancy', (table) => {
        table.increments('student_id')
        table.string('vacancy_id')
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('student_vacancy')
}
