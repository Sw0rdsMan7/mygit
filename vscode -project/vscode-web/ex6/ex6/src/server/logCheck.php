<?php
    //获取数据
    $userName =$_POST["name"];
    $userPwd=$_POST["pwd"];

    //连接数据库
    include("conn.php");
    //操作数据库
    $sql="select user_name,user_pwd from users  where user_name='$userName' and user_pwd='$userPwd '";
    mysqli_query($conn,$sql);
    

?>