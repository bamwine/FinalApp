<?php
//error_reporting(0);
include('connect.php');
	$page=$_GET["action"];
switch($page){

	
	case 'love_tips':
		Love_Tips();
	break;	
	
	case 'lovesong':
		lovesong();
	break;
	
	
	 case'login':
	 login();
	  break;
	  
	  
	  
	 case'login2':
	 login2();
	  break;
	  
	  
	  
	 case'register':
	 register();
	  break;
	  
	 
default:
lovesong();	
	
	}
?>


<?php
function Love_Tips(){	
?>
<?php


$response = array();


$result = mysql_query("SELECT * FROM `love_tips` ORDER BY `id` ASC") or die(mysql_error());

if (mysql_num_rows($result) > 0) {
  
    $response["love"] = array();

    while ($row = mysql_fetch_array($result)) {
            // temp user array
            $item = array();
           
				$item["id"]		    = $row["id"];
				$item["content"] 	= $row["name"];
				$item["aurthor"]	= $row["aurthor"];
						
				
        
            // push ordered items into response array 
            array_push($response["love"], $item);
           }
      // success
     $response["success"] = 1;
}
else {
    // order is empty 
      $response["success"] = 0;
      $response["message"] = "No News Yet";
}
// echoing JSON response
echo json_encode($response);
	
}
?>


<?php
function lovesong(){	
?>


<?php

// array for JSON response
$response = array();

// get all items from myorder table
$result = mysql_query("SELECT * FROM `love_song` ") or die(mysql_error());

if (mysql_num_rows($result) > 0) {
  
    $response["mp4"] = array();

    while ($row = mysql_fetch_array($result)) {
            // temp user array
            $item = array();
			
				$item["id"]			= $row["id"];
				$item["name"]		= $row["name"];
				$item["file_name"]	 	= $row["file_name"];
				$item["icon"]	 	= $row["icon"];
				
        
            // push ordered items into response array 
            array_push($response["mp4"], $item);
           }
      // success
     $response["success"] = 1;
}
else {
    // order is empty 
      $response["success"] = 0;
      $response["message"] = "No Items Found";
}
// echoing JSON response
echo json_encode($response);



}
?>








<?php
function login(){	
?>


<?php
$response = array();
if (isset($_POST['email_id']) && isset($_POST['password']) ) 
  { 
    $email_id = $_POST['email_id'];
    $password = $_POST['password'];
   
	
    $result = mysql_query("Select * from login where email_id='$email_id' and password='$password'");
	
    if (mysql_num_rows($result))
	{
        $response["success"] = 1;
        $response["message"] = "Login successfully.";
        echo json_encode($response);
    } 
	else 
	{
        $response["success"] = 0;
        $response["message"] = "Please Enter correct mobile number and password.";
        echo json_encode($response);
    }
 
 }
 else 
 {
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    echo json_encode($response);
} 
?>

<?php
}	
?>




		
		
		
		
		
		

<?php
function login2(){	
?>


<?php
$response = array();
if (isset($_POST['mobile_number']) && isset($_POST['password']) ) 
  { 
    $mobile_number = $_POST['mobile_number'];
    $password = $_POST['password'];
   
	
    $result = mysql_query("Select * from login where mobile_number='$mobile_number' and password='$password'");
	
    if (mysql_num_rows($result)> 0)
	{
       $response["details"] = array();

    while ($row = mysql_fetch_array($result)) {
            // temp user array
            $item = array();
			
				$item["age"]		= $row["age"];
				$item["name"]		= $row["uname"];
				$item["email_id"]	= $row["email_id"];
				$item["mobile_number"]	 = $row["mobile_number"];
        
            // push ordered items into response array 
            array_push($response["details"], $item);
           }
      // success
     $response["success"] = 1;
     echo json_encode($response);
    } 
	else 
	{
        $response["success"] = 0;
        $response["message"] = "Please Enter correct mobile number and password.";
        echo json_encode($response);
    }
 
 }
 else 
 {
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    echo json_encode($response);
} 
?>

<?php
}	
?>





<?php
function register(){	
?>


<?php

$response = array();

if (isset($_POST['mobile_number']) && isset($_POST['password']) && isset($_POST['hint']) && isset($_POST['email_id'])) 
{  
    $mobile_number = $_POST['mobile_number'];
    $password = $_POST['password'];
    $hint = $_POST['hint'];
    $email_id = $_POST['email_id'];  
	
	include('connect.php');
	
    $result = mysql_query("Insert into login(mobile_number,password,hint,email_id) values('$mobile_number','$password','$hint','$email_id')");

    if ($result)
	{
        $response["success"] = 1;
        $response["message"] = "Registration successfully.";
        echo json_encode($response);
    }
	else
	{
      $response["success"] = 0;
      $response["message"] = "Oops! An error occurred.";
      echo json_encode($response);  
    }
 }
 
 else 
 {
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    echo json_encode($response);
 } 
?>

<?php
}	
?>




