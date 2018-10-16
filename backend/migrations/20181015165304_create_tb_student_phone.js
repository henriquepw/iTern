
exports.up = function(knex, Promise) {
    return knex.schema.createTable('student_phone', (table) => {
        table.increments('id').primary()
        table.increments('student_id')
        table.string('number')
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('student_phone')
}
