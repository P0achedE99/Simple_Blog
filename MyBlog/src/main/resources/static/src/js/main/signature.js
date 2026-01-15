const text = document.querySelector(".signature")
const input_text = [
  '知不足而奋进,望远山而前行.',
  '苦厄难磨凌云志,不死终有出头日.',
  '只攀登,莫问高.',
  '无人扶我青云志,我自踏雪至山巅.'
]
let index = 0
let length = input_text[index].length
let count = input_text.length
let now_text = input_text[index]
function next_text(){
  if (index > count-1){
    index = 0
  }
  index++
  length = input_text[index].length
  now_text = input_text[index]
}

let temp = 0
let flag = true
let timer1 = setInterval(function(){
  if (flag){
    temp++
    text.innerText = now_text.substring(0,temp)
    if(temp === length){
      flag = false
    }
  }else{
    temp--
    text.innerText = now_text.substring(0,temp)
    if(temp === 0){
      flag = true
      next_text()
    }
  }
},500)