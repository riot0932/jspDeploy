<%@page import="kr.or.ddit.lprod.model.lprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

<script>
	$(function() {
		$("table tbody tr").on("click", function() {
			//tr태그의 data-id 속성값을 읽어서 input태그의 id값으로 설정
			//form 태그를 submit
			$("#id").val($(this).data("id"));
			$("#frm").submit();
		});
	});
</script>
</head>
<body>
	<!-- top.jsp -->
	<%@ include file="/common/top.jsp"%>

	<form action="/
	lprodDetail" method="get" id="frm">
		<input type="hidden" name="id" id="id">
	</form>

	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">제품</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>제품 ID</th>
										<th>제품 구분</th>
										<th>제품 이름</th>
									</tr>
								</thead>

								<%
									List<lprodVo> lprodList = (List<lprodVo>) request
											.getAttribute("list");
								%>

								<h3>제품 목록</h3>
								<tbody>
									<%
										for (lprodVo lprodVo : lprodList) {
									%>
									<tr>
										<td><%=lprodVo.getLprod_id()%></td>
										<td><%=lprodVo.getLprod_gu()%></td>
										<td><%=lprodVo.getLprod_nm()%></td>
									</tr>
									<%
										}
									%>

								</tbody>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<%=request.getAttribute("pageNavi")%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>