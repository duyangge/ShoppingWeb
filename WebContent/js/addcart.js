
function instantbuy(){
	if(confirm("亲!\n\n您确认是否下单，下单须填写详细信息")){
			//检查是否填写收货信息
			var gnum=document.getElementById("number").value;//
			var gid=document.getElementById("gid").value;//
			var unitprice=document.getElementById("unitprice").value;//
			var allMoney=unitprice*gnum;//
			window.location.href="${pageContext.request.contextPath}/orders_addOrders.action?gid="+gid+"&gnum="+gnum+"&allMoney="+allMoney; 
		}else{return;}
}

function pitchon() {//提交订单中的商品id与对应的数量,总价格，商品总数量，
	var bb = "";
	var temp = "";
	var itemsnum = " ";
	var a = document.getElementsByName("gidlist");
	for ( var i = 0; i < a.length; i++) {
		if (a[i].checked) {
			temp = a[i].value;
			bb = bb + "," +temp;
			alert("hid_num:"+temp);
			var x="hid_num:"+temp;
			alert("x:"+typeof x);
			console.log("x:"+typeof x);
			var allnum= "hid_num4";
			alert("allnum::"+typeof allnum);
			console.log("allnum:"+typeof allnum);
			var hid_num=document.getElementById(typeof String(allnum)).value
			//var hid_num=document.getElementById("hid_num"+temp).value;
			//alert(hid_num);
			//alert(hid_num.innerHTML);
			alert(hid_num);
			itemsnum = itemsnum +","+hid_num;
			
		}
	}
	if(bb == "" || bb.length == 0){
		alert("请勾选需要的资源项!");
		return;
	}
	//var gnum=document.getElementById("number").value;//
	//var gid=document.getElementById("gid").value;//
	//var unitprice=document.getElementById("unitprice").value;//
	var allMoney=unitprice*gnum;//
	/*window.location.href="${pageContext.request.contextPath}/orders_addOrders.action?gid="+gid+"&gnum="
	   +gnum+"&allMoney="+allMoney+"&gidlist="+bb+"&itemsnum="+itemsnum; */
	}
function allSelect(){
	var a = document.getElementsByName("gidlist");
	for ( var i = 0; i < a.length; i++) {
		if (!a[i].checked) {
			a[i].checked=true;
		}
	}
}
function add( gid , uid){//增加数量
	var num=parseInt(document.getElementById("number").value);
	if(num<100){
		document.getElementById("number").value=++num;
		 window.location.href="${pageContext.request.contextPath }/cart_deleCart.action?gnum="
			 +num+"&gid="+gid+"&uid="+uid;
	}
}
function reduce(){//减少数量
	var num=parseInt(document.getElementById("number").value);
	if(num>1){
		document.getElementById("number").value=--num;
	}
}
function changeNumber() {  
    var num = parseInt(document.getElementById("number").value);  
    if(num > 100) {  
        document.getElementById("number").value = 100;  
    } else if(num < 1) {  
        document.getElementById("number").value = 1;  
    }  
} 
function addCart(){
	var username=document.getElementById("username");
	if(username.value==""){
		alert("亲!\n\n你还没登录呢！");
		return;
	}else{
		alert("添加购物车成功！");
		return;
	}
}
function removeall(){
	if(confirm("亲!\n\n您确认要全部清空购物车吗？")){
	   window.location.href="delallcartsServlet";
	 }else{
	   return;
	  }
}
/*function DelCart(){
	if(confirm("亲!\n\n您确认要从您的购物车的移出吗？")){
	}else{
		   history.back(-1);
	}
}*/
function GoOrder(){
	alert("亲!\n\n您已下单成功");
}
function back(){
	history.back();
}
function GoBack(){
	if(confirm("亲!\n\n您确认要返回吗？")){
		history.back();
	}else{
		  return;
	}
}
function launchgoods(){
	alert("亲!\n\n我们尽快安排发货的，请不要担心！");
}
function getUrlVars() {//解析传递的参数
    var vars = [],
        hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for (var i = 0; i < hashes.length; i++) {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
  //var grid = getUrlVars()["id"]; 
}
function buygoods(){//立即下单
	if(confirm("亲!\n\n您确认是否下单，下单须填写详细信息")){
	//	getUrlVars();
		var grnum=myform.numbershowtext.value;
		var grid=myform.itemidname.value;
	 	window.location.href="NowBuysServlet?gid="+grid+"&number="+grnum; 
	}else{
		   return;
		  }
}
function adds(){//增加数量价格
	var num=parseInt(document.getElementById("number").value);
	var sum=parseInt(document.getElementById("subprice").value);
	var unit=parseInt(document.getElementById("unitprice").value);
	if(num<100){
		document.getElementById("number").value=++num;
		document.getElementById("subprice").value=sum+unit;
	}
}
function reduces(){//减少数量价格
	var num=parseInt(document.getElementById("number").value);
	var sum=parseInt(document.getElementById("subprice").value);
	var unit=parseInt(document.getElementById("unitprice").value);
	if(num>1){
		document.getElementById("number").value=--num;
		document.getElementById("subprice").value=sum-unit;
	}
}