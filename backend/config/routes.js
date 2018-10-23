module.exports = app => {
    app.post('/student/singup', app.api.student.insert)
    app.post('/company/singup', app.api.company.insert)

    /*
    app.route('/empresas')
        .get(app.api.empresa.get)
        .post(app.api.empresa.insert)
    */
}