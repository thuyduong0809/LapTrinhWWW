<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>
<h2>${product == null ? "Thêm" : "Sửa"} sản phẩm</h2>

<form action="${product == null ? 'insert' : 'update'}" method="post">
    <input type="hidden" name="id" value="${product.id}">
    Tên: <input name="name" value="${product.name}"><br>
    Giá: <input name="price" value="${product.price}"><br>
    Ảnh URL: <input name="urlImage" value="${product.urlImage}"><br>
    <button>Lưu</button>
</form>

<a href="list">⬅ Quay lại</a>
</body>
</html>
