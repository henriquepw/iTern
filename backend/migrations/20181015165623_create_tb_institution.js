
exports.up = function(knex, Promise) {
    return knex.schema.createTable('institution', (table) => {
        table.increments('id').primary()
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('institution')
}
