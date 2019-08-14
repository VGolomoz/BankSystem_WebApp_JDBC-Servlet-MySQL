<%@ page import="project.model.entities.UserAccount" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title>Deposit offers</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/w3.css">
<body>


<div class="w3-top">
    <div class="w3-bar w3-blue-gray w3-card w3-left-align w3-medium">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">UA</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">EN</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey w3-right">RU</a>
        <a href="/open_deposit" class="w3-bar-item w3-button w3-border w3-light-grey">Deposit Account</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey">Credit Account</a>
        <a href="/operations" class="w3-bar-item w3-button w3-border w3-light-grey">My Operations</a>
    </div>
</div>
<br>
<br>
<br>
<br>

<div class="w3-container w3-padding">
                <%
                    if (request.getAttribute("opResult") != null) {
                        out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                                                                "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                                                                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                                                                "   <h5>'" + request.getAttribute("opResult") + "'</h5>\n" +
                                                                "</div>" );
                    }
                %>

      <div class="w3-display-container">
<button onclick="myFunction('OpBillPayment')" class="w3-button w3-block w3-light-green w3-center-align">
Bill Payment</button>

<div id="OpBillPayment" class="w3-hide w3-border">
  <ul class="w3-ul">
    <form method="post" action= "/operations">
    <input type="hidden" name = "operationId" value= "OpBillPayment">
    <br>
        <label>Enter bill number:
            <input type="text"  name="billNumber" class="w3-input w3-border w3-round-large" style="width: 30%">
        </label>
        <label>Enter purpose of payment:
            <input type="text"  name="purpose" class="w3-input w3-border w3-round-large" style="width: 30%" >
        </label>
        <label>Enter amount of payment:
            <input type="text"  name="amount" class="w3-input w3-border w3-round-large" style="width: 30%" >
        </label>
        <br>
               <button type="submit" class="w3-button w3-green w3-padding-large ">Submit</button>
    </form>
  </ul>
</div>

<br>
<br>

<button onclick="myFunction('OpTransfer')" class="w3-button w3-block w3-light-green w3-center-align">
Transfer</button>
<div id="OpTransfer" class="w3-hide w3-border">
  <ul class="w3-ul">
    <form method="post">
     <input type="hidden" name = "operationId" value= "OpTransfer">
    <br>
        <label>Enter recipient's mail:
            <input type="text"  name="recipientMail" class="w3-input w3-border w3-round-large" style="width: 30%" >
        </label>
        <label>Enter amount of transfer:
            <input type="text"  name="amount" class="w3-input w3-border w3-round-large" style="width: 30%" >
        </label>
        <br>
               <button type="submit" class="w3-button w3-green w3-padding-large ">Submit</button>
    </form>
  </ul>
</div>

<br>
<br>

<button onclick="myFunction('OpReplenishmentMainAcc')" class="w3-button w3-block w3-light-green w3-center-align">
Replenishment Main Account Balance</button>
<div id="OpReplenishmentMainAcc" class="w3-hide w3-border">
  <ul class="w3-ul">
    <form method="post">
     <input type="hidden" name = "operationId" value= "OpReplenishmentMainAcc">
    <br>
        <label>Enter amount of replenishment:
            <input type="text"  name="amount" class="w3-input w3-border w3-round-large" style="width: 30%" >
        </label>
        <br>
               <button type="submit" class="w3-button w3-green w3-padding-large ">Submit</button>
    </form>
  </ul>
</div>

<% UserAccount userAccount = (UserAccount) request.getSession().getAttribute("userAccount");
%>
     <br>
     <br>
     <button onclick="myFunction('OpReplenishmentDeposit')" class="w3-button w3-block w3-light-green w3-center-align">
     Replenishment Deposit Balance</button>
     <div id="OpReplenishmentDeposit" class="w3-hide w3-border">
       <ul class="w3-ul">
       <% if (userAccount.getDeposit()) {
       out.println (
         "<form method=\"post\">" +
         "<input type=\"hidden\" name = \"operationId\" value= \"OpReplenishmentDeposit\">" +
         "<br>" +
         "<label>Enter amount of replenishment:" +
         "<input type=\"text\"  name=\"amount\" class=\"w3-input w3-border w3-round-large\" style=\"width: 30%\" >" +
         "</label>" +
         "<br>" +
         "<button type=\"submit\" class=\"w3-button w3-green w3-padding-large \">Submit</button>"+
         "</form>");
         } else {
         out.println ("<p>You do not have deposit account yet. You can create it by select at the top bar 'Deposit Account' menu</p>");}
         %>
       </ul>
     </div>

        <br>
        <br>
        <button onclick="myFunction('OpReplenishmentCredit')" class="w3-button w3-block w3-light-green w3-center-align">
        Replenishment Credit Balance</button>
        <div id="OpReplenishmentCredit" class="w3-hide w3-border">
          <ul class="w3-ul">
          <% if (userAccount.getCredit()) {
          out.println (
            "<form method=\"post\">" +
            "<input type=\"hidden\" name = \"operationId\" value= \"OpReplenishmentCredit\">" +
            "<br>" +
            "<label>Enter amount of replenishment:" +
            "<input type=\"text\"  name=\"amount\" class=\"w3-input w3-border w3-round-large\" style=\"width: 30%\" >" +
            "</label>" +
            "<br>" +
            "<button type=\"submit\" class=\"w3-button w3-green w3-padding-large \">Submit</button>"+
            "</form>");
            } else {
            out.println ("<p>You do not have credit account yet. You can create it by select at the top bar 'Credit Account' menu</p>");}
            %>
          </ul>
</div>
</div>

<br>
<br>
<br>


<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
<button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main menu</button>
</div>
</body>
</html>

<script>
function myFunction(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else {
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>
