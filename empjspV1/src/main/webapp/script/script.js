/**
 * 
 */
function getTime(){
    const date =new Date()
   var year = date.getFullYear() 
   var month=date.getMonth()+1
   var day=date.getDate()
   var week = date.getDay()
   var hour =date.getHours()
   var min = date.getMinutes()
   var s=date.getSeconds()

   week=getweekString()
    month = month < 10 ? '0' + month : month
    day = day < 10 ? '0' + day : day
    hour = hour < 10 ? '0' + hour : hour
    min = min < 10 ? '0' + min : min
    s = s < 10 ? '0' +s : s

    var nowTime=year+'年'+month+'月'+day+'日'+'&nbsp&nbsp'+'星期'+week+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'+hour+'点'+min+'分'+s+'秒'
    return nowTime
}
 function getweekString() {
	    const weekdays = ['日', '一', '二', '三', '四', '五', '六'];
	    const date = new Date();
	    return weekdays[date.getDay()];
	}