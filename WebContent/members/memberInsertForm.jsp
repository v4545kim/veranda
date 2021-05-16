<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>

<%
	/* position for grid system */	
	int offset = 2 ;
	int mywidth = twelve - 2 * offset ;
	int formleft = 3 ;
	int formright = twelve - formleft ;
	int rightButton = 2 ;
%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>베란다에서 온 파프리카에 가입하기</title>
	<script type="text/javascript">
		
		function idCheck() { /* 아이디 유효성 검사 */
			var id = document.joinform.id.value;
				
			if (id.length < 5 || id.length > 15) { /* 아이디 길이 확인 */
				alert('아이디는 5글자 이상 15글자 이하로 입력 해 주세요!');
				document.joinform.id.focus();
				return false;
			} // 아이디 길이 확인 if문 끝
			
			var url = '<%=FormNo%>meIdcheck&id='+id;
			window.open(url,'mywin','height=150,width=300');
			
			var id = document.joinform.isCheck.value;
			
			if (isCheck == 'false') { /* 중복 체크 확인 */
				alert('중복 확인 눌러 주세요!');
				return false;
			} // 중복 체크 if문 끝
			
			alert('사용 가능 합니다!');
			
		} // 아이디 유효성 검사 끝
		
		function isCheckFalse() { /* 아이디 유효성 검사 실패 시 */
			document.joinform.isCheck.valuse = false;
		}
		
		function pwdCheck() { /* 패스워드 유효성 검사 */
			
			var id = document.joinform.id.value;
			
			var pwd = document.joinform.pwd.value;
			
			var checkpwd = document.joinform.checkpwd.value;
			
			function CheckPassword(id, pwd){ /* 영(대,소)문자 + 숫자 조합 시 길이 검사 */
			    if(!/^[a-zA-Z0-9]{10,20}$/.test(pwd)){
			        alert("비밀번호는 숫자와 영문자 조합으로 10~20자리를 사용해야 합니다.");
			        return false;
			    } // if문 끝
			    
			    var chk_num = pwd.search(/[0-9]/g);		// 숫자 비교 시 사용될 변수
			   
			    var chk_eng = pwd.search(/[a-z]/ig);	// 영어(소문자) 비교 시 사용될 변수
			    
			    if(chk_num < 0 || chk_eng < 0){ /* 영소문자 + 숫자 조합 여부 검사 */
			        alert("비밀번호는 숫자와 영문자를 혼용하여야 합니다.");
			        return false;
			    } // if문 끝
			    
			    if(/(\w)\1\1\1/.test(pwd)){
			        alert("비밀번호에 같은 문자를 4번 이상 사용하실 수 없습니다.");
			        return false;
			    }
			    if(pwd.search(id) > -1){
			        alert("ID가 포함된 비밀번호는 사용하실 수 없습니다.");
			        return false;
			    }
			    return true;
			}
			
			
			if (pwd.length < 10 || pwd.length > 20) { /* 패스워드 길이 검사 */
				
				window.alert('비밀번호는 최소 10자리 20자리 이하여야 합니다!');
	
				document.getElementById('pwd').value=document.getElementById('Checkpwd').value='';
				
				document.getElementById('same').innerHTML='';
				
				return false;
			} // 패스워드 길이 유효성 검사 if문 끝
			
			if (document.getElementById('pwd').value!='' && document.getElementById('checkpwd').value != '') { /* 패스워드 빈란 여부 검사 */
				
				if (document.getElementById('pwd').value==document.getElementById('checkpwd').value) { /* 패스워드가 같은지 검사 */
				
				document.getElementById('same').innerHTML='Check it!';
				
				document.getElementById('same').style.color='blue';
				
				} else {
					document.getElementById('same').innerHTML='Retry please!';
					
					document.getElementById('same').style.color='red';
					
					return false;
				} // if-else문 끝
				
			} // 패스워드 공백 검사 if문 끝
			
		} // 패스워드 유효성 검사 끝
		
		function nickCheck() {
			var nickname = document.joinform.nickname.value;
		
			if (nickname.length < 3 || nickname.length > 8) { /* 닉네임 길이 확인 */
				alert('닉네임은 3글자 이상 8글자 이하로 입력 해 주세요!');
				document.joinform.nickname.focus();
				return false;
			} // 닉네임 길이 확인 if문 끝
			
			var url = '<%=FormNo%>memNickcheck&nickname='+nickname;
			window.open(url,'mywin','height=150,width=300');
			
			if (document.joinform.isCheck.value == 'false') { /* 중복 체크 확인 */
				alert('중복 확인을 눌러 주세요!');
				document.joinform.nickname.focus();
				return false;
			} // 중복 체크 if문 끝
			
			alert('사용 가능 합니다!');
			
		}
		
		function sexcheck() {
			var idnumber = document.joinform.idnumber.value.substring(0,1);
			
			if (idnumber == 1 || idnumber == 3) {
				joinform.sex[0].click();
			} else {
				joinform.sex[1].click();
			}
		}
		
		function emailcheck() {
			
			var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
			if(!regex.test() === false) {
				
				document.getElementById('emailsame').innerHTML='다음 단계를 진행 해 주세요!';
				
				document.getElementById('emailsame').style.color='blue';
				
				return true;
				
			} else {
				document.getElementById('emailsame').innerHTML='E-mail 형식에 맞지 않습니다.';
				
				document.getElementById('emailsame').style.color='red';
				
				return false;
			}
					
				} // if-else문 끝
				
				function service() {
					alert('죄송합니다. 서비스 준비 중 입니다.');
					return false;
				}
				
	</script>
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<script>
    // 우편번호 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }

    function sample3_execDaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample3_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample3_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample3_postcode').value = data.zonecode;
                document.getElementById("sample3_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample3_detailAddress").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
    
    
