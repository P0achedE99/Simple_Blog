const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))

const id = userInfo.id
const userName = userInfo.userName
const account = userInfo.account
const password = userInfo.password
const permission = userInfo.permission

const userNameText = document.querySelector('.userName-text')
userNameText.innerText = userName
const userIdText = document.querySelector('.user-ID')
userIdText.innerText = id
const userPermissionText = document.querySelector('.user-permission')
if(permission === 1){
  userPermissionText.innerText = '管理员'
}else if(permission === 0){
  userPermissionText.innerText = '普通用户'
}