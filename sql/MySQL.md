# MySQL ALL

1. Install
   * MySQL installer
   * Docker
2. SQL trong MySQL
   * DDL
   * DML
   * Table (CREATE TABLE __ /CREATE TABLE __ AS SELECT __)
   * Select (1/n trường, WHERE, ORDER BY, Sử dụng các hàm, GROUP BY, JOIN,..)
   * Insert (from 1 recors/select table)
   * Update
   * Delete

3. Cấu trúc MySQL Database
4. Tối ưu SQL trong MySQL
   * SQL Explain
   * SQL Explain analyze
   * SQL Index
   * SQL Partition
   * Btree
   * Khác
5. Tối ưu tham số trong MySQL
   * Buffer Cache Hit
   * Table Cache Hit
   * Definition Cache Hit
   * Temporary Table trên Memory
6. Sao lưu, khôi phục trong MySQL
   * Logical Backup
   * Replica
7. So sánh với các loại Database
   * MySQL vs Postgre SQL
   * MySQL vs PL/SQL


## 1. Install
### MySQL installer
**Windows**
1. Manual instal
* Download zip file: https://downloads.mysql.com/archives/community/
* Unzip
* Run cmd trong folder
```sh
mysqld.exe --initialize
```
* Root account trong file <name_pc>.err
* Conncent vào MySQL bằng cmd sau
```sh
mysql -u root -p
```
2. Automation install

* Download file installer tương ứng thiết bị: https://dev.mysql.com/downloads/installer/
* Run installer
* Setting path, root account,...

3. Và có thể thử thêm các cách khác như XAMPP, MySQL Workbench

**Ubuntu (Linux/MacOS)**
> Với MacOS có thể sử dụng chung cách này hoặc sử dụng installer tương tự trên windows
* Terminal update chỉ mục các package hệ thống và ứng dụng
```sh
sudo apt update
```

* Cài đặt package mysql-server
```sh
sudo apt install mysql-server
```

* Start mysql-server
```sh
sudo systemctl start mysql.service
```

* Cầu hình tài khoản root của MySQL cho lần đầu tiên
```sh
sudo mysql
```

* Cài đặt password
```sh
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
```

* Thực thi script installation để cài đặt password/xóa anonymouse uses/diable root login remotely/xóa test database/reload privilege table
```sh
sudo mysql_secure_installation
```

* Check MySQL hoạt động
```sh
sudo systemctl status mysql
```

* Connect MySQL với tài khoản root (syntax: mysql -u \<user> -p \<password>)
```sh
mysql -u root -p
```


## 2. SQL trong MySQL
### 2.1 DDL
> DDL là Data Definition Language (Ngôn ngữ định nghĩa dữ liệu)
> CREATE, ALTER, DROP, RENAME

### 2.2 DML
> DML là Data Manipulation Language (Ngôn ngữ thao tác dữ liệu)
> SELECT, INSERT, UPDATE, DELETE

### 2.3 Table
**Định nghĩa**
> Table là tập hợp những cột và hàng (Field/Column và Record/Row)
> Field/Column là thuộc tính của table, biểu diễn tên gọi cho data trong đó
> Record/Row là tập hợp các giá trị biểu hiện khác nhau về cùng 1 đối tượng

Ví dụ:

| Id       |      Name     |  Cost |
|----------|:-------------:|------:|
| 1        |  left-aligned |  1600 | <= Đây là Record/Row
| 2        |    centered   |    12 | <= Đây là Record/Row
| 3        | right-aligned |     1 | <= Đây là Record/Row

Field/Column: ID, Name, Cost. 
Field/Column được định nghĩa là số, ký tự, date, bool,..


**Tạo table**
```sh
CREATE TABLE \<table> (
	\<tên column1> \<kiểu dữ liệu> \<options>, 
	\<tên column2> \<kiểu dữ liệu> \<options>,
	...
);
```

Ví dụ:
```sh
CREATE TABLE data (
  -- Kiểu số nguyên
  id INT PRIMARY KEY AUTO_INCREMENT,
  tiny_int_data TINYINT NOT NULL,
  small_int_data SMALLINT NOT NULL,
  medium_int_data MEDIUMINT NOT NULL,
  int_data INT NOT NULL,
  big_int_data BIGINT NOT NULL,

  -- Kiểu số thực
  float_data FLOAT NOT NULL,
  double_data DOUBLE NOT NULL,
  decimal_data DECIMAL(10,2) NOT NULL,

  -- Kiểu chuỗi
  char_data CHAR(255) NOT NULL,
  varchar_data VARCHAR(255) NOT NULL,
  text_data TEXT NOT NULL,
  medium_text_data MEDIUMTEXT NOT NULL,
  long_text_data LONGTEXT NOT NULL,

  -- Kiểu thời gian và ngày tháng
  date_data DATE NOT NULL,
  time_data TIME NOT NULL,
  datetime_data DATETIME NOT NULL,
  timestamp_data TIMESTAMP NOT NULL,
  year_data YEAR NOT NULL,

  -- Kiểu dữ liệu nhị phân
  binary_data BINARY(255) NOT NULL,
  varbinary_data VARBINARY(255) NOT NULL,
  blob_data BLOB NOT NULL,
  mediumblob_data MEDIUMBLOB NOT NULL,
  longblob_data LONGBLOB NOT NULL,

  -- Kiểu enum và set
  enum_data ENUM('value1', 'value2', 'value3') NOT NULL,
  set_data SET('value1', 'value2', 'value3') NOT NULL,

  -- Kiểu Boolean
  bool_data BOOLEAN NOT NULL,

  -- Kiểu JSON
  json_data JSON NOT NULL,

  -- Khóa phụ và Index
  INDEX idx_int_data (int_data),  -- Tạo index cho cột int_data
  INDEX idx_date_data (date_data),  -- Tạo index cho cột date_data
  FOREIGN KEY (enum_data) REFERENCES another_table(enum_data_column),  -- Khóa ngoại tham chiếu đến bảng khác
  UNIQUE (varchar_data, bool_data)  -- Tạo unique key cho tổ hợp varchar_data và bool_data
);
```

**Tạo table với data từ select**
```sh
CREATE TABLE new_tbl [AS] SELECT * FROM orig_tbl;
```

Ví dụ:
```sh
CREATE TABLE test (a INT NOT NULL AUTO_INCREMENT,
		PRIMARY KEY (a), KEY(b))
		ENGINE=InnoDB SELECT b,c FROM test2;
```

### 2.3 Select

## 3. Cấu trúc MySQL Database
![alt text](/img/image.png)
## 4. Tối ưu SQL trong MySQL
## 5. Tối ưu tham số trong MySQL
## 6. Sao lưu, khôi phục trong MySQL
## 7. So sánh với các loại Database