import request from '@/utils/request'

export default {
    login(params) {
        return request({
            url: '/login',
            method: 'get',
            params
        })
    },
    getAccountByToken(params){
        return request({
            url: '/users/account',
            method: 'get',
            params
        })
    },
    logout(params) {
        return request({
            url: '/logout',
            method: 'get',
            params
        })
    },
    listUsers(params) {
        return request({
            url: '/users',
            method: 'get',
            params
        })
    },
    deleteUser(id) {
        return request({
            url: '/users/' + id,
            method: 'delete',
        })
    },
    addUser(data) {
        return request({
            url: '/users',
            method: 'post',
            data
        })
    },
    updateUser(data) {
        return request({
            url: '/users',
            method: 'put',
            data
        })
    }


}
