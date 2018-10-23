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
            .where({ id : student.id })
            .then(_ => res.status(204).send())
            .catch(err => res.status(500).send(err))
    }

    const remove = (req, res) => {

    }

    const signin = (req, res) => {
        const student = { ...req.body }

        app.db('student')
            .select()
            where({ 
                email: req.body.email,
                password: req.body.password
                })
            .first()
            .then(student => res.json(student))
            .catch(err => res.status(500).send(err))    
    }

    return { insert, update, remove }
}