</script>

</head>
<body>
<%--
 <%
    String clientId = "6Io2ZVIAyg70911nLrPRJ";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://10.77.77.6/veranda/veranda?command=main", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
 
  <a href="<%=apiURL%>">
  <img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
 --%>
 
<!-- CSS Form 받아오기 -->
<link rel="stylesheet" href="css/joinForm.css">

<div class="container">
<br>
<hr>

<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">회원 가입</h4>
	<p class="text-center">베란다에서 온 파프리카에 오신 것을 환영 합니다!</p>
	
	<p>
		<a href="" class="btn btn-block btn-naver" onclick="service();"> 
			<i class="fab fa-naver"></i>   네이버 인증하기</a>
		
		<a href="" class="btn btn-block btn-facebook" onclick="service();"> 
			<i class="fab fa-facebook-f"></i>   페이스북 인증하기</a>
		
		<a href="" class="btn btn-block btn-google" onclick="service();"> 
			<i class="fab fa-google">
		</i>   구글 인증하기</a>
	</p>
	
	<p class="divider-text">
        <span class="bg-light">OR</span>
    </p>
    
	<form name="joinform" action="<%=FormYes%>" method="post">
	
	<%-- 아이디 입력란 --%>
	<div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-user"></i> 
		    </span>
		 
		 </div>
        
        <input name="id" class="form-control" placeholder="아이디를 입력 해 주세요!" type="text" pattern="[A-Za-z0-9]+">
        
        <input type="hidden" name="command" value="meInsert">
        <input type="hidden" name="isCheck" value="false">
        
    	<input type="button" name="${bean.id}" value="중복 확인" class="btn btn-idcheck" onclick="idCheck();">
    
    </div> 
    
    <%-- 비밀번호 입력란 --%>
    <div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-lock"></i> 
		    </span>
		 
		 </div>
        
        <input id="pwd" name="pwd" class="form-control" placeholder="비밀번호를 입력 해 주세요!" type="password" onchange="pwdCheck();">
        &nbsp;&nbsp;
        <span id="same"></span>
        <br>
    </div>
    
     <div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-lock"></i> 
		    </span>
		 
		 </div>
        
        <input id="checkpwd" name="checkpwd" class="form-control" placeholder="비밀번호를 한번 더 입력 해 주세요!" type="password" onchange="pwdCheck();">
        
        <input type="button" name="${bean.pwd}" value="비밀번호 확인" class="btn btn-checkpwd" onclick="pwdCheck();">
    
    </div>
    
    <%-- 닉네임 입력란 --%>
	<div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-user-o"></i> 
		    </span>
		 
		 </div>
        
        <input name="nickname" class="form-control" placeholder="닉네임을 입력 해 주세요!" type="text">
        
        <input type="hidden" name="command" value="meInsert">
        <input type="hidden" name="nickisCheck" value="false">
        
    	<input type="button" name="${bean.nickname}" value="중복 확인" class="btn btn-nickcheck" onclick="nickCheck();">
    
    </div> 
    
    <%-- 이름 입력란 --%>
	<div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-user-circle"></i> 
		    </span>
		 
		 </div>
        
        <input name="name" class="form-control" placeholder="이름을 입력 해 주세요!" type="text">
    
    </div> 
    
    <%-- 생년월일 & 주민번호 뒤 1자리 입력란 --%>
	<div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-birthday-cake"></i> 
		    </span>
		 
		 </div>
        
        <input name="birth" class="form-control" data-toggle="toggle" title="생년월일을 선택 해 주세요!" type="date">
    	&nbsp;&nbsp;
    	<input type="number" name="idnumber" class="form-control" placeholder="주민번호 뒤 1자리" data-toggle="toggle" title="주민번호 뒤 한자리를 입력 해 주세요! 1~4까지만 입력 해 주세요!" size="1" min="1" max="4" onclick="sexcheck();">
    </div> 
    
    
    <%-- 성별 입력란 --%>
	<div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-venus-mars"></i> 
		    </span>
		 
		 </div>
        
        <input name="sex" class="form-control" type="radio">남자
        <input name="sex" class="form-control" type="radio">여자
    </div> 
    
    <%-- e-mail 입력란 --%>
	<div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-mail-reply"></i> 
		    </span>
		 
		 </div>
        
        <input id="mail" name="mail" class="form-control" type="email" placeholder="이메일 주소를 입력 해 주세요!" onclick="emailcheck();">
       
        &nbsp;&nbsp;
        
        <span id="emailsame"></span>
    </div> 
    
    <%-- 주소 --%>
    <div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-map-o"></i> 
		    </span>
		 
		 </div>
        
        <input type="text" class="form-control" id="sample3_postcode" placeholder="우편번호" readonly="readonly">
        
        <input type="button" name="postcode" class="btn btn-postcode" onclick="sample3_execDaumPostcode()" value="우편번호 찾기">
        
        <br>
        
        <div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
			<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
		</div>
		
		</div> 
		
		<div class="form-group input-group">
	
			<div class="input-group-prepend">
			
			    <span class="input-group-text"> 
			    	<i class="fa fa-map"></i> 
			    </span>
			 
			 </div>
			 
		 	<input type="text" class="form-control" id="sample3_address" placeholder="주소" readonly="readonly"><br>
		 </div>
		 
		 <div class="form-group input-group">
	
			<div class="input-group-prepend">
			
			    <span class="input-group-text"> 
			    	<i class="fa fa-map"></i> 
			    </span>
			 
			 </div>
			 
			 <input type="text" class="form-control" id="sample3_extraAddress" placeholder="동명" readonly="readonly">

		 	
		 </div>
		 
		 <div class="form-group input-group">
	
			<div class="input-group-prepend">
			
			    <span class="input-group-text"> 
			    	<i class="fa fa-bed"></i> 
			    </span>
			 
			 </div>
		 	
		 				 
			 <input type="text" class="form-control" id="sample3_detailAddress" placeholder="상세주소를 입력 해 주세요!">
		 	
		 </div>
    
    	<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
			<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
		</div>
    
    <%-- 연락처 입력란 --%>
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    
		    <span class="input-group-text"> 
		    	<i class="fa fa-phone"></i> 
		    </span>
		</div>
		<select class="custom-select" style="max-width: 120px;">
		    <option selected="-">-- 지역 번호를 선택하여 주세요! --</option>
		    <option value="1">010</option>
		    <option value="2">02</option>
		    <option value="3">032</option>
		    <option value="4">051</option>
		    <option value="5">053</option>
		    <option value="6">062</option>
		    <option value="7">042</option>
		    <option value="8">052</option>
		    <option value="9">044</option>
		    <option value="10">031</option>
		    <option value="11">033</option>
		    <option value="12">043</option>
		    <option value="13">041</option>
		    <option value="14">063</option>
		    <option value="15">061</option>
		    <option value="16">054</option>
		    <option value="17">055</option>
		    <option value="18">064</option>
		    
		</select>
		
    	<input name="phone" class="form-control" min="111" max="9999" type="number">
    	<input name="phone1" class="form-control" min="1111" max="9999" type="number">
    </div> 
    
    <%-- 회원가입 버튼 --%>                                      
    <div class="form-group">
        <button type="submit" class="btn btn-warning btn-block"> 회원가입  </button>
    </div> 
    
    <%-- 로그인으로 돌아가기 --%>      
    <p class="text-center">이미 가입하셨습니까? 
    	<a href="http://localhost/veranda/veranda?command=meLogin">로그인</a>
    </p>                                                                 
</form>

</article>
</div> <!-- card.// -->

</div> 
<!--container end.//-->

<br><br>
<article class="bg-secondary mb-3">  
<div class="card-body text-center">
    <h3 class="text-white mt-3">Bootstrap 4 UI KIT</h3>
<p class="h5 text-white">Components and templates  <br> for Ecommerce, marketplace, booking websites 
and product landing pages</p>   <br>
<p><a class="btn btn-warning" target="_blank" href="http://bootstrap-ecommerce.com/"> Bootstrap-ecommerce.com  
 <i class="fa fa-window-restore "></i></a></p>
</div>
<br><br>
</article>
</body>
</html>