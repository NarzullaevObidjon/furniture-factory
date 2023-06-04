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
                            <h5 class="modal-title" id="exampleModalLabel">Foydalanuvchi Qo'shish</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form:form action="/user" method="post" modelAttribute="userDto"
                                       enctype="multipart/form-data">
                                <div class="mb-3">
                                    <label for="phone-add" class="form-label">Telefon raqami</label>
                                    <form:input type="text" class="form-control" id="phone-add" path="phone"
                                                placeholder="+998901234567"/>
                                </div>
                                <div class="mb-3">
                                    <label for="fname-add" class="form-label">Ism</label>
                                    <form:input type="text" class="form-control" id="fname-add" path="firstName"
                                                placeholder="Palonchi"/>
                                </div>
                                <div class="mb-3">
                                    <label for="lname-add" class="form-label">Familiya</label>
                                    <form:input type="text" class="form-control" id="lname-add" path="lastName"
                                                placeholder="Pistonchiyev"/>
                                </div>
                                <div class="mb-3 input-group">
                                    <div class="form-check">
                                        <label for="role-coordinator" class="form-check-label">
                                            <form:radiobutton id="role-coordinator" path="role" value="COORDINATOR"
                                                              checked="checked" class="form-check-input"/>
                                            Coordinator
                                        </label>
                                    </div><br>
                                    <div class="form-check">
                                        <label for="role-admin" class="form-check-label">
                                            <form:radiobutton id="role-admin" path="role" value="ADMIN"
                                                              class="form-check-input"/>
                                            Admin
                                        </label>
                                    </div><br>
                                    <div class="form-check">
                                        <label for="role-director" class="form-check-label">
                                            <form:radiobutton id="role-director" path="role" value="DIRECTOR"
                                                              class="form-check-input"/>
                                            Director
                                        </label>
                                    </div><br>
                                </div>
                                <div class="input-group">
                                    <label for="image">Image:</label>
                                    <form:input type="file" id="image" class="form-control" path="image"/>
                                </div>
                                <button type="submit" class="btn btn-primary">Saqlash</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <table class="table mb-4">
                <thead>
                <tr>
                    <th scope="col">TR</th>
                    <th scope="col">Rasm</th>
                    <th scope="col">Ism</th>
                    <th scope="col">Familiya</th>
                    <th scope="col">Telefon raqam</th>
                    <th scope="col">Role</th>
                    <th scope="col">Amallar</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td id="image">
                            <img style="width: 64px; height: 45px" src="${user.imagePath}" alt="rasm">
                        </td>
                        <td id="fname">${user.firstName}</td>
                        <td id="lname">${user.lastName}</td>
                        <td id="phone">${user.phone}</td>
                        <td id="role">${user.role.toString()}</td>
                        <td id="user-id" hidden="hidden">${user.id}</td>
                        <td>
                            <button class="btn btn-warning"
                                    data-bs-toggle="modal"
                                    data-bs-target="#updateModal"
                                    id="update-btn"
                                    onclick="getFields(this)"
                            >
                                <i class="bi bi-pencil-square"></i>
                            </button>
                            <a class="btn btn-danger" href="/user/delete/${user.id}">
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
                            <h5 class="modal-title" id="updateModalLabel">Ma'lumotlarni Yangilash</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form:form id="update-form" action="/user/update" method="post"
                                       modelAttribute="userIdDto" enctype="multipart/form-data">
                                <div class="mb-3">
                                    <label for="phone-up" class="form-label">Telefon raqam</label>
                                    <form:input type="text" class="form-control" id="phone-up" path="phone"/>
                                </div>
                                <div class="mb-3">
                                    <label for="fname-up" class="form-label">Ism</label>
                                    <form:input type="text" class="form-control" id="fname-up" path="firstName"/>
                                </div>
                                <div class="mb-3">
                                    <label for="lname-up" class="form-label">Familya</label>
                                    <form:input type="text" class="form-control" id="lname-up" path="lastName"/>
                                </div>
                                <div class="mb-3 input-group">
                                    <div class="form-check">
                                        <label for="role-coordinator" class="form-check-label">
                                            <form:radiobutton id="role-coordinator" path="role" value="COORDINATOR"
                                                              class="form-check-input"/>
                                            Coordinator
                                        </label>
                                    </div><br>
                                    <div class="form-check">
                                        <label for="role-admin" class="form-check-label">
                                            <form:radiobutton id="role-admin" path="role" value="ADMIN"
                                                              class="form-check-input"/>
                                            Admin
                                        </label>
                                    </div><br>
                                    <div class="form-check">
                                        <label for="role-director" class="form-check-label">
                                            <form:radiobutton id="role-director" path="role" value="DIRECTOR"
                                                              class="form-check-input"/>
                                            Director
                                        </label>
                                    </div><br>
                                </div>
                                <div class="input-group">
                                    <label for="image-up">Image:</label>
                                    <form:input type="file" id="image-up" class="form-control" path="image"/>
                                </div>
                                <button type="submit" class="btn btn-primary">Yangilash</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
<script>

    window.addEventListener('DOMContentLoaded', (event) => {
        var categoryBar = document.getElementById('user-bar');
        categoryBar.classList.add('active', 'bg-primary', 'text-bg-light');
    });

    function getFields(element) {
        var row = element.closest('tr');

        var phoneValue = row.querySelector('#phone').innerText;
        var fnameValue = row.querySelector('#fname').innerText;
        var lnameValue = row.querySelector('#lname').innerText;
        var userId = row.querySelector('#user-id').innerText;
        var roleValue = row.querySelector('#role').innerText;

        console.log(roleValue)

        var inputElement = document.createElement('input');
        inputElement.type = 'text';
        inputElement.name = 'id';
        inputElement.setAttribute('path', 'id');
        inputElement.value = userId;
        inputElement.hidden = true;

        var form = document.getElementById('update-form');
        form.appendChild(inputElement);

        var fnameInput = document.querySelector('#updateModal #fname-up');
        var lnameInput = document.querySelector('#updateModal #lname-up');
        var phoneInput = document.querySelector('#updateModal #phone-up');

        fnameInput.value = fnameValue;
        lnameInput.value = lnameValue;
        phoneInput.value = phoneValue;

        if(roleValue==="COORDINATOR"){
            document.querySelector('#updateModal #role-coordinator').checked=true;
        }else if(roleValue==="ADMIN"){
            document.querySelector('#updateModal #role-admin').checked=true;
        }else{
            document.querySelector('#updateModal #role-director').checked=true;
        }
    }
</script>
<jsp:include page="/resources/fragments/js.jsp"></jsp:include>
</body>
</html>
