<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title>Deposit offers</title>
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
<br>
<br>

<div class="w3-panel w3-pale-green w3-border">
  <p>You do not have deposit account yet</p>
  <h3>We have special offers for you</h3>
 </div>

<div class="w3-row-padding">

<div class="w3-third w3-margin-bottom">
  <ul class="w3-ul w3-border w3-center w3-hover-shadow ">
    <li class="w3-black w3-xlarge w3-padding-32 align-items: center">Basic</li>
    <li class="w3-padding-16"><b>UAH</b> Currency</li>
    <li class="w3-padding-16"><b>10%</b> Rate</li>
    <li class="w3-padding-16"><b>1 year</b> Term</li>
    </li>
    <li class="w3-light-grey w3-padding-24">
       <form method="post">
          <input type="hidden"  name="currency" value="UAH">
          <input type="hidden"  name="rate" value="10">
           <button type="submit" class="w3-button w3-green w3-padding-large">Sign Up</button>
          </form>
    </li>
  </ul>
</div>

<div class="w3-third w3-margin-bottom">
  <ul class="w3-ul w3-border w3-center w3-hover-shadow">
    <li class="w3-blue w3-xlarge w3-padding-32">Basic+</li>
    <li class="w3-padding-16"><b>UAH</b> Currency</li>
        <li class="w3-padding-16"><b>15%</b> Rate</li>
        <li class="w3-padding-16"><b>1 year</b> Term</li>
    </li>
    <li class="w3-light-grey w3-padding-24">
    <form method="post">
    <input type="hidden"  name="currency" value="UAH">
    <input type="hidden"  name="rate" value="15">
     <button type="submit" class="w3-button w3-green w3-padding-large">Sign Up</button>
    </form>
    </li>
  </ul>
</div>

<div class="w3-third w3-margin-bottom">
  <ul class="w3-ul w3-border w3-center w3-hover-shadow">
    <li class="w3-green w3-xlarge w3-padding-32">Super+</li>
    <li class="w3-padding-16"><b>USD</b> Currency</li>
        <li class="w3-padding-16"><b>10%</b> Rate</li>
        <li class="w3-padding-16"><b>1 year</b> Term</li>
    </li>
    <li class="w3-light-grey w3-padding-24">
      <form method="post">
          <input type="hidden"  name="currency" value="USD">
          <input type="hidden"  name="rate" value="10">
           <button type="submit" class="w3-button w3-green w3-padding-large">Sign Up</button>
      </form>
    </li>
  </ul>
</div>
</div>


</div>
   <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
   <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main menu</button>
</div>

</body>
</html>
