
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="/resources/img/logo.png" width="113" height="21" alt="LOGO"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Dashboard
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Dashboard</a></li>
                        <li><a class="dropdown-item" href="#">Mijozlar</a></li>
                        <li><a class="dropdown-item" href="#">Ta'minotchilar</a></li>
                        <li><a class="dropdown-item" href="/warehouse/materials">Xomashyo ombori</a></li>
                        <li><a class="dropdown-item" href="#">Maxsulot ombori</a></li>
                        <li><a class="dropdown-item" href="#">Hisobot</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/category/all">Katalog</a>
                </li>
            </ul>
        </div>
        <span class="navbar-text" style="text-align: center">
            ${user.getUsername()}<br>
            ${user.getLastName()} ${user.getFirstName()}
        </span>
    </div>
</nav>
