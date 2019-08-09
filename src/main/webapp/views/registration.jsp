<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Registration</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h1>Bank System</h1>
        </div>

        <div class="w3-container w3-padding">

            <div class="w3-card-4">
                <div class="w3-container w3-center w3-green">
                    <h2>Registration</h2>
                </div>

<form method="post"  class="w3-selection w3-light-grey w3-padding">
    <label>Enter your mail:
        <input type="text" name="mail" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
    </label>

    <label>Enter your password:
        <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
    </label>

    <label>Enter your name:
            <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
     </label>

     <label>Enter your lastname:
             <input type="text" name="lastname" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
      </label>

    <label>Enter your address:
        <input type="text" name="address" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
    </label>

    <label>Enter your mobile phone:
            <input type="text" name="mobile_phone" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
    </label>

    <label>Enter your birtday:
            <input type="date" name="birthday" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
    </label>
    <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
</form>
   </div>
        </div>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
                    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main menu</button>
                </div>
            </body>
        </html>