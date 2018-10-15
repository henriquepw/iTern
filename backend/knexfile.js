const { db } = require('./.env')

module.exports = {
  development: {
    client: 'postgresql',
    connection: db
  }
}