function GetAllMessages() {
  axios({
    url: 'http://192.168.37.4:8080/getMessage',
    method: 'get',
  }).then((result) => {
    if (result) {
      console.log('获取数据成功:', result);
      const message_Displaybox = document.querySelector('.message-display-box')
      console.log(result.data)
      for (let i = 0; i < result.data.length; i++) {
        const message = result.data[i];
        console.log(message)
        let message_box = document.createElement('div')
        message_box.className = 'message-box';
        message_box.innerHTML = `
      <span class="message-name">${message.userName}</span>
      <div class="message-text">${message.message}</div>
      `
        message_Displaybox.appendChild(message_box)
      }
    }
  })
}
GetAllMessages()