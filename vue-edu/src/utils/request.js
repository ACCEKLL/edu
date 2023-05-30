import axios from "axios";
import Cookies from "js-cookie"
import {Message} from "element-ui";

const request = axios.create({
    baseURL: process.env.VUE_APP_BASE_API,
    withCredentials: false,
    timeout: 25000
})

request.interceptors.request.use(config => {
        let token = Cookies.get('my_token')
        config.headers['token'] = token ? token : ''
        return config
    }, error => {
        Message({
            message: '请求发送失败',
            type: 'error'
        })
        return Promise.reject(error)
    }
)
request.interceptors.response.use(response => {
        let res = response.data
        if (res.code === 1) {
            Message({
                showClose: true,
                duration: 5000,
                message: '操作成功',
                type: 'success'
            })
        } else if (res.code === -1) {
            Message({
                showClose: true,
                duration: 5000,
                message: res.msg+'!!!!',
                type: 'warning'
            })
            return Promise.reject(res)
        }
        return res
    }, error => {
        if (error.response.status === 401) {
            Message({
                message: '无此权限',
                type: 'error'
            })
        } else {
            Message({
                message: '系统异常',
                type: 'error'
            })
        }
        return Promise.reject(error)
    }
)

export default request
