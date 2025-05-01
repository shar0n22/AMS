// Modified toggleDropdown function for navbars
function toggleDropdown(id) {
  const dropdown = document.getElementById(id);

  // Get all dropdowns
  const dropdowns = document.querySelectorAll(".dropdown-content");

  // Close all dropdowns except the clicked one
  dropdowns.forEach((drop) => {
    if (drop.id !== id) {
      drop.style.display = "none";
    }
  });

  // Toggle the clicked dropdown
  dropdown.style.display = dropdown.style.display === "flex" ? "none" : "flex";
}

// Function to navigate between different views
function navigateTo(view) {
  // Hide all containers first
  document.getElementById("search-container").style.display = "none";
  document.getElementById("profile-view-container").style.display = "none";
  document.getElementById("profile-edit-container").style.display = "none";
  document.getElementById("upcoming-trips-container").style.display = "none";
  document.getElementById("cancelled-trips-container").style.display = "none";
  document.getElementById("completed-trips-container").style.display = "none";

  // Then show the appropriate container
  switch (view) {
    case "home":
      document.getElementById("search-container").style.display = "block";
      break;
    case "viewProfile":
      document.getElementById("profile-view-container").style.display = "block";
      break;
    case "editProfile":
      document.getElementById("profile-edit-container").style.display = "block";
      break;
    case "upcomingTrips":
      document.getElementById("upcoming-trips-container").style.display =
        "block";
      break;
    case "cancelledTrips":
      document.getElementById("cancelled-trips-container").style.display =
        "block";
      break;
    case "completedTrips":
      document.getElementById("completed-trips-container").style.display =
        "block";
      break;
  }
}

// Initialize event listeners for navbar
document.addEventListener("DOMContentLoaded", function () {
  // Menu dropdown functionality
  document
    .getElementById("profile-btn")
    .addEventListener("click", function (e) {
      e.preventDefault(); // Prevent default link behavior
      e.stopPropagation(); // Prevent event from bubbling up
      toggleDropdown("profileDropdown");
    });

  document.getElementById("trips-btn").addEventListener("click", function (e) {
    e.preventDefault(); // Prevent default link behavior
    e.stopPropagation(); // Prevent event from bubbling up
    toggleDropdown("tripsDropdown");
  });

  // Close dropdowns when clicking outside
  window.addEventListener("click", function () {
    document.querySelectorAll(".dropdown-content").forEach((drop) => {
      drop.style.display = "none";
    });
  });

  // Set up additional event listeners for profile view/edit navigation
  document
    .getElementById("edit-from-view")
    .addEventListener("click", function () {
      navigateTo("editProfile");
    });

  document
    .getElementById("back-to-home-from-view")
    .addEventListener("click", function () {
      navigateTo("home");
    });

  document.getElementById("cancel-edit").addEventListener("click", function () {
    navigateTo("viewProfile");
  });

  // Set up navigation for My Trips links
  document
    .getElementById("upcoming-trips-link")
    .addEventListener("click", function (e) {
      e.preventDefault();
      navigateTo("upcomingTrips");
    });

  document
    .getElementById("cancelled-trips-link")
    .addEventListener("click", function (e) {
      e.preventDefault();
      navigateTo("cancelledTrips");
    });

  document
    .getElementById("completed-trips-link")
    .addEventListener("click", function (e) {
      e.preventDefault();
      navigateTo("completedTrips");
    });

  // Back to home buttons for trips views
  document.querySelectorAll(".back-to-home-btn").forEach((button) => {
    button.addEventListener("click", function () {
      navigateTo("home");
    });
  });

  // Home link in navbar
  document.getElementById("home-link").addEventListener("click", function (e) {
    e.preventDefault();
    navigateTo("home");
  });

  // View profile link
  document
    .getElementById("view-profile-link")
    .addEventListener("click", function (e) {
      e.preventDefault();
      navigateTo("viewProfile");
    });

  // Edit profile link
  document
    .getElementById("edit-profile-link")
    .addEventListener("click", function (e) {
      e.preventDefault();
      navigateTo("editProfile");
    });

  // Start with home view
  navigateTo("home");
});

// // Modified toggleDropdown function for navbars
// function toggleDropdown(id) {
//   const dropdown = document.getElementById(id);

//   // Get all dropdowns
//   const dropdowns = document.querySelectorAll(".dropdown-content");

//   // Close all dropdowns except the clicked one
//   dropdowns.forEach((drop) => {
//     if (drop.id !== id) {
//       drop.style.display = "none";
//     }
//   });

//   // Toggle the clicked dropdown
//   dropdown.style.display = dropdown.style.display === "flex" ? "none" : "flex";
// }

// // Function to navigate between different views
// function navigateTo(view) {
//   // Hide all containers first
//   document.getElementById("search-container").style.display = "none";
//   document.getElementById("profile-view-container").style.display = "none";
//   document.getElementById("profile-edit-container").style.display = "none";
//   document.getElementById("upcoming-trips-container").style.display = "none";
//   document.getElementById("cancelled-trips-container").style.display = "none";
//   document.getElementById("completed-trips-container").style.display = "none";

