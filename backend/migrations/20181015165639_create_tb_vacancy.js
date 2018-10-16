
exports.up = function(knex, Promise) {
    return knex.schema.createTable('vacancy', (table) => {
        table.primary()
        table.string()
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('vacancy')
}
