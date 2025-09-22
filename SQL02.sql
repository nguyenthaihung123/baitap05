-- Tạo database
CREATE DATABASE BaiTap05;
GO


-- Bảng Categories
CREATE TABLE categories (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    description NVARCHAR(500)
);
GO

-- Bảng Users
CREATE TABLE users (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(100) NOT NULL UNIQUE,
    password NVARCHAR(255) NOT NULL,
    role NVARCHAR(50) NOT NULL
);
GO

-- Bảng Videos
CREATE TABLE videos (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    title NVARCHAR(255) NOT NULL,
    url NVARCHAR(500) NOT NULL,
    category_id BIGINT,
    CONSTRAINT fk_videos_category FOREIGN KEY (category_id) REFERENCES categories(id)
);
GO
-- Categories mẫu
INSERT INTO categories (name, description) VALUES
(N'Lập trình Java', N'Khóa học Java cơ bản đến nâng cao'),
(N'Cơ sở dữ liệu', N'Khóa học SQL Server, MySQL, PostgreSQL');

-- Users mẫu
INSERT INTO users (username, password, role) VALUES
(N'admin', N'123456', N'ADMIN'),
(N'user1', N'123456', N'USER');

-- Videos mẫu
INSERT INTO videos (title, url, category_id) VALUES
(N'Java Spring Boot CRUD', N'https://youtube.com/java-crud', 1),
(N'Học SQL Server cơ bản', N'https://youtube.com/sql-server', 2);
