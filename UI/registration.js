document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("registrationForm");
  const resetBtn = document.getElementById("resetBtn");
  const dobInput = document.getElementById("dob");
  const emailInput = document.getElementById("email");
  const contactInput = document.getElementById("contact");
  const errorDiv = document.getElementById("error");
  const acknowledgment = document.getElementById("acknowledgment");
  const buttonArea = document.getElementById("buttonArea");

  function showError(message) {
    errorDiv.textContent = message;
    errorDiv.style.color = "red";
    errorDiv.style.display = "block";
  }

  function clearError() {
    errorDiv.textContent = "";
    errorDiv.style.display = "none";
  }

  form.addEventListener("submit", function (e) {
    e.preventDefault();
    clearError();

    const dob = new Date(dobInput.value);
    const minDate = new Date("1924-01-01");

    const email = emailInput.value.trim();
    const contact = contactInput.value.trim();

    const inputs = form.querySelectorAll("input, textarea");
    for (let input of inputs) {
      if (input.value.trim() === "") {
        showError("All fields are mandatory.");
        return;
      }
    }

    if (dob <= minDate || isNaN(dob)) {
      showError("Choose a date greater than 1/1/1924");
      return;
    }

    const phoneRegex = /^\d{10}$/;
    if (!phoneRegex.test(contact)) {
      showError("Enter a valid contact number");
      return;
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
      showError("Enter a valid mail id");
      return;
    }

    form.style.display = "none";
    // const acknowledgment = document.getElementById("acknowledgment");
    const firstName = document.getElementById("firstName").value.trim();

    const passengerId = Math.floor(10000 + Math.random() * 90000);
    const password = firstName.substring(0, 4) + "@123";

    acknowledgment.innerHTML = `
        <strong style="color: green;">Passenger Registration is successful.</strong><br><br>
        <strong>Passenger ID:</strong> ${passengerId}<br>
        <strong>Password:</strong> ${password}
      `;
    acknowledgment.style.display = "block";

    // Save Passenger ID and Password to localStorage
    let users = JSON.parse(localStorage.getItem("users")) || [];

    users.push({
      userId: passengerId.toString(), // Passenger ID (as string)
      password: password, // Generated password
    });

    localStorage.setItem("users", JSON.stringify(users));

    // Create a "Go to Login" button dynamically
    const loginButton = document.createElement("button");
    loginButton.textContent = "Go to Login";
    loginButton.style.marginTop = "20px";
    loginButton.style.padding = "10px 20px";
    loginButton.style.backgroundColor = "dodgerblue";
    loginButton.style.color = "white";
    loginButton.style.border = "none";
    loginButton.style.borderRadius = "5px";
    loginButton.style.cursor = "pointer";

    // Append the button to the acknowledgment div
    // document.getElementById("acknowledgment").appendChild(loginButton); // replace acknowledgmentDivId with your div's id

    buttonArea.appendChild(loginButton);

    // Add event to redirect on button click
    loginButton.addEventListener("click", function () {
      window.location.href = "login.html";
    });

    loginButton.addEventListener("mouseover", function () {
      loginButton.style.backgroundColor = "cobalt";
    });
    loginButton.addEventListener("mouseout", function () {
      loginButton.style.backgroundColor = "dodgerblue";
    });
  });

  resetBtn.addEventListener("click", function (e) {
    e.preventDefault();
    const confirmReset = confirm("Is it Okay to reset the fields?");
    if (confirmReset) {
      form.reset();
      clearError();
    }
  });
});
