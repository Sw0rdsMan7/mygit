<?php
    $code=0;
    $data=[];
    $msg=["登陆失败","登陆成功"];
    // $userName=$_POST["name"];
    // $userPwd=$_POST["password"];
    $userName="12";
    $userPwd="123";

    include("conn.php");
    include("functions.php");
    $sql="select user_name,user_pwd from users where user_name='$userName',user_pwd='$userPwd'";
    $rs=mysqli_query($conn,$sql);
    if(mysqli_fetch_array($rs))
        $code=1;
    mysqli_close($conn);
    getApiResult($code,$msg[$code],$data);

?>