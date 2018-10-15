const { autoSecret } = require('../.env')
const jwt = require('jwt-simple')
const bcrypt = require('bcrypt-nodejs')

module.exports = app => {
    const signin = async (req, res) => {
        if (!req.body.email || !req.body.password) {
            return res.status(400).send('informe usuário e senha!')
        }

        /*const user = await app.db('users')
            .where(email: req.budy.email)
            .first()*/

        if (!user)
            return res.status(400).send('Usuário não encontrado!')

        const isMatch = bcrypt.compareSync(req.body.password, user.password)

        if (!isMatch)
            return res.status(401).send('Email e/ou senha invalido(s)')

        const payload = {
            // atributos de usuarios ----------
            iat: now,
            exp: now + (60 * 60 * 24 * 3)
        }

        res.json({
            ...payload,
            token: jwt.encode(payload, autoSecret)
        })
    }

    const validateToken = async (req, res) => {
        const userData = req.body || null

        try {
            if (userData) {
                const token = jwt.decode(userData.token, autoSecret)
                if (new Date(token.exp * 1000) > new Date()) {
                    return res.send(true)
                }
            }
        } catch (msg) {
            // problem token
            res.send(400).send('Acessor invalido!')
        }

        res.send(false)
    }
}