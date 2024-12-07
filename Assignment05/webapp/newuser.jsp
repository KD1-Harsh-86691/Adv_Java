<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>
	<form action="register.jsp" method="post">
  <label for="fname">First name:</label><br>
  <input type="text" id="fname" name="fname" ><br><br>
  <label for="lname">Last name:</label><br>
  <input type="text" id="lname" name="lname" ><br><br>
  <label for="email">Email:</label><br>
  <input type="email" id="email" name="email" ><br><br>
  <label for="passwrd">Password:</label><br>
  <input type="password" id="password" name="password" ><br><br>
  <label for="dob">Birth Date:</label><br>
  <input type="date" id="dob" name="dob"><br><br>
  <label for="usertype">Select Type</label>
  <select id="usertype" name="role" required>
  	<option value="">--Select --</option>
  	<option value="admin">Admin</option>
  	<option value="user">User</option>

  </select></br></br>
  <input type="submit" value="Submit">
</form> 
</body>
</html>