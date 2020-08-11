function validation()
{
	
	var uname=document.getElementById("name").value;
	var mobileno=document.getElementById("mobile").value;
	var emailid=document.getElementById("email").value;
	var error_message=document.getElementById("error_message");
	var text;
	error_message.style.padding="14px";
	error_message.style.background="#eb676c";

//  validating the user data by calling the function	
	
	if(UserName_validate(uname))
	{
		if(mobile_validate(mobileno))
			{
				if(email_validate(emailid))
					{
					error_message.style.padding="0px";
//					error_message.style.background="#6ee686";
//					text="Valid Data. Proceed to Submit";
//					error_message.innerHTML=text;
//					error_message.stye.padding="0px";
					return true;
					}
					else
					{
						
						text="Please, Enter Valid Email.";
						error_message.innerHTML=text;
					return false;
					}
			}
			else
			{
			
				text="Please, Enter Valid MobileNo.";
				error_message.innerHTML=text;
				return false;
			}
	}
	else
	{

		text="Please, Enter Full Valid Name";
		error_message.innerHTML=text;
		return false;
	}
	return true;
}

// user name validate function


function UserName_validate(name)
{ 
	var letters = /^[A-Za-z\s]+$/;
	if(name.match(letters) && name.length>3)
	{
	return true;
	}
	else
	{
		return false;
	}
}

//  mobile no validation functn

function mobile_validate(mobile)
{
	var mobileNo=/^[0-9]+$/;
	if(mobile.match(mobileNo) && mobile.length===10 )
		{
			return true;
		}
	else
	{

		return false;
	}
}


//	email validation function

function email_validate(email)
{
	var mail=/^([a-zA-Z0-9\.-]+)@([a-zA-Z0-9-]+).([a-z]{2,10})(.[a-z]{2,8})?$/;
	if(email.match(mail))
		{
		return true;
		}
	else
		{

		return false;
		}
}