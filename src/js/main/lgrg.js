const lgrgBtn = document.querySelector('#lgrg-btn')
const loginContainer = document.querySelector('.login-container')
const mainbox = document.querySelector('.container')
const body = document.querySelector('body')
const unameInputBox = document.querySelector('.uname-inputbox')

//获取提交登录按钮
const submitBTN = document.querySelector('.signin-btn')

const accountInput = document.querySelector('.account-input');
const pwdInput = document.querySelector('.password-input');
const usernameInput = document.querySelector('.username-input');

lgrgBtn.addEventListener('click', function () {
  loginContainer.style.opacity = '1'
  loginContainer.style.pointerEvents = 'all'
  mainbox.style.pointerEvents = 'none'
  body.style.overflow = 'hidden'
})
//lgflag负责判断界面处于登录状态还是注册状态
let lgflag = true

function closeLgRgBox(){
  loginContainer.style.opacity = '0'
  loginContainer.style.pointerEvents = 'none'
  mainbox.style.pointerEvents = 'all'
  body.style.overflow = 'auto'
  unameInputBox.style.display = "none"
  document.querySelector('.box-header').innerText = '登录'
  document.querySelector('.reg-btn').innerText = '注册账号'
  submitBTN.innerText = '登录'
  if(!lgflag){
    lgflag = !lgflag
  }
}

//关闭注册登录窗口按钮
document.querySelector('.back-login').addEventListener('click',function(){
  closeLgRgBox()
})
//登录注册界面 切换
document.querySelector('.reg-btn').addEventListener('click', () => {
  if (!lgflag) {
    unameInputBox.style.display = "none"
    document.querySelector('.box-header').innerText = '登录'
    document.querySelector('.reg-btn').innerText = '注册账号'
    submitBTN.innerText = '登录'
    usernameInput.value = ""
    lgflag = !lgflag
  } else {
    unameInputBox.style.display = "flex"
    document.querySelector('.box-header').innerText = '注册'
    document.querySelector('.reg-btn').innerText = '登录账号'
    submitBTN.innerText = '注册'
    lgflag = !lgflag
  }
})
//使用AJAX进行数据的提交
submitBTN.addEventListener('click', function () {
  if(accountInput.value.trim() === '' || pwdInput.value.trim() === ''){
    alert("账号密码不能为空")
    return
  }

  if(!lgflag && usernameInput.value.trim() === ''){
    alert("用户名不能为空")
    return
  }

  if (lgflag) {
    //lgflag为true 执行登录
    axios({
      url: 'http://192.168.37.4:8080/login',
      method: 'post',
      data:{
        account:accountInput.value.trim(),
        password:pwdInput.value.trim()
      },
      headers: {
          'Content-Type': 'application/json'
      }
    }).then((result) => {
      //对服务器返回的数据做后续处理
      console.log(result)
      console.log(result.data)
      if(result.data === ''){
        alert('登录失败,请检查账号或密码')
      }else{
        closeLgRgBox()
        alert('登录成功')
        const data = (result.data)
        const userInfo = {
          account : data.account,
          id : data.id,
          password : data.password,
          permission : data.permission,
          userName : data.userName
        }
        sessionStorage.setItem('userInfo',JSON.stringify(userInfo))
      }
    })
  } else {
    //lgflag为false 执行注册
    axios({
      url: 'http://192.168.37.4:8080/register',
      method: 'post',
      data:{
        account:accountInput.value.trim(),
        password:pwdInput.value.trim(),
        userName:usernameInput.value.trim()
      },
      headers: {
          'Content-Type': 'application/json'
      }
    }).then((result) => {
      //对服务器返回的数据做后续处理
      console.log(result.data)
      if(result.data === 'registerSuccess'){
        alert("注册成功,请登录！")
      }else{
        alert("注册失败,用户名或账号已被占用")
      }
    })
    

  }
})