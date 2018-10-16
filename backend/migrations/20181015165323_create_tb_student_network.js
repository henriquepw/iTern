
exports.up = function(knex, Promise) {
    return knex.schema.createTable('network', (table) => {
        table.increments('id').primary()
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('student_network')
}
