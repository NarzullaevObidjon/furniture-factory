<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Register Page</title>
    <jsp:include page="/resources/fragments/css.jsp"></jsp:include>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-10 offset-1">
            <h1 class="mt-2 text-center">Login Page</h1>
            <c:if test="${error != null}" >
                <div class="alert alert-danger">
                    <span>${error}</span>
                </div>
            </c:if>

            <form method="post" action="/auth/login">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" name="username">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
                    <label class="form-check-label" for="rememberMe">Remember me ?</label>
                </div>
                <button type="submit" class="btn btn-success">Login</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="/resources/fragments/js.jsp"></jsp:include>
</body>
</html>
