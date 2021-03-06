<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link href="/css/common.css" rel="stylesheet">
</head>

<body>
	<%@ include file="/common/top.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

<!-- 				<form id="frm" class="form-horizontal" role="form" -->
<!-- 					action="/studentUpdate" method="get"> -->

<%-- 					<input type="hidden" name="id" value="${studentVo.id}"> --%>

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">제품 ID</label>
						<div class="col-sm-10">
							<img src="/pic?id=${lprodList.lprod_id}" width="150">
						</div>
					</div>

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">제품 구분</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.lprod_gu }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">제품 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.lprod_nm }</label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">제품 정보 수정</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
