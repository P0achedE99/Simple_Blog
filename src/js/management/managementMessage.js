function BtnFun() {
  const deleteBtns = document.querySelectorAll('.delete-btn')
  const updateBtns = document.querySelectorAll('.update-btn')

  deleteBtns.forEach(itmes => {
    itmes.addEventListener('click', function () {
      if (confirm('确定删除该留言吗?')) {
        const messageId = this.parentElement.previousElementSibling.querySelector('.message-id');
        // console.log(messageId.innerText)
        axios({
          url: 'http://192.168.37.4:8080/deleteMessage',
          method: 'post',
          data: {
            account: account,
            password: password,
            userName: userName,
            id: messageId.innerText
          },
          headers: {
            'Content-Type': 'application/json'
          }
        }).then((result) => {
          if (result.data === 'illegalUser') {
            alert('非法用户提交')
          } else if (result.data === 'deleteSuccess') {
            alert('删除成功')
          } else if (result.data === 'deleteFailed') {
            alert('删除失败')
          }
          location.reload()
        })
      }
    })
  })

  updateBtns.forEach(itmes => {
    itmes.addEventListener('click', function () {
      if (confirm('确定修改该留言吗?')) {
        const message = prompt("请输入修改后的留言")
        const messageId = this.parentElement.previousElementSibling.querySelector('.message-id');
        axios({
          url: 'http://192.168.37.4:8080/updateMessage',
          method: 'post',
          data: {
            account: account,
            password: password,
            userName: userName,
            id: messageId.innerText,
            message: message
          },
          headers: {
            'Content-Type': 'application/json'
          }
        }).then((result) => {
          if (result.data === 'illegalUser') {
            alert('非法用户提交')
          } else if (result.data === 'updateSuccess') {
            alert('修改成功')
          } else if (result.data === 'updateFailed') {
            alert('修改失败')
          }
          location.reload()
        })
      }
    })
  })
}
