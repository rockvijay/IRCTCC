<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/login.css">
</head>
<body>
   <h1>Welcome to IRCTC</h1>
    <div class="form-container">
        <h1 id="tittle">Login</h1>
        <form action="/login" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" oninput="inputchange(this)" name="username" placeholder="Username" required />
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Password" required />
            </div>
            <button type="submit">Login</button>
        </form>
        <div class="signup-link">
            <p>Don't have an account?</p>
            <a href="/register">Sign Up</a>
           
        </div>
    </div>
</body>
<script type="text/javascript">
var msg='${error}';
if(msg!==''){
	alert(msg);
}
</script>
</html>
