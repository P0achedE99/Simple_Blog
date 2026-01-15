const navbox_touch = document.querySelector('.nav-touchbox')
const navbox_self = document.querySelector('.nav-box')
navbox_touch.addEventListener('mouseenter',function(){
  navbox_self.style.top = '0px'
})

navbox_self.addEventListener('mouseleave',function(){
  navbox_self.style.top = '-80px'
})