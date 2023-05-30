import userApi from '@/api/user'
import user from "@/api/user";
import Cookies from "js-cookie";

export default {
    name: "users",
    data() {
        return {
            page: {
                total: undefined,
                pageSize: 10,
                currentPage: 1,
            },
            nowUser: '',
            search: {
                loginName: '',
                userName: '',
                userCode: ''
            },
            isAdmin: undefined,
            currentUser: undefined,
            user: [],
            dialogVisible: false,
            dialogFormVisible: false,
            dialogFormVisible1: false,
            newUserForm: {
                loginName: '',
                password: '',
                userName: '',
                userCode: '',
                role: '',
                id: ''
            },
            updateUserForm: {
                loginName: '',
                password: '',
                userName: '',
                userCode: '',
                role: '',
                id: ''
            },
            formLabelWidth: '121px',
            rules: {
                loginName: [{required: true, message: "请输入用户名", trigger: "blur"}],
                password: [{required: true, message: "请输入密码", trigger: "blur"}],
                userName: [{required: true, message: "请输入姓名", trigger: "blur"}],
                userCode: [{required: true, message: "请输入学号", trigger: "blur"}],
                role: [{required: true, message: "请输入角色", trigger: "blur"}],
            }
        }
    },
    methods: {
        checkAuz() {
            console.log("在判断....")
            console.log(this.currentUser.role === 'admin')
            return this.currentUser.role === 'admin'
        },
        toLogin() {
            window.location.href = "/login.html"
        },
        handleOpen(key, keyPath) {
            console.log(key, keyPath)
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath)
        },
        getInfo() {
            let params = {
                pageSize: this.page.pageSize,
                currentPage: this.page.currentPage,
                loginName: this.search.loginName,
                userName: this.search.userName,
                userCode: this.search.userCode
            }
            userApi.listUsers(params).then(res => {
                // console.log(res)
                this.user = res.list
                this.page.total = res.total
            })
        },
        deleteMessage(id) {
            this.$confirm('确定要删除用户吗?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.doDelete(id)
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
        },
        doDelete(id) {
            userApi.deleteUser(id).then(res => {
                this.getInfo()
            })
        },
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    if (formName === "newUserForm") {
                        this.newUser()
                    } else if (formName === "updateUserForm") {
                        this.updateUser()
                    }
                } else {
                    return false
                }
            });
        },
        fillIn(item) {
            this.dialogFormVisible1 = true
            this.updateUserForm.loginName = item.loginName
            this.updateUserForm.password = item.password
            this.updateUserForm.userName = item.userName
            this.updateUserForm.userCode = item.userCode
            this.updateUserForm.role = item.role
            this.updateUserForm.id = item.id
        },
        newUser() {
            let data = JSON.parse(JSON.stringify(this.newUserForm))
            userApi.addUser(data).then(res => {
                this.newUserForm.loginName = ''
                this.newUserForm.password = ''
                this.newUserForm.userName = ''
                this.newUserForm.userCode = ''
                this.newUserForm.role = ''
                this.newUserForm.id = ''
                this.dialogFormVisible = false
                this.getInfo()
            })
        },
        updateUser() {
            let data = JSON.parse(JSON.stringify(this.updateUserForm))
            userApi.updateUser(data).then(rse => {
                this.dialogFormVisible1 = false
                this.getInfo()
            })
        },
        toSearch() {
            this.page.currentPage = 1
            this.getInfo()
        },
        myReset() {
            this.search.loginName = ''
            this.search.userName = ''
            this.search.userCode = ''
            this.getInfo()
        },
        handleSizeChange(val) {
            this.page.pageSize = val
            this.getInfo()
        },
        handleCurrentChange(val) {
            this.page.currentPage = val
            this.getInfo()
        },
        logout() {
            userApi.logout().then(res => {
                Cookies.remove('my_token')
                this.$router.push('/login')
            })
        },
    },
    mounted() {
        userApi.getAccountByToken().then(res => {
            // console.log('getAccountByToken')
            // console.log(res)
            this.currentUser = res
            this.isAdmin = this.currentUser.role === 'admin'
        })
        this.getInfo()
    }
}
