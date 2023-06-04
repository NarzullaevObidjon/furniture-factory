<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
  <jsp:include page="/resources/fragments/css.jsp"></jsp:include>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />
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
      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Material Qo'shish</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <form:form action="/material" method="post" modelAttribute="materialDto" enctype="multipart/form-data">
                <div class="mb-3">
                  <label for="name-uz-add" class="form-label">Nomi(Uz)</label>
                  <form:input type="text" class="form-control" id="name-uz-add" path="nameUz" placeholder="Nomi(Uz)" />
                </div>
                <div class="mb-3">
                  <label for="name-ru-add" class="form-label">Nomi(Ru)</label>
                  <form:input type="text" class="form-control" id="name-ru-add" path="nameRu" placeholder="Nomi(Ru)"/>
                </div>
                <div class="mb-3">
                  <label for="code-add" class="form-label">Code</label>
                  <form:input type="text" class="form-control" id="code-add" path="code" placeholder="Code (unique)"/>
                </div>
                <div class="mb-3">
                  <label for="norma-add" class="form-label">Norma</label>
                  <form:input type="text" class="form-control" id="norma-add" path="norma" placeholder="Norma"/>
                </div>
                <div class="mb-3 input-group">
                  <label for="measurementId" class="input-group-text">O'lchov birligi</label>
                  <form:select id="measurementId" path="measurementId" class="form-select">
                    <c:forEach var="measurement" items="${measurements}">
                      <option value="${measurement.id}" ${measurement.id == materialDto.measurementId ? 'selected' : ''}>
                          ${measurement.nameUz} | ${measurement.nameRu}
                      </option>
                    </c:forEach>
                  </form:select>
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
          <th scope="col">Code</th>
          <th scope="col">Rasm</th>
          <th scope="col">Nomi(Uz)</th>
          <th scope="col">Nomi(Ru)</th>
          <th scope="col">Norma</th>
          <th scope="col">O'lchov birligi</th>
          <th scope="col">Amallar</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${materials}" var="material" varStatus="loop">
          <tr>
            <th scope="row">${loop.index+1}</th>
            <td id="code">${material.code}</td>
            <td id="image">
              <img style="width: 64px; height: 45px" src="${material.imagePath}" alt="rasm">
            </td>
            <td id="name-uz">${material.nameUz}</td>
            <td id="name-ru">${material.nameRu}</td>
            <td id="norma">${material.norma}</td>
            <td id="measurement">${material.measurementName}</td>
            <td id="measurement-id" hidden="hidden">${material.measurementId}</td>
            <td id="material-id" hidden="hidden">${material.id}</td>
            <td>
              <button class="btn btn-warning"
                      data-bs-toggle="modal"
                      data-bs-target="#updateModal"
                      id="update-btn"
                      onclick="getFields(this)"
              >
                <i class="bi bi-pencil-square"></i>
              </button>
              <a class="btn btn-danger"  href="/material/delete/${material.id}">
                <i class="bi bi-trash"></i>
              </a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="updateModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="updateModalLabel">Materialni Yangilash</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body">

              <form:form id="update-form" action="/material/update" method="post" modelAttribute="materialIdDto" enctype="multipart/form-data">
                <div class="mb-3">
                  <label for="name-uz-add" class="form-label">Nomi(Uz)</label>
                  <form:input type="text" class="form-control" id="name-uz-up" path="nameUz" placeholder="Nomi(Uz)" />
                </div>
                <div class="mb-3">
                  <label for="name-ru-up" class="form-label">Nomi(Ru)</label>
                  <form:input type="text" class="form-control" id="name-ru-up" path="nameRu" placeholder="Nomi(Ru)"/>
                </div>
                <div class="mb-3">
                  <label for="code-up" class="form-label">Code</label>
                  <form:input type="text" class="form-control" id="code-up" path="code" placeholder="Code (unique)"/>
                </div>
                <div class="mb-3">
                  <label for="norma-up" class="form-label">Norma</label>
                  <form:input type="text" class="form-control" id="norma-up" path="norma" placeholder="Norma"/>
                </div>
                <div class="mb-3 input-group">
                  <label for="measurementId" class="input-group-text">O'lchov birligi</label>
                  <form:select id="measurement-id-up" path="measurementId" class="form-select">
                    <c:forEach var="measurement" items="${measurements}">
                      <option value="${measurement.id}" id="measurement-${measurement.id}">
                          ${measurement.nameUz} | ${measurement.nameRu}
                      </option>
                    </c:forEach>
                  </form:select>
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
    var categoryBar = document.getElementById('material-bar');
    categoryBar.classList.add('active', 'bg-primary', 'text-bg-light');
  });
  function getFields(element) {
    var row = element.closest('tr');

    var nameUzValue = row.querySelector('#name-uz').innerText;
    var nameRuValue = row.querySelector('#name-ru').innerText;
    var normaValue = row.querySelector('#norma').innerText;
    var codeValue = row.querySelector('#code').innerText;
    var measurementIdValue = row.querySelector('#measurement-id').innerText;
    var materialId = row.querySelector('#material-id').innerText;

    var inputElement = document.createElement('input');
    inputElement.type = 'text';
    inputElement.name = 'id';
    inputElement.setAttribute('path','id');
    inputElement.value = materialId;
    inputElement.hidden = true;

    var form = document.getElementById('update-form');
    form.appendChild(inputElement);

    var nameUzUpInput = document.querySelector('#updateModal #name-uz-up');
    var nameRuUpInput = document.querySelector('#updateModal #name-ru-up');
    var normaInput = document.querySelector('#updateModal #norma-up');
    var codeInput = document.querySelector('#updateModal #code-up');

    var str  = '#measurement-'+measurementIdValue;
    console.log(str);
    console.log('#updateModal '+str);

    var measurementInput = document.querySelector('#updateModal '+str);
    nameUzUpInput.value = nameUzValue;
    nameRuUpInput.value = nameRuValue;
    normaInput.value = normaValue;
    codeInput.value = codeValue;
    measurementInput.setAttribute('selected', 'selected');
  }
</script>
<jsp:include page="/resources/fragments/js.jsp"></jsp:include>
</body>
</html>
