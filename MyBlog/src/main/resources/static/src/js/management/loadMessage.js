axios({
  url: 'http://192.168.37.4:8080/getUsersMessage',
  method: 'post',
  data: {
    account: account,
    password: password,
    userName: userName
  },
  headers: {
    'Content-Type': 'application/json'
  }
}).then((result) => {
  if (result) {
    console.log('获取数据成功:', result);
    const message_Displaybox = document.querySelector('.managebox')
    console.log(result.data)
    for (let i = 0; i < result.data.length; i++) {
      const message = result.data[i];
      console.log(message)
      let message_box = document.createElement('div')
      message_box.className = 'message-box';
      message_box.innerHTML = `
      <div class="message">
          <div class="message-id">${message.id}</div>
          <div class="message-content">${message.message}</div>
        </div>
        <div class="toolbox">
          <div class="delete-btn">删除</div>
          <div class="update-btn">修改</div>
        </div>
      `
      message_Displaybox.appendChild(message_box)
      BtnFun()
    }
  }
})