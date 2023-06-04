<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/resources/fragments/css.jsp"></jsp:include>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css"/>
</head>
<body>
<jsp:include page="/resources/fragments/navbar.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/resources/fragments/left-bar.jsp"/>
        <main class="col-md-9 offset-1 ms-sm-auto">
            <button class="btn btn-success m-10" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Qo'shish
            </button>
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Xaridor Qo'shish</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="/client" method="post" >
                                <div class="mb-3">
                                    <label for="name-add" class="form-label">Ismi</label>
                                    <input type="text" class="form-control" id="name-add" name="name"/>
                                </div>
                                <div class="mb-3">
                                    <label for="phone-add" class="form-label">Telefon raqami</label>
                                    <input type="text" class="form-control" id="phone-add" name="phone"/>
                                </div>
                                <button type="submit" class="btn btn-primary">Saqlash</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <table class="table mb-4">
                <thead>
                <tr>
                    <th scope="col">TR</th>
                    <th scope="col">Ismi</th>
                    <th scope="col">Telefon raqami</th>
                    <th scope="col">Amallar</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${clients}" var="client" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td id="name">${client.name}</td>
                        <td id="phone">${client.phone}</td>
                        <td id="client-id" hidden="hidden">${client.id}</td>
                        <td>
                            <button class="btn btn-warning"
                                    data-bs-toggle="modal"
                                    data-bs-target="#updateModal"
                                    id="update-btn"
                                    onclick="getFields(this)"
                            >
                                <i class="bi bi-pencil-square"></i>
                            </button>
                            <a class="btn btn-danger" href="/client/delete/${client.id}">
                                <i class="bi bi-trash"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="updateModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="updateModalLabel">Yangilash</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="/client/update" method="post" id="update-form">
                                <div class="mb-3">
                                    <label for="name-up" class="form-label">Ismi</label>
                                    <input type="text" class="form-control" id="name-up" name="name"/>
                                </div>
                                <div class="mb-3">
                                    <label for="phone-up" class="form-label">Telefon raqami</label>
                                    <input type="text" class="form-control" id="phone-up" name="phone"/>
                                </div>
                                <button type="submit" class="btn btn-primary">Yangilash</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
<script>
    window.addEventListener('DOMContentLoaded', (event) => {
        var categoryBar = document.getElementById('client-bar');
        categoryBar.classList.add('active', 'bg-primary', 'text-bg-light');
    });

    function getFields(element) {
        var row = element.closest('tr');

        var nameValue = row.querySelector('#name').innerText;
        var phoneValue = row.querySelector('#phone').innerText;
        var clientIdValue = row.querySelector('#client-id').innerText;

        var inputElement = document.createElement('input');
        inputElement.type = 'text';
        inputElement.name = 'id';
        inputElement.setAttribute('path', 'id');
        inputElement.value = clientIdValue;
        inputElement.hidden = true;

        var form = document.getElementById('update-form');
        form.appendChild(inputElement);

        var nameUpInput = document.querySelector('#updateModal #name-up');
        var phoneInput = document.querySelector('#updateModal #phone-up');
        nameUpInput.value = nameValue;
        phoneInput.value = phoneValue;
    }
</script>
<jsp:include page="/resources/fragments/js.jsp"></jsp:include>
</body>
</html>
