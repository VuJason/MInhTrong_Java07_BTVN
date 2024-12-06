<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>403 Forbidden</title>
    <style>
        /* Cài đặt nền trang */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            color: #333;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            overflow: hidden;
        }

        /* Tạo khung chứa nội dung */
        .container {
            text-align: center;
            background: #ffffff;
            padding: 40px 30px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 100%;
        }

        /* Định dạng cho icon cảnh báo */
   .icon {
    font-size: 80px;
    color: #e74c3c;
    animation: blinkAnimation 3s infinite, scaleAnimation 3s infinite alternate; /* Nhấp nháy và phóng to với thời gian chậm hơn */
}

/* Hiệu ứng nhấp nháy chậm */
@keyframes blinkAnimation {
    0%, 100% {
        opacity: 1; /* Hiển thị */
    }
    50% {
        opacity: 0; /* Ẩn icon */
    }
}

/* Hiệu ứng phóng to và thu nhỏ */
@keyframes scaleAnimation {
    0%, 100% {
        transform: scale(1); /* Kích thước bình thường */
    }
    50% {
        transform: scale(1.3); /* Phóng to icon */
    }
}


        /* Căn chỉnh cho tiêu đề */
        h1 {
            font-size: 36px;
            color: #e74c3c;
            margin-bottom: 20px;
            font-weight: bold;
        }

        /* Phong cách cho đoạn văn mô tả */
        p {
            font-size: 18px;
            margin-bottom: 30px;
            color: #555;
            line-height: 1.6;
        }

        /* Chỉnh sửa cho nút quay lại */
        a {
            text-decoration: none;
            color: #fff;
            background-color: #3498db;
            padding: 12px 25px;
            border-radius: 5px;
            font-size: 18px;
            transition: background-color 0.3s ease, transform 0.3s ease;
            display: inline-block;
        }

        /* Hiệu ứng hover cho nút */
        a:hover {
            background-color: #2980b9;
            transform: translateY(-4px);
        }

        /* Responsive - Điều chỉnh với màn hình nhỏ */
        @media (max-width: 600px) {
            .container {
                padding: 30px 20px;
            }

            h1 {
                font-size: 28px;
            }

            p {
                font-size: 16px;
            }

            a {
                padding: 10px 20px;
                font-size: 16px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Icon cảnh báo nhấp nháy -->
        <div class="icon">⚠️</div>
        <h1>Truy cập bị từ chối</h1>
        <p>Bạn không có quyền truy cập vào chức năng này. Vui lòng kiểm tra quyền hoặc liên hệ với quản trị viên.</p>
        <a href="javascript:history.back()">Quay lại Trang Chính</a>
    </div>
</body>
</html>
