module.exports = app => {
    const insert = (req, res) => {
        const student = { ...req.body }
        
        app.db('student')
            .insert(student)
            .then(_ => res.status(204).send())
            .catch(err => res.status(500).send(err))
    }

    const update = (req, res) => {
        const student = { ...req.body }

        app.db('student')
            .update(student)
            .where({ id: student.id })
            .then(_ => res.status(204).send())
            .catch(err => res.status(500).send(err))
    }

    const remove = (req, res) => {
        
    }

    const signin = (req, res) => {
        app.db('student')
            .select('id')
            .where({ 
                email: req.header('email'),
                password: req.header('password') })
            .first()
            .then(student => res.json(student))
            .catch(err => res.status(500).send(err))    
    }

    const get = (req, res) => {
        app.db('student')
            .select()
            .then(students => res.json(students))
    }

    const getById = (req, res) => {
        app.db('student')
            .select()
            .where({ id: req.params.id })
            .first()
            .then(student => res.json(student))
            .catch(err => res.status(500).send(err))  
    }

    return { insert, update, remove, signin, get, getById }
}