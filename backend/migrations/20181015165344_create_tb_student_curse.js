
exports.up = function(knex, Promise) {
    return knex.schema.createTable('curse', (table) => {
        table.increments('id').primary()
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('student_curse')
}
