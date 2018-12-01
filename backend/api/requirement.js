module.exports = app => {
    const insert = (req, res) => {
        const network = { ...req.body }
        console.log({ ...network })

        app.db('student_requirement')
            .insert(network)
            .returning('id')
            .then(id => {
                res.json({ id: id[0] })
                console.log(id[0])
            })
            .catch(err => res.status(500).send(err))
    }

    const get = (_, res) => {
        app.db('student_requirement')
            .select()
            .then(networks => res.json(networks))
            .catch(err => res.status(500).send(err))  
    }

    return {
        insert,
        get
    }  
}