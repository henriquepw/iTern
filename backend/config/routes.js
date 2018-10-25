module.exports = app => {
    app.get('/student/signin', app.api.student.signin)
    app.get('/company/signin', app.api.company.signin)

    app.route('/student')
        .post(app.api.student.insert)
        .get(app.api.student.get)

    app.route('/student/:id')
        .put(app.api.student.update)
        .get(app.api.student.getById)
        .delete(app.api.student.remove)

    app.route('/company')
        .post(app.api.company.insert)
        .get(app.api.company.get)
}