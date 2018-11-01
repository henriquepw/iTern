module.exports = app => {
    app.get('/student/signin', app.api.student.signin)
    app.get('/company/signin', app.api.company.signin)

    app.route('/student')
        .post(app.api.student.insert)
        .get(app.api.student.get)

    app.route('/student/phone')
        .post(app.api.student.insertPhone)
        //.get(app.api.student.getAllPhone)

    app.route('/student/course')
        .post(app.api.student.insertCourse)
        //.get(app.api.student.getAllCourse)

    app.route('/student/:id')
        .delete(app.api.student.remove)
        .put(app.api.student.update)
        .get(app.api.student.getById)

    app.route('/company')
        .post(app.api.company.insert)
        .get(app.api.company.get)

    app.route('/company/:id')
        .delete(app.api.company.remove)
        .put(app.api.company.update)
}