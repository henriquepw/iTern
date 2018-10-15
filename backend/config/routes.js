module.exports = app => {
    app.post('/singup', app.api)
    app.post('/singin', app.api.auth.singin)
    app.post('/validateToken', app.api.auth.validateToken)

    app.route('/empresas')
        .get(app.api.empresa.get)
        .post(app.api.empresa.insert)

    app.route('/vagas')
        .get(app.api.empresa.getVagas)

    app.route('/vagas/:empresa_id')
        .post(app.api.empresa)
        .get(app.api.empresa.getVagasByEmpresaId)
}