<%@ page import="project.model.User" %>
<%@ page import="project.model.UserAccount" %>
<%@ page import="project.model.ContactDetails" %>
<%@ page contentType="charset=UTF-8" language="java" %>

<html>
<title>Client Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
   <%@include file="/styles/w3.css" %>
</style>
<body>


<div class="w3-top">
    <div class="w3-bar w3-blue-gray w3-card w3-left-align w3-medium">
    <form method = "get">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">UA</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">EN</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">RU</a>
        <a href="/open_deposit" class="w3-bar-item w3-button w3-border w3-light-grey">Deposit Account</a>
        <a href="/open_credit" class="w3-bar-item w3-button w3-border w3-light-grey">Credit Account</a>
        <a href="/operations" class="w3-bar-item w3-button w3-border w3-light-grey">My Operations</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey">Credit Requests</a>
        <form>
    </div>
</div>

<div class="w3-row-padding w3-padding-64 w3-container">
   <div class="w3-third">


   <% UserAccount userAccount = (UserAccount) request.getSession().getAttribute("userAccount");
      ContactDetails contactDetails = (ContactDetails) request.getSession().getAttribute("contactDetails");
      String deposit;
      String credit;
      if (userAccount.getDeposit()) deposit = "Opened";
      else deposit = "Not Opened";
      if (userAccount.getCredit()) credit = "Opened";
      else credit = "Not Opened";
   %>

    <h2><%out.println("Hello " + "'"+ contactDetails.getName()+ "'");%></h2>


<%out.println (" <table class=\"w3-table w3-striped w3-bordered w3-border\"> " +
             " <thead class=\"w3-teal\"> " +
             " <th style=\"width:50%\"> " + "Account Information" +
             " </th><th></th></thead> " +
             " <tr><td>Balance</td><td>"+userAccount.getBalance()+"</td></tr> " +
             " <tr><td>Currency</td><td>"+userAccount.getCurrency()+"</td></tr> " +
             " <tr><td>Validity</td><td>"+userAccount.getValidity()+"</td></tr> " +
             " <tr><td>Deposit Account</td><td>"+deposit+"</td></tr> " +
             " <tr><td>Credit Account</td><td>"+credit+"</td></tr></table>");
             %>
  <h2></h2>

  <% out.println(" <table class=\"w3-table w3-striped w3-bordered w3-border\"> " +
                 " <thead class=\"w3-teal\"><th style=\"width:50%\">Contact Details</th><th></th></thead> " +
                 " <tr><td>Name</td><td>"+contactDetails.getName()+"</td></tr> " +
                 " <tr><td>Last Name</td><td>"+contactDetails.getLastName()+"</td></tr> " +
                 " <tr><td>Address</td><td>"+contactDetails.getAddress()+"</td></tr> " +
                 " <tr><td>Mobile Phone</td><td>"+contactDetails.getMobilePhone()+"</td></tr> " +
                 " <tr><td>Mail</td><td>"+contactDetails.getMail()+"</td></tr> " +
                 " <tr><td>Birthday</td><td>"+contactDetails.getBirthday()+"</td></tr></table>");
   %>
  <h2></h2>

  <% out.println(" <table class=\"w3-table w3-striped w3-bordered w3-border\"> " +
                        " <thead class=\"w3-teal\"><th style=\"width:50%\"><a href=\"/operationsHistory\">Operations history</a></th><th></th></thead> " +
                        "</table>");
   %>
 </div>
</div>


<div class="w3-container w3-grey  w3-left-align w3-padding">
   <form method="get" action = "/signIn">
   </form>

   <form method="get" action = "/logout">
        <button type=submit class="w3-btn w3-right w3-border w3-border-white w3-round-large" >Logout</button>
   </form>
</div>

</body>
</html>
