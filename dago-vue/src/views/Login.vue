<template>

  <div class="app-login">
    <div class="bg"></div>

    <div class="account-logo">
      <transition appear appear-active-class="hinge"><img src="../assets/logo.png"  /></transition>
    </div>

    <transition appear appear-active-class="animated flipInY">
    <div class="account-container" @keyup.enter="submitForm('loginForm')">
      <div class="account-title">
        <span>登录</span>
      </div>
      <div class="account-body">
        <el-form label-position="top" :model="loginForm" ref="loginForm" label-width="100px" class="loginForm">
          <el-form-item prop="account">
            <el-input placeholder="用户名" v-model="loginForm.account" class="account-form">
              <template slot="prepend"><icon name="user-o"></icon></template>
            </el-input>
          </el-form-item>
          <el-form-item prop="pass">
            <el-input placeholder="密码" v-model="loginForm.pass" type="password" class="account-form">
              <template slot="prepend"><icon name="key"></icon></template>
            </el-input>
          </el-form-item>
          <el-form-item style="text-align: right;">
            <el-button type="primary" @click="submitForm('loginForm')">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
    </transition>
  </div>

</template>
<script>
  export default {
    name: 'Login',
    data() {
      return {
        loginForm: {
          account: '',
          pass: ''
        },
        // rules: {
        //   account: [
        //     { required: true, message: '请输入用户名', trigger: 'blur' },
        //   ],
        //   pass: [
        //     { required: true, message: '请输入密码', trigger: 'blur' },
        //     { min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur' }
        //   ]
        // }
      }
    },

    methods: {
    //   submitForm(formName) {
    //    this.$refs[formName].validate((valid) => {
    //      if (valid) {
    //        this.$router.push('/service/validator');
    //        this.$message({
    //          type: 'success',
    //          message: '登录成功'
    //        });
    //      } else {
    //        this.$message({
    //          type: 'danger',
    //          message: '登录失败!'
    //        });
    //        return false;
    //      }
    //    });
    //  },
    submitForm() {
      let userName = 'admin'
      let password = 'rzx@1218'
      let account = this.loginForm.account
      let pass = this.loginForm.pass
      if(account != userName){
         this.$message({
           type: 'warning',
           message: '用户名不存在'
         });
         return false
      }
      else if(pass != password){
         this.$message({
           type: 'warning',
           message: '密码错误'
         });
         return false
      }
      else {
         this.$router.push('/dataGovern/govern');
         this.$message({
           type: 'success',
           message: '登录成功!'
         });
      }
   },
    }
  }
</script>
<style lang='less'>
@import '../assets/styles/login';
</style>
