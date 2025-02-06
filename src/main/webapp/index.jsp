<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback Form</title>
</head>
<body>
    <h2>Feedback Form</h2>
    <form action="<%= application.getContextPath() %>/feedback" method="POST">
        <!-- Name Field -->
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" placeholder="Enter your name" required>
        <br><br>
        
        <!-- Password Field -->
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>
        <br><br>
        
        <!-- Feedback Field -->
        <label for="feedback">Feedback:</label><br>
        <textarea id="feedback" name="feedback" placeholder="Enter your feedback" rows="4" cols="50" required></textarea>
        <br><br>
        
        <!-- Submit Button -->
        <button type="submit">Submit</button>
    </form>
    
    <br>
    <a href="<%= application.getContextPath() %>/ServletOne" ><button>Cookie creation and session servlet</button></a>
    <br>
    <a href="<%= application.getContextPath() %>/SecondServlet" ><button>Cookie and session data output servlet</button></a>
    
    
    

</body>
</html>
