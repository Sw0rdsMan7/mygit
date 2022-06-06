<?php 

/*=======数据库服务器的配置参数，此部分需修改============ */

$user = 'root';  //数据库服务器访问用户名
$pwd = '123456';   //数据库服务器访问密码【请修改】
$db = 'redrescue';     //访问的数据库名
$host = 'localhost';  //数据库服务器的域名或ip地址
$port = 3306;     //数据库服务器的访问端口【请修改】

/*=======数据库服务器的配置参数，此部分需修改 end========= */

$conn = mysqli_init();
$success = mysqli_real_connect(
   $conn, 
   $host, 
   $user, 
   $pwd, 
   $db,
   $port
);
if($success!=1){
	die("数据库连接失败");
}


 ?>