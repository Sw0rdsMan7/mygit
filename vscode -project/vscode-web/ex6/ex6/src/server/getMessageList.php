<?php 
	header("content-type:text/json;charset=utf-8");
	
	include("conn.php");
	$sql="select user_name,message_content from messages m left join users u on m.user_id=u.user_id";
	$stmt=mysqli_prepare($conn,$sql);
   	mysqli_stmt_execute($stmt);
   	mysqli_stmt_bind_result($stmt,$name,$content);//将执行结果储存在$name 和 $content中
   	$arrs=[];
   	$i=0;
  
   	while(mysqli_stmt_fetch($stmt)){
        $arrs[$i]["user"]=$name;
		$arrs[$i]["text"]=$content;
		$i++;
    }
    mysqli_stmt_close($stmt);
    mysqli_close($conn);
    echo json_encode($arrs);
	
?>