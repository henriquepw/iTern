
exports.up = function(knex, Promise) {
    return knex.schema.createTable('student', (table) => {
        table.increments('id').primary()
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('student')
}
