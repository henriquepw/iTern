
exports.up = function(knex, Promise) {
    return knex.schema.createTable('field_work', (table) => {
        table.increments('id').primary()
        table.string('field').notNull()
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('field_work')
}
