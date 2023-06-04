<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <jsp:include page="/resources/fragments/css.jsp"></jsp:include>
</head>
<body style="background-color: azure">
<jsp:include page="/resources/fragments/navbar.jsp"/>
<div class="container-fluid mb-3">
    <div class="row">
        <div class="col-4 mb-5">
            <div class="card">
                <div class="card-body d-flex">
                    <div class="col-3">
                        <p>
                            Ombor
                        </p>
                        <br>
                        <br>
                        <br>
                    </div>
                    <div class="col-3">
                        <p>
                            Ombordagi umumiy summa
                        </p>
                        <br>
                        <br>
                        <strong>
                            0
                        </strong>$
                    </div>
                </div>
            </div>
        </div>
        <div class="col-4 mb-5 offset-3">
            <div class="card ">
                <div class="card-body d-flex">
                    <div class="col-3">
                        <p>
                            Tayyor mebellar
                        </p>
                        <br>
                        <br>
                        <br>
                        <strong>
                            0
                        </strong> $
                    </div>
                    <div class="col-3">
                        <p>
                            umumiy
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <div class="row">
        <div class="col-5 mb-5">
            <div class="card ">
                <div class="card-body">

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Maxsulot</th>
                            <th scope="col">Miqdori</th>
                            <th scope="col">Umumiy summasi</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-5 mb-5 offset-1">
            <div class="card ">
                <div class="card-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nomi</th>
                            <th scope="col">Qoldiq.o'lchovi</th>
                            <th scope="col">Umumiy</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
<jsp:include page="/resources/fragments/js.jsp"></jsp:include>
</body>
</html>
