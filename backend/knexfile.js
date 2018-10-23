const { db } = require('./.env')

module.exports = {
  client: 'pg',
  connection: {
    host : '127.0.0.1',
    user : 'postgres',
    password : '1111',
    database : 'iTern'
  }
}
