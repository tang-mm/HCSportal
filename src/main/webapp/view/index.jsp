<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:wrapper>
	<div class="grc-page">
		<h1>Welcome</h1>
		<br />
		<br />
		<br />
	</div>
	
<!-- 	<span>Test: Login to MediaSense</span> -->
<!-- 	<form action="https://172.31.16.172:8440/ora/authenticationService/authentication/signIn" method="POST" onsubmit="return postJson(this)"> -->
<!--     <input name="userName" value="user" /> -->
<!--     <input name="PassWord" value="12345" /> -->
<!--     <input type="submit" /> -->
<!-- 	</form> -->
<!-- 	<div class="response">Response:</div> -->
<!-- 	<span>Test: Login to CCDM</span>
		<form action="https://172.31.14.195/Portal/logon.aspx" method="POST" onsubmit="return postJson(this)"> -->
<!--     <input name="uxtbUsername" value="user" /> -->
<!--     <input name="uxtbPassword" value="12345" /> -->
<!--     <input type="submit" /> -->
<!-- 	</form> -->
<script>
function postJson(form) {
    var action = $(form).attr('action');
    var user = $('[name="userName"]', form).val();
    var pass = $('[name="PassWord"]', form).val();
    
    console.log('action=' + action + ', user=' + user + ', pass=' + pass);
    
    $.ajax({
    	headers: {'Accept': 'application/json', 
    		'Content-Type': 'application/json'},
        url: action,
        type: 'POST',
        data: JSON.stringify({ userName: user, PassWord: pass }),
        success: function(server_response) {
            // do something after login
            if (server_response == 'success') {
	            $("#response").html(server_response);
            }
        },
        error: function() {
            console.log('error');
        }
    });

    return false;
}

</script>

</t:wrapper>
