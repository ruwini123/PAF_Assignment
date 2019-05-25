//--user
//--login
$(document).on("click","#btnLogin",function()
{
	var result = isValidFormLogin();
	if(result=="true")
		{ $("#formLogin").submit(); }
	
	else
		{ $("#divStsMsgLogin").html(result); }
		
});

//--client model
//--user
function isValidFormLogin()
{
	if($.trim($("#txtUserName").val())=="")
		{ return "enter username"; }
	
	if($.trim($("#txtPassword").val())=="")
	{ return "enter Password"; }
	
	return "true";
}


//--advertisements   save/update
$(document).on("click","#btnSave",function()
{
			var result = isValidFormAdvertisement();
			if(result=="true")
				{ $("#formAdvertisement").submit(); }
			
			else
				{ $("#divStsMsgAdvertisement").html(result); }
				
});

//--edit
$(document).on("click","#btnEdit",function()
{
	$("#hidMode").val(update);
	$("#hidID").val($(this).attr("param"));
	$("#adTitle").val($(this).closest("tr").find('td:eq(1)').text());
	$("#adImageLink").val($(this).closest("tr").find('td:eq(2)').text());
	$("#adDescription").val($(this).closest("tr").find('td:eq(3)').text());
	
});
//--Remove
$(document).on("click","#btnRemove", function()
{
	$("#hidMode").val("remove");
	$("#hidID").val($(this).attr("param"));
	var res = confirm("are you sure?");
		if(res == true){
			$("#formAdvertisement").submit();
		}


});

