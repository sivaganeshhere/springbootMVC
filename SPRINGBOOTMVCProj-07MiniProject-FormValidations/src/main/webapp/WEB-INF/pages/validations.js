function validation(frm){
	frm.vflag.value="yes";
	document.getElementById("enameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";

	let ename=frm.ename.value;
	let job=frm.job.value;
	let sal=frm.sal.value;
	let flag=true;
	if(enam==""){
		document.getElementById("enameErr").innerHTML="Employee Name is Mandatory (js)";
		return false;
	}else if(ename.length>10){
				document.getElementById("enameErr").innerHTML="Employee Name length mustbe less than 10(js)";
				return false;
	}if(job==""){
		document.getElementById("jobErr").innerHTML="Employee job is Mandatory(js)";
		return false;	
	}else if(job.length>9){
		document.getElementById("jobErr").innerHTML="Employee job length mustbe less than 9(js)";
		return false;
	}if(sal==""){
		document.getElementById("salErr").innerHTML="Employee Salary is Mandatory(js)";
		return false;
	}else if(isNaN(sal)){
		document.getElementById("salErr").innerHTML="Employee Salary must be numeric(js)";
		return false;
	}else if(sal<0||sal>100000){
		document.getElementById("salErr").innerHTML="Employee sal in range of  1 to 100000(js)";
	return false;
	}
	return flag;
}//function