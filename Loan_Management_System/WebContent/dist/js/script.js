var request;
function sendInfo()
{
//alert('hello');
	var v=document.companyform.companyname.value;
	//alert('hello');
	var url="process.jsp?val="+v;
	if(window.XMLHttpRequest){  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject){  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
		  
		try  
		{  
		request.onreadystatechange=getInfo;  
		request.open("POST",url,true);  
		request.send();  
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}  
		}  
		  
		function getInfo(){  
		if(request.readyState==4){  
		var val=request.responseText;  
		document.getElementById('span1').innerHTML=val;  
		}  
}

		var fp;
		function checkemail()
		{
			//alert('forgot');
			var f=document.forgotpasswordform.email.value;
			var url="ForgotAjax?forgot="+f;
			if(window.XMLHttpRequest){  
				request=new XMLHttpRequest();  
				}  
				else if(window.ActiveXObject){  
				request=new ActiveXObject("Microsoft.XMLHTTP");  
				}  
				  
				try  
				{  
				request.onreadystatechange=getInfo;  
				request.open("GET",url,true);  
				request.send();  
				}  
				catch(e)  
				{  
				alert("Unable to connect to server");  
				}  
				}  
				  
				function getInfo(){  
				if(request.readyState==4){  
				var val=request.responseText;  
				document.getElementById('p1').innerHTML=val;  
				}  
		}
		
		
		
		
		
		
		
		
		
		
		
		
		