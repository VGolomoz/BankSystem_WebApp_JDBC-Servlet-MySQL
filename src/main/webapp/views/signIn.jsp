<html>
<head>
    <meta charset="UTF-8">
    <title>Banking system</title>
    <style>
       <%@include file="/styles/w3.css" %>
    </style>
</head>
<body class="w3-light-grey">
    <!-- header -->
    <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
        <h1>Banking System</h1>
    </div>

    <div class="w3-container w3-padding">
                <%
                    if (request.getSession().getAttribute("userName") != null) {
                        out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                                    "<span onclick=\"this.parentElement.style.display='none'\"\n" +
                                    "class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                                    "<h5>'" + request.getSession().getAttribute("userName") + "'</h5>\n</div>" );
                                    request.getSession().removeAttribute("userName");
                    }
                    else if(request.getSession().getAttribute("wrongData") != null){
                    out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
                                                        "<span onclick=\"this.parentElement.style.display='none'\"\n" +
                                                        "class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                                                        "<h5>'" + request.getSession().getAttribute("wrongData") + "'</h5>\n</div>" );
                                                        request.getSession().removeAttribute("wrongData");
                    }
                %>

        <form method="post" class="w3-selection w3-light-grey w3-padding">
        <label>Enter your mail:
            <input type="text" name="mail" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
        </label>

        <label>Enter your password:
            <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
        </label>
         <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Sign in</button>
        </form>


    <div class="w3-container">
    <p>Dont have an account? <a href="/registration">Registration</a>.</p>
    </div>

<footer class = "w3"></footer>
</body>
</html>