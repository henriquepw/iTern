module.exports = app => {

    function isNotEmpty(value, msg) {
        if (!value) throw msg
        if (Array.isArray(value) && value.length === 0) throw msg
        if (typeof value === 'string' && !value.trim()) throw msg
    }

    function isEmpty(value, msg) {
        try {
            isNotEmpty(value, msg)
        } catch (msg) {
            return
        }

        throw msg
    }

    function isEquals(valueA, valueB, msg) {
        if (valueA !== valueB) throw msg
    }

    return { isNotEmpty, isEmpty, isEquals }
}