
exports.up = function(knex, Promise) {
    return knex.schema.createTable('company', (table) => {
        table.increments('id').primary()
        table.string('email').notNull().unique()
        table.string('password').notNull()
        table.string('name').notNull()
        table.string('social-name').notNull()
        table.string('cnpj').notNull()
        table.string('street').notNull()
        table.string('number').notNull()
        table.string('neighborhood').notNull()
        table.string('city').notNull()
        table.string('state').notNull()
        table.string('country').notNull()
        table.string('zip').notNull()

  })
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('company')
}
