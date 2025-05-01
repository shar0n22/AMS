// Global variables to track current view
let currentView = "home"; // possible values: "home", "viewProfile", "editProfile"

// Function to handle navigation
function navigateTo(view) {
  // Hide all content sections
  document.getElementById("search-container").style.display = "none";
  document.getElementById("profile-view-container").style.display = "none";
  document.getElementById("profile-edit-container").style.display = "none";

  // Update current view and show appropriate section
  currentView = view;

  if (view === "home") {
    document.getElementById("search-container").style.display = "block";
  } else if (view === "viewProfile") {
    document.getElementById("profile-view-container").style.display = "block";
    loadUserProfile();
  } else if (view === "editProfile") {
    document.getElementById("profile-edit-container").style.display = "block";
    loadUserProfileForEdit();
  }

  // Close any open dropdowns
  document.querySelectorAll(".dropdown-content").forEach((drop) => {
    drop.style.display = "none";
  });
}

// Function to load user profile data
function loadUserProfile() {
  const currentUserId = localStorage.getItem("currentUserId");
  const users = JSON.parse(localStorage.getItem("users")) || [];
  const currentUser = users.find((user) => user.userId === currentUserId);

  if (currentUser) {
    document.getElementById("view-userId").textContent = currentUser.userId;
    document.getElementById("view-firstName").textContent =
      currentUser.firstName;
    document.getElementById("view-lastName").textContent = currentUser.lastName;
    document.getElementById("view-email").textContent = currentUser.email;
    document.getElementById("view-dob").textContent = formatDate(
      currentUser.dob
    );
    document.getElementById("view-address").textContent = currentUser.address;
    document.getElementById("view-contact").textContent = currentUser.contact;
  } else {
    alert("User profile not found!");
  }
}

// Function to load user profile data for editing
function loadUserProfileForEdit() {
  const currentUserId = localStorage.getItem("currentUserId");
  const users = JSON.parse(localStorage.getItem("users")) || [];
  const currentUser = users.find((user) => user.userId === currentUserId);

  if (currentUser) {
    document.getElementById("edit-firstName").value = currentUser.firstName;
    document.getElementById("edit-lastName").value = currentUser.lastName;
    document.getElementById("edit-email").value = currentUser.email;
    document.getElementById("edit-dob").value = currentUser.dob;
    document.getElementById("edit-address").value = currentUser.address;
    document.getElementById("edit-contact").value = currentUser.contact;
  } else {
    alert("User profile not found!");
  }
}

// Function to save edited profile
function saveUserProfile(event) {
  event.preventDefault();

  const currentUserId = localStorage.getItem("currentUserId");
  const users = JSON.parse(localStorage.getItem("users")) || [];
  const userIndex = users.findIndex((user) => user.userId === currentUserId);

  if (userIndex !== -1) {
    // Validate inputs
    const firstName = document.getElementById("edit-firstName").value.trim();
    const lastName = document.getElementById("edit-lastName").value.trim();
    const email = document.getElementById("edit-email").value.trim();
    const dob = document.getElementById("edit-dob").value;
    const address = document.getElementById("edit-address").value.trim();
    const contact = document.getElementById("edit-contact").value.trim();

    // Perform validation
    const errorDiv = document.getElementById("edit-error");
    errorDiv.textContent = "";

    if (!firstName || !lastName || !email || !dob || !address || !contact) {
      errorDiv.textContent = "All fields are mandatory.";
      return;
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
      errorDiv.textContent = "Enter a valid mail id";
      return;
    }

    const phoneRegex = /^\d{10}$/;
    if (!phoneRegex.test(contact)) {
      errorDiv.textContent = "Enter a valid contact number";
      return;
    }

    // Update user data
    users[userIndex].firstName = firstName;
    users[userIndex].lastName = lastName;
    users[userIndex].email = email;
    users[userIndex].dob = dob;
    users[userIndex].address = address;
    users[userIndex].contact = contact;

    // Save to localStorage
    localStorage.setItem("users", JSON.stringify(users));

    // Update welcome message
    document.querySelector(
      ".nav-right"
    ).textContent = `Welcome ${firstName} !!!`;

    // Show success message
    errorDiv.textContent = "Profile updated successfully!";
    errorDiv.style.color = "green";

    // Navigate to view profile after short delay
    setTimeout(() => {
      navigateTo("viewProfile");
    }, 1500);
  }
}

// Helper function to format date
function formatDate(dateString) {
  const date = new Date(dateString);
  return date.toLocaleDateString("en-US", {
    year: "numeric",
    month: "long",
    day: "numeric",
  });
}

// Event listeners for navigation
document.addEventListener("DOMContentLoaded", function () {
  // Set up event listeners
  document.getElementById("home-link").addEventListener("click", function (e) {
    e.preventDefault();
    navigateTo("home");
  });

  document
    .getElementById("view-profile-link")
    .addEventListener("click", function (e) {
      e.preventDefault();
      navigateTo("viewProfile");
    });

  document
    .getElementById("edit-profile-link")
    .addEventListener("click", function (e) {
      e.preventDefault();
      navigateTo("editProfile");
    });

  // Edit profile form submission
  document
    .getElementById("profile-edit-form")
    .addEventListener("submit", saveUserProfile);

  // Initialize to home view
  navigateTo("home");

  // Load user info for welcome message
  const users = JSON.parse(localStorage.getItem("users")) || [];
  const currentUserId = localStorage.getItem("currentUserId");
  const currentUser = users.find((user) => user.userId === currentUserId);

  if (currentUser) {
    document.querySelector(
      ".nav-right"
    ).textContent = `Welcome ${currentUser.firstName} !!!`;
  }
});
