
exports.up = function(knex, Promise) {
    return knex.schema.createTable('vacancy_field_work', (table) => {
        table.increments('vacancy_id')
        table.string('field_work_id')
    })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('vacancy_field_work')
}
