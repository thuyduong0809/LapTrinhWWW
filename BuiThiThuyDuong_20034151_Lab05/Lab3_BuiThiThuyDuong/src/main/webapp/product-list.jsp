<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Quản lý sản phẩm</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="header">
    🛒 Quản lý sản phẩm
</div>

<div class="container">
    <a href="new" class="btn btn-add">➕ Thêm sản phẩm</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Hình ảnh</th>
            <th>Hành động</th>
        </tr>

        <c:forEach var="p" items="${list}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price} ₫</td>
                <td>
                    <img src="${p.urlImage}" width="90">
                </td>
                <td>
                    <a href="edit?id=${p.id}" class="btn btn-edit">Sửa</a>
                    <a href="delete?id=${p.id}"
                       class="btn btn-delete"
                       onclick="return confirm('Xóa sản phẩm này?')">
                        Xóa
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
