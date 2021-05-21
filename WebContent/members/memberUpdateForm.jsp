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
<title>베란다에서 온 파프리카 회원 정보 수정</title>
	<script type="text/javascript">
		
		function nickCheck() {
			var nickname = document.joinform.nickname.value;
		
			if (nickname.length < 3 || nickname.length > 8) { /* 닉네임 길이 확인 */
				alert('닉네임은 3글자 이상 8글자 이하로 입력 해 주세요!');
				document.joinform.nickname.focus();
				return false;
			} // 닉네임 길이 확인 if문 끝
			
			var url = '<%=FormNo%>meNickcheck&nickname='+nickname;
			window.open(url,'mywin','height=150,width=300');
			
			if (document.joinform.isCheck.value == 'false') { /* 중복 체크 확인 */
				alert('중복 확인을 눌러 주세요!');
				document.joinform.nickname.focus();
				return false;
			} // 중복 체크 if문 끝
			
			alert('사용 가능 합니다!');
			
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

 
<!-- CSS Form 받아오기 -->
<link rel="stylesheet" href="css/joinForm.css">

<div class="container">
<br>
<hr>

<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">회원 정보 수정</h4>
	<h4 class="card-title mt-3 text-center">닉네임 주소 전화번호</h4>
    
	<form name="joinform" action="<%=FormYes%>" method="post">
	<input type="hidden" name="user_no" value="${loginfo.no}">
	
	<%-- 아이디 입력란 --%>
	<div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-user"></i> 
		    </span>
		 
		 </div>
        
        <input type="text" class="form-control" id="fakeid" 
			name="fakeid" disabled="disabled" value="${loginfo.user_id}">
        
    </div> 
    
    <%-- 비밀번호 입력란 --%>
    <div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-lock"></i> 
		    </span>
		 
		 </div>
        
        <input type="password" class="form-control" id="fakepwd" 
			name="fakepwd" disabled="disabled" value="${loginfo.user_pwd}">
        
    </div>
    
    <%-- 닉네임 입력란 --%>
	<div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-user-o"></i> 
		    </span>
		 
		 </div>
        
        <input name="nickname" class="form-control" type="text" value="${loginfo.user_nickname}">
        
        <input type="hidden" name="command" value="meUpdate">
        <input type="hidden" name="nickisCheck" value="false">
        
    	<input type="button" name="${bean.nickname}" value="중복 확인" class="btn btn-nickcheck" onclick="nickCheck();">
    
    </div> 
    
    <%-- 주소 --%>
    <div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-map-o"></i> 
		    </span>
		 
		 </div>
        
        <input type="text" class="form-control" name="postcode" id="sample3_postcode" placeholder="우편번호" readonly="readonly" value="${loginfo.user_postcode}">
        
        <input type="button" class="btn btn-postcode" onclick="sample3_execDaumPostcode()" value="우편번호 찾기">
        
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
			 
		 	<input type="text" class="form-control" name="address" id="sample3_address" readonly="readonly" value="${loginfo.user_address}"><br>
		 </div>
		 
		 <div class="form-group input-group">
	
			<div class="input-group-prepend">
			
			    <span class="input-group-text"> 
			    	<i class="fa fa-map"></i> 
			    </span>
			 
			 </div>
			 
			 <input type="text" class="form-control" name="address1" id="sample3_extraAddress" readonly="readonly" value="${loginfo.user_address1}">

		 	
		 </div>
		 
		 <div class="form-group input-group">
	
			<div class="input-group-prepend">
			
			    <span class="input-group-text"> 
			    	<i class="fa fa-bed"></i> 
			    </span>
			 
			 </div>
		 	
		 				 
			 <input type="text" class="form-control" name="address2" id="sample3_detailAddress" value="${loginfo.user_address2}">
		 	
		 </div>
    
    	<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
			<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
		</div>
    
    <%-- 연락처 입력란 --%>
    <!-- <div class="form-group input-group">
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
    </div> -->
    
    <%-- 회원 정보 수정 버튼 --%>                                      
    <div class="form-group">
        <button type="submit" class="btn btn-warning btn-block"> 회원 정보 수정 </button>
        <button type="reset" class="btn btn-warning btn-block"> 초기화 </button>
    </div> 
    
</form>

</article>
</div> <!-- card.// -->

</div> 
<!--container end.//-->

</body>
</html>
<%@ include file="./../common/footer.jsp"%>