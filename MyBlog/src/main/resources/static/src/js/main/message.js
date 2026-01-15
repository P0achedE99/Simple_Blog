const subbtn = document.querySelector('.submit-btn')
const form = document.querySelector('.message-form')
const text_text = document.querySelector('.message-input-text')
let utext = ''
subbtn.addEventListener('click', function () {
  //获取userInfo检测是否登录
  const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
  if (userInfo === null) {
    alert("请登录")
    return
  }
  utext = text_text.value
  if (!utext) {
    alert('请输入文字')
  } else {
    if ((utext.length > 50)) {
      alert('请检查:内容不能超过50字')
      return
    } else {
      const userName = userInfo.userName
      const account = userInfo.account
      const password = userInfo.password
      axios({
        url: 'http://192.168.37.4:8080/submitMessage',
        method: 'post',
        data: {
          // account & password & userName & message
          account: account,
          password: password,
          userName: userName,
          message: utext
        },
        headers: {
          'Content-Type': 'application/json'
        }
      }).then((result) => {
        if (result) {
          console.log(result)
          if (result.data === 'illegalUser') {
            alert('非法用户提交')
          } else if (result.data === 'submitSuccess') {
            alert('提交成功!')
          }else if (result.data === 'submitFailed'){
            alert('提交失败!')
          }
          location.reload()
        }
      })
    }
  }
})

