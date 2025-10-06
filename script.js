function bankOperation() {
  let op = document.getElementById("operation").value;
  let amount = parseInt(document.getElementById("amount").value);
  let accountBalance = document.getElementById("account-balance");
  let cashBalance = document.getElementById("cash-balance");

  let accVal = parseInt(accountBalance.value);
  let cashVal = parseInt(cashBalance.value);

  if (isNaN(amount) || amount <= 0) {
    alert("Please enter valid amount");
    return;
  }

  if (op === "deposit") {
    accVal += amount;
    cashVal -= amount;
  } else if (op === "withdraw") {
    if (accVal < amount) {
      alert("Not enough money in account!");
      return;
    }
    accVal -= amount;
    cashVal += amount;
  }

  accountBalance.value = accVal;
  cashBalance.value = cashVal;

  document.getElementById("status-box").value =
    "Current account balance: " + accVal +
    ", Current cash balance: " + cashVal;
}

function convertCurrency() {
  let input = parseFloat(document.getElementById("input-balance").value);
  let currency = document.getElementById("currency").value;
  let outputBox = document.getElementById("output-balance");

  
}
