module.exports = app => {
    const insert = (req, res) => {
        const vacancy = { ...req.body
        }
        console.log({ ...vacancy
        })

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

    const get = (_, res) => {
        app.db('vacancy')
            .select()
            .then(vacancys => res.json(vacancys))
            .catch(err => res.status(500).send(err))
    }

    const getByNotRegisted = (req, res) => {
        studentId = req.params.student_id
        console.log(studentId)
        app.db('vacancy')
            .select()
            .whereRaw(
                 `id not in (
                    select distinct vacancy_id
                    from student_vacancy
                    where student_id = ${studentId})`)
            .orderBy('name')
            .then(vacancys => {
                console.log(vacancys)
                res.json(vacancys)
            })
            .catch(err => res.status(500).send(err))
    }

    const getByStudentId = (req, res) => {
        studentId = req.params.student_id
        console.log(studentId)
        app.db('vacancy')
            .select()
            .whereRaw(
                 `id in (
                    select distinct vacancy_id
                    from student_vacancy
                    where student_id = ${studentId})`)
            .orderBy('name')
            .then(vacancys => {
                console.log(vacancys)
                res.json(vacancys)
            })
            .catch(err => res.status(500).send(err))
    }

    const getByCompany = (req, res) => {
        studentId = req.params.student_id
        console.log(studentId)
        app.db('vacancy')
            .select()
            .whereRaw(
                 `id in (
                    select distinct vacancy_id
                    from student_vacancy
                    where student_id = ${studentId})`)
            .orderBy('name')
            .then(vacancys => {
                console.log(vacancys)
                res.json(vacancys)
            })
            .catch(err => res.status(500).send(err))
    }

    const register = (req, res) => {
        student_vacancy = {
            student_id: parseInt(req.header('student_id')),
            vacancy_id: parseInt(req.header('vacancy_id'))
        }

        console.log(student_vacancy)

        app.db('student_vacancy')
            .insert(student_vacancy)
            .then(_ => {
                res.json({
                    id: 1
                })
            })
            .catch(err => {
                res.status(500).send(err)
            })
    }

    const getRegisters = (_, res) => {
        app.db('student_vacancy')
            .select()
            .then(registers => res.json(registers))
            .catch(err => res.status(500).send(err))
    }

    return {
        insert,
        get, 
        getByNotRegisted, 
        getByStudentId,
        getByCompany,
        getRegisters,
        register
    }
}