<template>
  <div>
    <div id="form1">
      <el-form label-width="80px">
        <el-form-item label="账号">
          <el-input type="text" v-model="user.account"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input type="password" v-model="user.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button id="login" type="primary" @click="logIn">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import userApi from '@/api/user'
import Cookies from "js-cookie";

export default {
  name: "login",
  data() {
    return {
      user: {
        account: '',
        password: ''
      }
    }
  },
  methods: {
    logIn() {
      userApi.login({
        loginName: this.user.account,
        password: this.user.password
      }).then(res => {
        if (res.code === 2) {
          let time = new Date(new Date().getTime() + 0.5 * 60 * 60 * 1000)
          Cookies.set('my_token', res.token, {expires: time})
          // console.log("myToken:" + Cookies.get('my_token'))
          this.$router.push('/users')
        }
      })
    }
  },
  mounted() {
    // this.logIn()
  }
}
</script>

<style scoped lang="scss">
#login {
  width: 260px;
  position: absolute;
  right: 1px
}

#form1 {
  /*上=>逆时针*/
  padding: 50px 60px 20px 15px;
  background-color: #d6f3ea;
  width: 300px;
  height: 200px;
  position: relative;
  left: 530px;
  top: 220px;
  border: 1px solid #b6f3eb;
  box-shadow: 3px 3px 5px #9cc7f3;
}
</style>
