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

    app.route('/student/vacancy/:student_id')
        .get(app.api.vacancy.getByStudentId)

    app.route('/student/company/:id')
        .get(app.api.student.getByCompany)

    app.route('/vacancy/student/:id')
        .get(app.api.student.getByVacancy)

    app.route('/student/:id')
        .delete(app.api.student.remove)
        .put(app.api.student.update)
        .get(app.api.student.getById)

    app.route('/company')
        .post(app.api.company.insert)
        .get(app.api.company.get)

    app.route('/company/vacancy/:id')
        .get(app.api.vacancy.getByCompany)

    app.route('/company/:id')
        .delete(app.api.company.remove)
        .put(app.api.company.update)
        .get(app.api.company.getById)

    app.route('/vacancy')
        .post(app.api.vacancy.insert)
        .get(app.api.vacancy.get)

    app.route('/vacancy/register')
        .post(app.api.vacancy.register)
        .get(app.api.vacancy.getRegisters)

    app.route('/vacancy/:student_id')
        .get(app.api.vacancy.getByNotRegisted)

    app.route('/network')
        .post(app.api.network.insert)
        .get(app.api.network.get)

    app.route('/occupation')
        .post(app.api.network.insert)
        .get(app.api.network.get)

    app.route('/requirement')
        .post(app.api.network.insert)
        .get(app.api.network.get)
}