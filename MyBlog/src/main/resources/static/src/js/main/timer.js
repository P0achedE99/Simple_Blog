function updateClock() {
    let now = new Date()
    // 更新时间
    let timeString = now.toLocaleTimeString()
    document.querySelector('.timer-display').innerText = timeString;
    // 更新日期
    let dateString = formatDate(now)
    document.querySelector('.date-display').innerText = dateString;
}
function formatDate(date) {
    let month = String(date.getMonth() + 1).padStart(2, '0')
    let day = String(date.getDate()).padStart(2, '0')
    const weekdays = ['日', '一', '二', '三', '四', '五', '六'];
    let weekday = weekdays[date.getDay()]
    return `${month}月${day}日 星期${weekday}`
}
setInterval(updateClock, 1000)
updateClock()