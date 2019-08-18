<%@ page import="project.model.CreditAccount" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title>Credit Page</title>
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

<div class="w3-row-padding w3-padding-64 w3-container">
   <div class="w3-third">

   <% CreditAccount creditAccount = (CreditAccount) request.getAttribute("creditAccount");

    out.println("<h2>Deposit Account</h2>");


out.println (" <table class=\"w3-table w3-striped w3-bordered w3-border\"> " +
             " <thead class=\"w3-teal\"> " +
             " <th style=\"width:50%\"> " + "Account Information" +
             " </th><th></th></thead> " +
             " <tr><td>Balance</td><td>"+creditAccount.getBalance()+"</td></tr> " +
             " <tr><td>Currency</td><td>"+creditAccount.getCurrency()+"</td></tr> " +
             " <tr><td>Limit</td><td>"+creditAccount.getLimit()+"</td></tr> " +
             " <tr><td>Rate</td><td>"+creditAccount.getRate()+" % per annum</td></tr> " +
             " <tr><td>Accrued interest</td><td>"+creditAccount.getAccrued_interest()+" %"+"</td></tr></table>");
            %>

  <h2></h2>

  <% out.println(" <table class=\"w3-table w3-striped w3-bordered w3-border\"> " +
                   " <thead class=\"w3-teal\"><th style=\"width:50%\">Operations history</th><th></th></thead> " +
                   " <tr><td>TBD</td><td>TBD</td></tr></table>");
   %>
 </div>


</div>
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
