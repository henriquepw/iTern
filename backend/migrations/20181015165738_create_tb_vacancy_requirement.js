
exports.up = function(knex, Promise) {
    return knex.schema.createTable('vacancy_requirement', (table) => {
        table.increments('vacancy_id')
        table.string('requirement_id')
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('vacancy_requirement')
}
