
exports.up = function(knex, Promise) {
  
}

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('student_field_work')
}
