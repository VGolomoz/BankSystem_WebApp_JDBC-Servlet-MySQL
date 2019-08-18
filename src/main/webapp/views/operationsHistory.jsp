<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="project.model.OpReplenishment"%>
<%@ page import="project.model.OpTransfer"%>
<%@ page import="project.model.OpBillPayment"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title>Deposit offers</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
   <%@include file="/styles/w3.css" %>
</style>
<body>

<% List<OpReplenishment> replenishment = (List<OpReplenishment>) request.getAttribute("ReplMainAccHistory");
List<OpTransfer> transfer = (List<OpTransfer>) request.getAttribute("TransferHistory");
List<OpBillPayment> billPayment = (List<OpBillPayment>) request.getAttribute("BillPaymentHistory");
%>

<div class="w3-container">
<h3>Operations history of replenishment main account</h3>
<table class="w3-table w3-striped">
    <tr class="w3-green">
      <th>Amount</th>
      <th>Operation Date</th>
    </tr>

<% if (!replenishment.isEmpty()){
for (OpReplenishment op : replenishment){
out.println(
    "<tr>" +
      "<td>"+op.getAmount()+"</td>" +
      "<td>"+op.getOperationDate()+"</td>" +
      "</tr>");
    }
  } else  out.println(
          "<tr>" +
               "<td>You have not any replenishment operations yet</td>" +
           "</tr>");
      %>
   </table>
</div>

<br>
<div class="w3-container">
<h3>History of transfer operations</h3>
<table class="w3-table w3-striped">
    <tr class="w3-green">
      <th>Amount</th>
      <th>Recipient mail</th>
      <th>Operation Date</th>
    </tr>

<% if (!transfer.isEmpty()){
for (OpTransfer op : transfer){
out.println(
    "<tr>" +
      "<td>"+op.getAmount()+"</td>" +
      "<td>"+op.getRecipientMail()+"</td>" +
      "<td>"+op.getOperationDate()+"</td>" +
      "</tr>");
    }
    } else  out.println(
        "<tr>" +
             "<td>You have not any transfer operations yet</td>" +
         "</tr>");
    %>
   </table>
</div>

<br>
<div class="w3-container">
<h3>History of bill payment operations</h3>
<table class="w3-table w3-striped">
    <tr class="w3-green">
      <th>Amount</th>
      <th>Bill Number</th>
      <th>Purpose</th>
      <th>Operation Date</th>
    </tr>

<% if (!billPayment.isEmpty()){
for (OpBillPayment op : billPayment){
out.println(
    "<tr>" +
      "<td>"+op.getAmount()+"</td>" +
      "<td>"+op.getBillNumber()+"</td>" +
      "<td>"+op.getPurpose()+"</td>" +
      "<td>"+op.getOperationDate()+"</td>" +
      "</tr>");
    }
    } else  out.println(
    "<tr>" +
         "<td>You have not any bill payment operations yet</td>" +
     "</tr>");
%>
   </table>
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