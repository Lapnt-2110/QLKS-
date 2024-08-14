Create database QLKS_DuAn1 --Bước 1
Use QLKS_DuAn1 -- Bước 2
Drop database QLKS_DuAn1

--Bước 3
Create table NhanVien (
	MaNv nvarchar(10) primary key,
	Hoten nvarchar(100), 
	Matkhau nvarchar(30),
	Vaitro bit
)
go

Create table KhachHang(
	SDT int primary key,
	Hoten nvarchar(50),
	SoCMND nvarchar(20)
)
go

Create table Phong(
	SoPhong nvarchar(5) primary key, 
	LoaiPhong Nvarchar(20), 
	Gia float, 
	TinhTrang bit
) 
go

Create table Hoadon(
	MaHD int primary key,
	SoDTKhach int,
	SoPhong nvarchar(5)
)
go

Create table DatPhong(
	MaDat nvarchar(10) primary key, 
	MaNV nvarchar(10),
	SDTKhach int, 
	NgayDen date, 
	NgayDi date, 
	Sophong nvarchar(5)
)
go


INSERT INTO NhanVien (MaNV, HoTen, MatKhau, VaiTro)
VALUES
    ('NV001', 'Nguyen Van A', '123456', 1),
    ('NV002', 'Tran Thi B', '123456', 0),
    ('NV003', 'Le Van C', '123456', 0),
    ('NV004', 'Hoang Thi D', '123456', 1),
    ('NV005', 'Pham Van E', '123456', 1);
go

INSERT INTO KhachHang (SDT, HoTen, SoCMND)
VALUES
    (0901234567, 'Nguyen Van A', '1234567890'),
    (0912345678, 'Tran Thi B', '9876543210'),
    (0987654321, 'Le Van C', '5678901230'),
    (0945678901, 'Hoang Thi D', '4567890120'),
    (0978901234, 'Pham Van E', '7890123450'),
    (0923456789, 'Nguyen Thi F', '2345678901'),
    (0967890123, 'Tran Van G', '8901234561'),
    (0934567890, 'Le Thi H', '3456789012'),
    (0956789012, 'Hoang Van I', '9012345672'),
    (0990123456, 'Pham Thi J', '6789012343');

INSERT INTO DatPhong (MaDat, MaNV, SDTKhach, NgayDen, NgayDi, SoPhong)
VALUES
    ('DP001', 'NV001', 0901234567, '2023-10-01', '2023-10-05', '101'),
    ('DP002', 'NV002', 0912345678, '2023-11-15', '2023-11-20', '102'),
    ('DP003', 'NV003', 0987654321, '2023-12-10', '2023-12-15', '201'),
    ('DP004', 'NV001', 0945678901, '2023-09-20', '2023-09-25', '202'),
    ('DP005', 'NV002', 0978901234, '2024-01-05', '2024-01-10', '301'),
    ('DP006', 'NV003', 0923456789, '2024-02-15', '2024-02-20', '302'),
    ('DP007', 'NV001', 0967890123, '2024-03-10', '2024-03-15', '401'),
    ('DP008', 'NV002', 0934567890, '2024-04-20', '2024-04-25', '402'),
    ('DP009', 'NV003', 0956789012, '2024-05-05', '2024-05-10', '501'),
    ('DP010', 'NV001', 0990123456, '2024-06-15', '2024-06-20', '502');


INSERT INTO Phong (SoPhong, LoaiPhong, Gia, TinhTrang) VALUES
    ('101', 'Phòng Đơn', 100.0, 1),
    ('102', 'Phòng Đơn', 100.0, 0),
    ('201', 'Phòng Đôi', 150.0, 1),
    ('202', 'Phòng Đôi', 150.0, 1),
    ('301', 'Phòng Gia Đình', 200.0, 0),
    ('302', 'Phòng Gia Đình', 200.0, 1),
    ('401', 'Phòng VIP', 300.0, 0),
    ('402', 'Phòng VIP', 300.0, 1),
    ('501', 'Phòng Đơn', 100.0, 0),
    ('502', 'Phòng Đơn', 100.0, 1);


alter table DatPhong
add constraint fk_DatPhong_NV foreign key (MaNV) References NhanVien(MaNV)

alter table DatPhong
add constraint fk_DatPhong_KhachHang foreign key (SDTKhach) references KhachHang(SDT)

alter table DatPhong
add constraint fk_DatPhong_Phong foreign key (Sophong) references phong(Sophong)

alter table HoaDon
add constraint fk_HoaDon_KhachHang foreign key (SoDTKhach) references KhachHang(SDT)

alter table HoaDon
add constraint fk_HoaDon_Phong foreign key (SoPhong) references Phong(SoPhong)