//   // Then show the appropriate container
//   switch (view) {
//     case "home":
//       document.getElementById("search-container").style.display = "block";
//       break;
//     case "viewProfile":
//       document.getElementById("profile-view-container").style.display = "block";
//       break;
//     case "editProfile":
//       document.getElementById("profile-edit-container").style.display = "block";
//       break;
//     case "upcomingTrips":
//       document.getElementById("upcoming-trips-container").style.display =
//         "block";
//       break;
//     case "cancelledTrips":
//       document.getElementById("cancelled-trips-container").style.display =
//         "block";
//       break;
//     case "completedTrips":
//       document.getElementById("completed-trips-container").style.display =
//         "block";
//       break;
//   }
// }

// // Initialize event listeners for navbar
// document.addEventListener("DOMContentLoaded", function () {
//   // Menu dropdown functionality
//   document
//     .getElementById("profile-btn")
//     .addEventListener("click", function (e) {
//       e.preventDefault(); // Prevent default link behavior
//       e.stopPropagation(); // Prevent event from bubbling up
//       toggleDropdown("profileDropdown");
//     });

//   document.getElementById("trips-btn").addEventListener("click", function (e) {
//     e.preventDefault(); // Prevent default link behavior
//     e.stopPropagation(); // Prevent event from bubbling up
//     toggleDropdown("tripsDropdown");
//   });

//   // Close dropdowns when clicking outside
//   window.addEventListener("click", function () {
//     document.querySelectorAll(".dropdown-content").forEach((drop) => {
//       drop.style.display = "none";
//     });
//   });

//   // Set up additional event listeners for profile view/edit navigation
//   document
//     .getElementById("edit-from-view")
//     .addEventListener("click", function () {
//       navigateTo("editProfile");
//     });

//   document
//     .getElementById("back-to-home-from-view")
//     .addEventListener("click", function () {
//       navigateTo("home");
//     });

//   document.getElementById("cancel-edit").addEventListener("click", function () {
//     navigateTo("viewProfile");
//   });

//   // Set up navigation for My Trips links
//   document
//     .getElementById("upcoming-trips-link")
//     .addEventListener("click", function (e) {
//       e.preventDefault();
//       navigateTo("upcomingTrips");
//     });

//   document
//     .getElementById("cancelled-trips-link")
//     .addEventListener("click", function (e) {
//       e.preventDefault();
//       navigateTo("cancelledTrips");
//     });

//   document
//     .getElementById("completed-trips-link")
//     .addEventListener("click", function (e) {
//       e.preventDefault();
//       navigateTo("completedTrips");
//     });

//   // Back to home buttons for trips views
//   document.querySelectorAll(".back-to-home-btn").forEach((button) => {
//     button.addEventListener("click", function () {
//       navigateTo("home");
//     });
//   });

//   // Home link in navbar
//   document.getElementById("home-link").addEventListener("click", function (e) {
//     e.preventDefault();
//     navigateTo("home");
//   });

//   // View profile link
//   document
//     .getElementById("view-profile-link")
//     .addEventListener("click", function (e) {
//       e.preventDefault();
//       navigateTo("viewProfile");
//     });

//   // Edit profile link
//   document
//     .getElementById("edit-profile-link")
//     .addEventListener("click", function (e) {
//       e.preventDefault();
//       navigateTo("editProfile");
//     });

//   // Start with home view
//   navigateTo("home");
// });

// // Modified toggleDropdown function for navbars
// function toggleDropdown(id) {
//   const dropdown = document.getElementById(id);

//   // Get all dropdowns
//   const dropdowns = document.querySelectorAll(".dropdown-content");

//   // Close all dropdowns except the clicked one
//   dropdowns.forEach((drop) => {
//     if (drop.id !== id) {
//       drop.style.display = "none";
//     }
//   });

//   // Toggle the clicked dropdown
//   dropdown.style.display = dropdown.style.display === "flex" ? "none" : "flex";
// }

// // Initialize event listeners for navbar
// document.addEventListener("DOMContentLoaded", function () {
//   // Menu dropdown functionality
//   document
//     .getElementById("profile-btn")
//     .addEventListener("click", function (e) {
//       e.preventDefault(); // Prevent default link behavior
//       e.stopPropagation(); // Prevent event from bubbling up
//       toggleDropdown("profileDropdown");
//     });

//   document.getElementById("trips-btn").addEventListener("click", function (e) {
//     e.preventDefault(); // Prevent default link behavior
//     e.stopPropagation(); // Prevent event from bubbling up
//     toggleDropdown("tripsDropdown");
//   });

//   // Close dropdowns when clicking outside
//   window.addEventListener("click", function () {
//     document.querySelectorAll(".dropdown-content").forEach((drop) => {
//       drop.style.display = "none";
//     });
//   });

//   // Set up additional event listeners for profile view/edit navigation
//   document
//     .getElementById("edit-from-view")
//     .addEventListener("click", function () {
//       navigateTo("editProfile");
//     });

//   document
//     .getElementById("back-to-home-from-view")
//     .addEventListener("click", function () {
//       navigateTo("home");
//     });

//   document.getElementById("cancel-edit").addEventListener("click", function () {
//     navigateTo("viewProfile");
//   });
// });
