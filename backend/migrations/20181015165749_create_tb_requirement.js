
exports.up = function(knex, Promise) {
    return knex.schema.createTable('requirement', (table) => {
        table.increments('id').primary()
        table.string('request').notNull()
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('requirement')
}
