const { db } = require('./.env')

module.exports = {
  development: {
    client: 'pg',
    connection: 'postgres://localhost/iTern'
  }
}