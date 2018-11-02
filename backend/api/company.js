module.exports = app => {
    const insert = (req, res) => {
        const company = { ...req.body }
        console.log({ ...company })

        app.db('company')
            .insert(company)
            .returning('id')
            .then(id => {
                res.json({
                    id: id[0]
                })
                console.log(id[0])
            })
            .catch(err => res.status(500).send(err))
    }

    const update = (req, res) => {
        const company = { ...req.body }

        app.db('company')
            .update(company)
            .where({ 
                id: req.params.id 
            })
            .then(_ => res.status(204).send())
            .catch(err => res.status(500).send(err))
    }

    const remove = (req, res) => {
        console.log(req.params.id)

        app.db('company')
            .delete()
            .where({
                id: req.params.id
            })
            .then(_ => {
                res.json({ id: 0 })
            })
            .catch(err => res.status(500).send(err))
    }

    const signin = (req, res) => {
        app.db('company')
            .select('id')
            .where({
                email: req.header('email'),
                password: req.header('password')
            })
            .first()
            .then(company => res.json(company))
            .catch(err => res.status(500).send(err))
    }

    const get = (req, res) => {
        app.db('company')
            .select()
            .then(students => res.json(students))
            .catch(err => res.status(500).send(err))
    }

    const getById = (req, res) => {
        app.db('company')
            .select()
            .where({
                id: req.params.id
            })
            .first()
            .then(company => res.json(company))
            .catch(err => res.status(500).send(err))
    }

    return {
        insert,
        get, getById,
        update,
        remove,
        signin
    }
}