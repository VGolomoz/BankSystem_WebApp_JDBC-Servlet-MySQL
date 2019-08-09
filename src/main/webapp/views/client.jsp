<!DOCTYPE html>
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
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey">Deposit Account</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey">Credit Account</a>
        <a href="#" class="w3-bar-item w3-button w3-border w3-light-grey">My Operations</a>
    </div>

</div>

<div class="w3-row-padding w3-padding-64 w3-container">
   <div class="w3-third">
   <img src="/avatar.png" style="width:30%">

  <h2></h2>
  <table class="w3-table w3-striped w3-bordered w3-border">
  <thead class="w3-teal"><th style="width:40%">Account Information</th><th></th></thead>
  <tr><td>Balance</td><td>TBD</td></tr>
  <tr><td>Currency</td><td>TBD</td></tr>
  <tr><td>Validity</td><td>TBD</td></tr>
  <tr><td>Deposit</td><td>TBD</td></tr>
  <tr><td>Credit</td><td>TBD</td></tr>
  </table>

  <h2></h2>
  <table class="w3-table w3-striped w3-bordered w3-border">
  <thead class="w3-teal"><th style="width:40%">Contact Details</th><th></th></thead>
  <tr><td>Name</td><td>TBD</td></tr>
  <tr><td>Last Name</td><td>TBD</td></tr>
  <tr><td>Address</td><td>TBD</td></tr>
  <tr><td>Mobile Phone</td><td>TBD</td></tr>
  <tr><td>Mail</td><td>TBD</td></tr>
  <tr><td>Birthday</td><td>TBD</td></tr>
  </table>

  <h2></h2>
  <table class="w3-table w3-striped w3-bordered w3-border">
  <thead class="w3-teal"><th style="width:30%">Operation history</th><th></th></thead>
  <tr><td>TBD</td><td>TBD</td></tr>
   </table>
</div>

<script>
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
}

function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}
</script>

</div>
   <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
   <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main menu</button>
</div>


</body>
</html>
