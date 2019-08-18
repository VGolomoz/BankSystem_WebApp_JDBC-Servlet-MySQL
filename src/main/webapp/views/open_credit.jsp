<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title>Credit offers</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
   <%@include file="/styles/w3.css" %>
</style>
<body>

<div class="w3-top">
    <div class="w3-bar w3-blue-gray w3-card w3-left-align w3-medium">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">UA</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">EN</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">RU</a>
        <a href="/open_deposit" class="w3-bar-item w3-button w3-border w3-light-grey">Deposit Account</a>
        <a href="/open_credit" class="w3-bar-item w3-button w3-border w3-light-grey w3-disabled">Credit Account</a>
        <a href="/operations" class="w3-bar-item w3-button w3-border w3-light-grey">My Operations</a>
    </div>
</div>
<br>
<br>

<% if (request.getAttribute("request denied") != null) {
 out.println ( "<div class=\"w3-panel w3-pale-red w3-border\">" +
               "<h3>Unfortunately, but your Credit request was denied</h3>" +
               "<p>If you have questions, please contact support for more information</p></div>");
               }

else if (request.getAttribute("request pending") != null) {
 out.println ( "<div class=\"w3-panel w3-pale-yellow w3-border\">" +
               "<h3>Your Credit request is pending</h3>" +
               "<p>If you have questions, please contact support for more information</p></div>");
               }
else {
out.println ("<div class=\"w3-panel w3-pale-green w3-border\">" +
  "<p>You do not have credit account yet</p>" +
  "<h3>You can apply for credit account</h3>" +
 "</div>" +

"<div class=\"w3-row-padding\">" +

"<div class=\"w3-third w3-margin-bottom\">" +
  "<ul class=\"w3-ul w3-border w3-center w3-hover-shadow \">" +
    "<li class=\"w3-black w3-xlarge w3-padding-32 align-items: center\">Servo</li>" +
    "<li class=\"w3-padding-16\"><b>UAH</b> Currency</li>" +
    "<li class=\"w3-padding-16\"><b>100 000</b> Limit</li>" +
    "<li class=\"w3-padding-16\"><b>12% per annum</b> Rate</li>" +
   "</li>" +
    "<li class=\"w3-light-grey w3-padding-24\">" +
       "<form method=\"post\">" +
          "<input type=\"hidden\"  name=\"currency\" value=\"UAH\">"+
          "<input type=\"hidden\"  name=\"limit\" value=\"100000\">" +
          "<input type=\"hidden\"  name=\"rate\" value=\"12\">"+
           "<button type=\"submit\" class=\"w3-button w3-green w3-padding-large\">Send request</button>"+
          "</form>" +
    "</li>"+
  "</ul>"+
"</div>" +

"<div class=\"w3-third w3-margin-bottom\">" +
  "<ul class=\"w3-ul w3-border w3-center w3-hover-shadow \">" +
    "<li class=\"w3-blue w3-xlarge w3-padding-32 align-items: center\">Servo+</li>" +
    "<li class=\"w3-padding-16\"><b>UAH</b> Currency</li>" +
    "<li class=\"w3-padding-16\"><b>250 000</b> Limit</li>" +
    "<li class=\"w3-padding-16\"><b>15% per annum</b> Rate</li>" +
   "</li>" +
    "<li class=\"w3-light-grey w3-padding-24\">" +
       "<form method=\"post\">" +
          "<input type=\"hidden\"  name=\"currency\" value=\"UAH\">"+
          "<input type=\"hidden\"  name=\"limit\" value=\"250000\">" +
          "<input type=\"hidden\"  name=\"rate\" value=\"15\">"+
           "<button type=\"submit\" class=\"w3-button w3-green w3-padding-large\">Send request</button>"+
          "</form>" +
    "</li>"+
  "</ul>"+
"</div>" +

"<div class=\"w3-third w3-margin-bottom\">" +
  "<ul class=\"w3-ul w3-border w3-center w3-hover-shadow \">" +
    "<li class=\"w3-green w3-xlarge w3-padding-32 align-items: center\">Servo++</li>" +
    "<li class=\"w3-padding-16\"><b>USD</b> Currency</li>" +
    "<li class=\"w3-padding-16\"><b>10 000</b> Limit</li>" +
    "<li class=\"w3-padding-16\"><b>7.5% per annum</b> Rate</li>" +
   "</li>" +
    "<li class=\"w3-light-grey w3-padding-24\">" +
       "<form method=\"post\">" +
          "<input type=\"hidden\"  name=\"currency\" value=\"USD\">"+
          "<input type=\"hidden\"  name=\"limit\" value=\"10000\">" +
          "<input type=\"hidden\"  name=\"rate\" value=\"7.5\">"+
           "<button type=\"submit\" class=\"w3-button w3-green w3-padding-large\">Send request</button>"+
          "</form>" +
    "</li>"+
  "</ul>"+
"</div>" +
"</div>");
} %>


<div class="w3-bar w3-grey w3-padding">
   <form method="get" action = "/signIn">
   <button type=submit class="w3-btn w3-left w3-border w3-border-white w3-round-large" >Back to main</button>
   </form>

   <form method="get" action = "/logout">
      <button type=submit class="w3-btn w3-right w3-border w3-border-white w3-round-large" >Logout</button>
   </form>
</div>

</body>
</html>
