module.exports = app => {
    const insert = (req, res) => {
        const company = { ...req.body }
        
        app.db('company')
            .insert(company)
            .then(_ => res.status(204).send())
            .catch(err => res.status(500).send(err))
    }

    const update = (req, res) => {
        const company = { ...req.body }

        app.db('company')
            .update(company)
            .where({ id: company.id })
            .then(_ => res.status(204).send())
            .catch(err => res.status(500).send(err))
    }

    const signin = (req, res) => {
        app.db('company')
            .select()
            .where({
                email: req.header.email,
                password: req.header.password })
            .first()
            .then(student => res.json(student))
            .catch(err => res.status(500).send(err))
        }

    const get = (req, res) => {
        app.db('student')
            .select()
            .then(students => res.json(students))
            .catch(err => res.status(500).send(err))
    }
    
    return { insert, update, signin, get }
}