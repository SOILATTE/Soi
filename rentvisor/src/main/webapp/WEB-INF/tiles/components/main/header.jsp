<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- 메인 레이아웃 헤더 -->
<div class="header">

	<!-- 메인 레이아웃 헤더 박스 왼쪽 -->
	<div class="header_box_left">
		<a href="/"><img class="header_icon_home" src="/images/icon_rentvisor.png"></a>
	</div>

	<!-- 메인 레이아웃 헤더 박스 가운데 -->
	<div class="header_box_middle">
		<img class="header_link_icon" src="/images/icon_tangerine.png" />
		<a href="/item/list"><span class="header_link_text">물품대여</span></a>
		<img class="header_link_icon" src="/images/icon_tangerine.png" />
		<a href="/board/list"><span class="header_link_text">이용후기</span></a>
		<img class="header_link_icon" src="/images/icon_tangerine.png" />
		
		<a href="/pds/list"><span class="header_link_text"><spring:message code="menu.pds.member" /></span></a>
		<img class="header_link_icon" src="/images/icon_tangerine.png" />	
	</div>
	<!-- 메인 레이아웃 헤더 박스 가운데 -->

	<!-- 메인 레이아웃 헤더 박스 오른쪽 -->
	<div class="header_box_right">

		<sec:authorize access="!isAuthenticated()">
			<form>
				<button class="header_button" formaction="/user/register">
					<spring:message code="header.joinMember" />
				</button>
				<button class="header_button" formaction="/auth/login">
					<spring:message code="header.login" />
				</button>
			</form>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
			<form action="/auth/logout" method="post">
				<sec:csrfInput />
				<button class="header_user_name" formaction="/user/register">
					<sec:authentication property="principal.username" />님
				</button>
				<button class="header_button">
					<spring:message code="action.logout" />
				</button>
			</form>
		</sec:authorize>

	</div>
	<!-- 메인 레이아웃 헤더 박스 오른쪽 -->

</div>
<!-- 메인 레이아웃 헤더 -->
<hr class="footer_stroke" />

<div class="category">
    <a href="/item/listCamera"><img src="/images/icon_camera.png"></a>
    <a href="/item/listBycicle"><img src="/images/icon_bmx.png"></a>
    <a href="/item/listHiking"><img src="/images/icon_hiking.png"></a>
    <a href="/item/listSwimming"><img src="/images/icon_diving_goggles.png"></a>
    <a href="/item/listCamping"><img src="/images/icon_tent.png"></a>
    <a href="/item/listFishing"><img src="/images/icon_fishing_rod.png"></a>
    <a href="/item/listBoardgame"><img src="/images/icon_board_game.png"></a>
    <a href="/item/listOthers"><img src="/images/icon_luggage.png"></a>
</div>

<hr>
