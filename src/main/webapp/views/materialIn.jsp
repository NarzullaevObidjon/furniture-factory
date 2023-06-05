<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/resources/fragments/css.jsp"></jsp:include>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css"/>
    <style>
        .custom-card-body {
            display: flex;
            width: 40%;
        }

        .btn-group-toggle .btn {
            border: 1px solid black;
        }

        #formContainer .col {
            width: 25%;
            padding-right: 10px;
            padding-left: 10px;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<%--navabar--%>
<jsp:include page="/resources/fragments/nav-dashboard.jsp"/>
<br>
<br>

<div class="container-fluid mb-3">
    <%--card--%>
    <div class="row">
        <div class="col-4 mb-5">
            <div class="card" style="width: 70vh">
                <div class="card-body d-flex">
                    <div class="custom-card-body">
                        <br>
                        <div>
                            <h5 class="mb-0">Kirim</h5>
                        </div>
                        <div>
                            <a class="btn" data-bs-toggle="modal" data-bs-target="#exampleModal"><i
                                    class="bi bi-plus-circle"></i></a>
                        </div>
                    </div>
                    <div class="ml-auto">
                        <div class="btn-group btn-group-toggle" data-toggle="buttons">
                            <button class="btn"><a href="/material-in/all?code=monthly" class="text-decoration-none">oylik</a>
                            </button>
                            <button class="btn"><a href="/material-in/all?code=weekly" class="text-decoration-none">haftalik</a>
                            </button>
                            <button class="btn"><a href="/material-in/all?code=daily" class="text-decoration-none">kunlik</a>
                            </button>
                        </div>
                        <br>
                        <br>
                        <c:if test="${code.equals('monthly')}">
                            <div>
                                Oylik kirim summasi
                            </div>
                        </c:if>
                        <c:if test="${code.equals('weekly')}">
                            <div>
                                Haftalik kirim summasi
                            </div>
                        </c:if>
                        <c:if test="${code.equals('daily')}">
                            <div>
                                Kunlik kirim summasi
                            </div>
                        </c:if>
                        <div style="display: flex">
                            <div style="font-style: inherit; font-size: 28px; font-family: 'Times New Roman',serif">${sum}
                                $
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%-- end card--%>
    <br>
    <br>
</div>
<main class="col-mb-3 offset-1 ms-sm-auto">
    <h4 class="text-center">Ombordagi kirim qilingan xomashyolar ro'yxati</h4>
    <table class="table mb-4">
        <thead>
        <tr>
            <th scope="col">TR</th>
            <th scope="col">Material</th>
            <th scope="col">Ta'minlovchi</th>
            <th scope="col">Narxi</th>
            <th scope="col">Miqdori</th>
            <th scope="col">Jami narxi</th>
            <th scope="col">O'lchov birligi</th>
            <th scope="col">Sana</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${incomes}" var="income" varStatus="loop">
            <tr>
                <th scope="row">${loop.index+1}</th>
                <td>${income.materialName}</td>
                <td>${income.supplierName}</td>
                <td>${income.price}</td>
                <td>${income.amount}</td>
                <td>${income.price * income.amount}</td>
                <td>${income.measurementName}</td>
                <td>${income.incomeDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <br>
    <div class="offset-6">
        <button type="button" class="btn btn-success ">Export excel</button>
        <button type="button" class="btn btn-secondary">Print</button>
    </div>
</main>

<%--modal--%>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-fullscreen">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Material Qo'shish</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div id="formContainer" class="container">
                    <form:form action="/material-in/add" method="post" modelAttribute="dto">
                        <div class="row">
                            <div class="col">
                                <label for="materialId" class="form-label">Xomashyo</label>
                                <form:select id="materialId" path="materialId" class="form-select">
                                    <c:forEach var="material" items="${materials}">
                                        <option value="${material.id}">
                                                ${material.nameUz} | ${material.nameRu}
                                        </option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="col">
                                <label for="supplierId" class="form-label">Ta'minotchi</label>
                                <form:select id="supplierId" path="supplierId" class="form-select">
                                    <c:forEach var="supplier" items="${suppliers}">
                                        <option value="${supplier.id}">
                                                ${supplier.name}
                                        </option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="col">
                                <label for="price-add" class="form-label">Narxi</label>
                                <form:input type="text" class="form-control" id="price-add" path="price"/>
                            </div>
                            <div class="col">
                                <label for="amount-add" class="form-label">Miqdori</label>
                                <form:input type="text" class="form-control" id="amount-add" path="amount"/>
                            </div>
                            <div class="col">
                                <label for="date-add" class="form-label">Vaqt:</label>
                                <form:input type="datetime-local" class="form-control" id="date-add" path="incomeDate"
                                            placeholder="vaqt"/>
                            </div>
                        </div>
                    </form:form>
                </div>
                <div class="row mb-3">
                    <div class="col-auto">
                        <button onclick="submitAllForms()"  class="btn btn-primary">Yuborish</button>
                    </div>
                    <div class="col-auto">
                        <button onclick="add()" class="btn btn-danger">Yana</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    var modal = document.getElementById("exampleModal");
    modal.addEventListener("hidden.bs.modal", clearAdditionalForms);

    window.addEventListener('DOMContentLoaded', (event) => {
        var dropdown = document.getElementById('navbarDropdown');
        var materialDr = document.getElementById('material-dr');
        dropdown.innerText = "Xomashyo ombori";
        materialDr.classList.add('active');

        const inNavItem = document.getElementById('in-nav-item');
        inNavItem.classList.add('active');
        inNavItem.style.border = '1px solid lightgray';
    });

    function add() {
        var formContainer = document.getElementById("formContainer");
        var lastForm = formContainer.lastElementChild;
        var clonedForm = lastForm.cloneNode(true);

        var clonedInputs = clonedForm.querySelectorAll("input");
        clonedInputs.forEach(function (input) {
            input.value = "";
        });

        formContainer.appendChild(clonedForm);
    }


    function submitAllForms() {
        var formContainer = document.getElementById("formContainer");
        var forms = formContainer.getElementsByTagName("form");

        for (var i = 0; i < forms.length; i++) {
            submitFormAsync(forms[i]);
        }
        location.reload();
    }

    function submitFormAsync(form) {
        var formData = new FormData(form);
        var xhr = new XMLHttpRequest();

        xhr.open(form.method, form.action, true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                console.log("Form submitted successfully");
            }
        };

        xhr.send(formData);
    }

    function clearAdditionalForms() {
        var formContainer = document.getElementById("formContainer");
        var forms = formContainer.querySelectorAll("form");

        if (forms.length > 1) {
            for (var i = forms.length - 1; i > 0; i--) {
                formContainer.removeChild(forms[i]);
            }
        }
    }
</script>
<jsp:include page="/resources/fragments/js.jsp"></jsp:include>
</body>
</html>
