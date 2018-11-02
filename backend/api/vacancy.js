module.exports = app => {
    const insert = (req, res) => {
        const vacancy = { ...req.body }
        console.log({ ...vacancy })

        app.db('vacancy')
            .insert(vacancy)
            .returning('id')
            .then(id => {
                res.json({
                    id: id[0]
                })
                console.log(id[0])
            })
            .catch(err => res.status(500).send(err))
    }

    const get = (req, res) => {
        app.db('vacancy')
            .select()
            .then(vacancys => res.json(vacancys))
            .catch(err => res.status(500).send(err))
    }

    return {
        insert,
        get
    }
}