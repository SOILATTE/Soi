<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- 메인 레이아웃 메뉴 -->

<div align="center">
	<table>
		<tr>
		
		<%-- 	<!-- 로그인을 하지 않은 경우 true -->
			<sec:authorize access="!isAuthenticated()">
			</sec:authorize>
 --%>
			<!-- 인증된 사용자인 경우 true -->
			<sec:authorize access="isAuthenticated()">

				<!-- 관리자 권한을 가진 사용자의 경우 true -->
				<sec:authorize access="hasRole('ADMIN')">
					<td width="120"><a href="/codegroup/list"><spring:message code="menu.codegroup.list" /></a></td>
					<td width="120"><a href="/codedetail/list"><spring:message code="menu.codedetail.list" /></a></td>
					<td width="120"><a href="/user/list"><spring:message code="menu.user.admin" /></a></td>
					<td width="120"><a href="/board/list"><spring:message code="menu.board.admin" /></a></td>
					<td width="120"><a href="/notice/list"><spring:message code="menu.notice.admin" /></a></td>
					<td width="120"><a href="/item/list"><spring:message code="menu.item.admin" /></a></td>
					<td width="120"><a href="/pds/list"><spring:message code="menu.pds.admin" /></a></td>
				</sec:authorize>

				<!-- 회원 권한을 가진 사용자인 경우 true -->
				<sec:authorize access="hasRole('MEMBER')">
					<td width="120"><a href="/coin/charge"><spring:message code="menu.coin.charge" /></a></td>
					<td width="120"><a href="/coin/list"><spring:message code="menu.coin.list" /></a></td>
					<td width="120"><a href="/useritem/list"><spring:message code="menu.useritem.list" /></a></td>
					<td width="120"><a href="/coin/listPay"><spring:message code="menu.coin.listPay" /></a></td>
				</sec:authorize>

			</sec:authorize>

		</tr>
	</table>
</div>
<hr>
