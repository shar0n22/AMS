function validateLogin(event) {
    event.preventDefault();
    const userId = document.getElementById("userId").value.trim();
    const password = document.getElementById("password").value.trim();
    const errorDiv = document.getElementById("error-message");
    errorDiv.textContent = "";

    const users = {
      "12345": "pass123",
      "67890": "securepwd",
      "11223": "admin321"
    };

    // Step 1: Format validation
    let isIdValidFormat = /^\d{1,5}$/.test(userId);
    let isPasswordValidFormat = password.length >= 6 && password.length <= 30;

    if (!isIdValidFormat && !isPasswordValidFormat) {
      errorDiv.textContent = "Both ID/password not valid";
      return;
    } else if (!isIdValidFormat) {
      errorDiv.textContent = "ID not valid";
      return;
    } else if (!isPasswordValidFormat) {
      errorDiv.textContent = "Password not valid";
      return;
    }

    // Step 2: Credential match check
    const isIdInUsers = users.hasOwnProperty(userId);
    const doesPasswordMatch = users[userId] === password;

    if (!isIdInUsers && !Object.values(users).includes(password)) {
      errorDiv.textContent = "Both ID/password not valid";
    } else if (!isIdInUsers) {
      errorDiv.textContent = "ID not valid";
    } else if (!doesPasswordMatch) {
      errorDiv.textContent = "Password not valid";
    } else {
      // ✅ Success
      window.location.href = "home.html";
    }
  }
