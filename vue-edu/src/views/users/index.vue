<template>
  <div>
    <el-row style="height: 50px">
      <el-button v-if="isAdmin" type="primary" size="mini" @click="dialogFormVisible = true">新增用户</el-button>
      <el-button size="mini" @click="logout">退出登录</el-button>
    </el-row>
    <el-row style="height: 50px">
      <el-input style="width: 180px" size="mini" placeholder="请输入用户名" v-model="search.loginName" clearable></el-input>
      <el-input style="width: 180px" size="mini" placeholder="请输入姓名" v-model="search.userName" clearable></el-input>
      <el-input style="width: 180px" size="mini" placeholder="请输入学号" v-model="search.userCode" clearable></el-input>
      <el-button type="success" size="mini" icon="el-icon-search" @click="toSearch">搜索</el-button>
      <el-button type="warning" size="mini" icon="el-icon-refresh" @click="myReset">重置</el-button>
    </el-row>
    <br>
    <el-table :data="user" stripe style="width: 100%;">
      <el-table-column height="30px" prop="loginName" label="用户名" width="180"></el-table-column>
      <el-table-column prop="password" label="密码" width="180"></el-table-column>
      <el-table-column prop="userName" label="姓名"></el-table-column>
      <el-table-column prop="userCode" label="学号"></el-table-column>
      <el-table-column prop="role" label="角色"></el-table-column>
      <el-table-column prop="id" label="UID"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button v-if="isAdmin" size="mini" type="primary" @click="fillIn(scope.row)">编辑</el-button>
          <el-button v-if="isAdmin" size="mini" type="danger" @click="deleteMessage(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        background
        @size-change="this.handleSizeChange"
        @current-change="this.handleCurrentChange"
        :current-page="this.page.currentPage"
        :page-sizes="[5, 10, 20, 50,100]"
        :page-size="this.page.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="this.page.total">
    </el-pagination>

    <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="30%">
      <span>长时间未操作，登录信息已过期，请重新登录</span>
      <span slot="footer" class="dialog-footer">
    <el-button type="primary" @click="toLogin">重新登录</el-button>
  </span>
    </el-dialog>

    <el-dialog title="填写用户信息" :visible.sync="dialogFormVisible">
      <el-form :model="newUserForm" :rules="rules" ref="newUserForm">
        <el-form-item label="用户名" prop="loginName" :label-width="formLabelWidth">
          <el-input v-model="newUserForm.loginName"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" :label-width="formLabelWidth">
          <el-input v-model="newUserForm.password" type="password" show-password></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="userName" :label-width="formLabelWidth">
          <el-input v-model="newUserForm.userName"></el-input>
        </el-form-item>
        <el-form-item label="学号" prop="userCode" :label-width="formLabelWidth">
          <el-input v-model="newUserForm.userCode"></el-input>
        </el-form-item>
        <el-form-item label="角色" prop="role" :label-width="formLabelWidth">
          <el-select v-model="newUserForm.role" placeholder="请选择角色">
            <el-option label="普通用户" value="user"></el-option>
            <el-option label="管理员" value="admin"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitForm('newUserForm')">提 交</el-button>
      </div>
    </el-dialog>

    <el-dialog title="修改用户信息" :visible.sync="dialogFormVisible1">
      <el-form :model="updateUserForm" :rules="rules" ref="updateUserForm">
        <el-form-item label="用户名" prop="loginName" :label-width="formLabelWidth">
          <el-input v-model="updateUserForm.loginName"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" :label-width="formLabelWidth">
          <el-input v-model="updateUserForm.password" type="password" show-password></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="userName" :label-width="formLabelWidth">
          <el-input v-model="updateUserForm.userName"></el-input>
        </el-form-item>
        <el-form-item label="学号" prop="userCode" :label-width="formLabelWidth">
          <el-input v-model="updateUserForm.userCode"></el-input>
        </el-form-item>
        <el-form-item label="角色" prop="role" :label-width="formLabelWidth">
          <el-select v-model="updateUserForm.role" placeholder="请选择角色">
            <el-option label="普通用户" value="user"></el-option>
            <el-option label="管理员" value="admin"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible1 = false">取 消</el-button>
        <el-button type="primary" @click="submitForm('updateUserForm')">保 存</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script src="./index.js"></script>

<style scoped>

</style>
