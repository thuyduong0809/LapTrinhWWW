<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Form sản phẩm</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="header">
    ✏️ ${product == null ? "Thêm sản phẩm" : "Cập nhật sản phẩm"}
</div>

<div class="container">
    <form action="${product == null ? 'insert' : 'update'}" method="post">

        <input type="hidden" name="id" value="${product.id}">

        <div class="form-group">
            <label>Tên sản phẩm</label>
            <input type="text" name="name" value="${product.name}" required>
        </div>

        <div class="form-group">
            <label>Giá</label>
            <input type="number" name="price" value="${product.price}" required>
        </div>

        <div class="form-group">
            <label>URL hình ảnh</label>
            <input type="text" name="urlImage" value="${product.urlImage}">
        </div>

        <div class="form-actions">
            <button class="btn btn-save">💾 Lưu</button>
            <a href="list" class="btn btn-back">⬅ Quay lại</a>
        </div>

    </form>
</div>

</body>
</html>
