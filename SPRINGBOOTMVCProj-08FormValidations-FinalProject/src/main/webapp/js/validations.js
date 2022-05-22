function validation(frm){
	//empty the error messages
	document.getElementById("enameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";
	//read form data
	let ename=frm.ename.value;
	let job=frm.job.value;
	let sal=frm.sal.value;
	frm.vflag.value="yes";
	let flag =true;
	//form validations (client side)
	if(ename==""){
		document.getElementById("enameErr").innerHTML="Empolyee name  is mandatory";
		flag=false;
	}else if(ename.length>10){
		document.getElementById("enameErr").innerHTML="Employee name should be max 10chars";
		flag=false;
	}
	if(job==""){
		document.getElementById("jobErr").innerHTML="Employee desgnation is mandatory";
		flag=false;
	}else if(job.length>9){
		document.getElementById("jobErr").innerHTML="Employee desg must be max 9 chars";
		flag=false;
	}
	if(sal==""){
		document.getElementById("salErr").innerHTML="Employee Salary Mandatory";
		flag=false;
	}else if(isNaN(sal)){
		document.getElementById("salErr").innerHTML="Employee Sal must be Numeric";
		flag=false;
	}else if(sal<0 || sal>100000){
		document.getElementById("salErr").innerHTML="Employee sal must be range 1 to  100000";
		flag=false;
	}
	
	return flag;
}//function