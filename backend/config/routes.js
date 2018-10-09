module.exports = app => {
    app.route('/users')
        .post()
        .get()
    
    app.route('/user')
        .delete()
        .update()

}