ASM1:
- Sử dụng bootstrap để xây dựng giao diện web cho đẹp mắt

- đã tách nhỏ các thành phần trang web ra file riêng bằng jsp: inclue

- đã xử dụng css external nằm ở thư mục css, hiểu được cách gắn đường dẫn đến file
để khi cần có thể css được thành phần giao diện

- đã cấu hình init param trong xml tài khoản admin

- đọc được dữ liệu từ form, nếu kiểm tra thành công thì chạy lại trang index,
không thì chạy về trang login

- chạy được trên localhost ảnh để trong thư mục assets/img

ASM2:
- Thông báo lỗi nếu đăng nhập sai: sử dụng doPost, kiểm tra tài khoản có nhập thiếu tên, mk 
nếu ko đúng thì báo lỗi
- Tài khoản đăng nhập đúng thực hiện chuyển tiếp đến trang admin, trong trang admin có logout
trở về trang đăng nhập
- thực hiện sử dụng cookie để lưu dữ tên và mk đăng nhập lần tới
- sử dụng session để hiện tên người dùng trong trang admin
loginForm.jsp , LoginServlet.java , admin.jsp

