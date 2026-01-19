# Phần mềm Chat Online (Java Socket)

## 📌 Giới thiệu
Đây là đồ án môn học với đề tài **Phần mềm chat online**,
được xây dựng bằng ngôn ngữ **Java**, sử dụng **Socket** để giao tiếp
giữa **Server** và **Client**.

Ứng dụng cho phép nhiều client kết nối tới server và gửi/nhận tin nhắn
theo thời gian thực.

---

## 🛠 Công nghệ sử dụng
- Java SE
- Java Socket (TCP)
- Mô hình Client – Server
- IDE: Visual Studio Code

---

## 📂 Cấu trúc project
---

## 🗄️ Cơ sở dữ liệu

Ứng dụng sử dụng cơ sở dữ liệu để lưu trữ thông tin người dùng và lịch sử tin nhắn.

### Các bảng chính:
- **user**: lưu thông tin tài khoản
- **message**: lưu nội dung tin nhắn

File thiết kế CSDL: `database.sql`

> Hiện tại chương trình chat hoạt động bằng Socket (Client–Server).  
> CSDL được thiết kế để phục vụ việc mở rộng trong tương lai.

