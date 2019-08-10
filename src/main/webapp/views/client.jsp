<%@ page import="project.model.entities.User" %>
<%@ page import="project.model.entities.UserAccount" %>
<%@ page import="project.model.entities.ContactDetails" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title>Client Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>


<div class="w3-top">
    <div class="w3-bar w3-blue-gray w3-card w3-left-align w3-medium">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">UA</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">EN</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">RU</a>
        <a href="/open_deposit" class="w3-bar-item w3-button w3-border w3-light-grey">Deposit Account</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey">Credit Account</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey">My Operations</a>
    </div>
</div>

<div class="w3-row-padding w3-padding-64 w3-container">
   <div class="w3-third">
   <img src="/avatar.png" style="width:30%">

   <% UserAccount userAccount = (UserAccount) request.getSession().getAttribute("userAccount");
      ContactDetails contactDetails = (ContactDetails) request.getSession().getAttribute("contactDetails");
   %>

    <h2><%out.println(contactDetails.getName()+ " Main Account");%></h2>


<%out.println (" <table class=\"w3-table w3-striped w3-bordered w3-border\"> " +
             " <thead class=\"w3-teal\"> " +
             " <th style=\"width:50%\"> " + "Account Information" +
             " </th><th></th></thead> " +
             " <tr><td>Balance</td><td>"+userAccount.getBalance()+"</td></tr> " +
             " <tr><td>Currency</td><td>"+userAccount.getCurrency()+"</td></tr> " +
             " <tr><td>Validity</td><td>"+userAccount.getValidity()+"</td></tr></table>");
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
                   " <thead class=\"w3-teal\"><th style=\"width:50%\">Operations history</th><th></th></thead> " +
                   " <tr><td>TBD</td><td>TBD</td></tr></table>");
   %>
 </div>


</div>
   <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
   <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main menu</button>
</div>

</body>
</html>
