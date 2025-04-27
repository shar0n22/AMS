// // Corrected toggle function
// function toggleDropdown(content) {
//   const dropdownSpace = document.getElementById("dropdown-space");

//   if (dropdownSpace.innerHTML.trim() !== "") {
//     // If already opened, close it
//     dropdownSpace.innerHTML = "";
//     dropdownSpace.style.backgroundColor = "white";
//   } else {
//     // Otherwise, show the dropdown
//     dropdownSpace.innerHTML = content;
//     dropdownSpace.style.backgroundColor = "teal";
//   }
// }

// // Dropdown content HTML
// const profileDropdownHTML = `
//   <div class="dropdown-content">
//     <a href="#">View Profile</a>
//     <a href="#">Edit Profile</a>
//   </div>
// `;

// const tripsDropdownHTML = `
//   <div class="dropdown-content">
//     <a href="#">Upcoming Trips</a>
//     <a href="#">Cancelled Trips</a>
//     <a href="#">Completed Trips</a>
//   </div>
// `;

// // Attach events
// document.getElementById("profile-btn").addEventListener("click", (e) => {
//   e.stopPropagation(); // Prevent closing immediately
//   toggleDropdown(profileDropdownHTML);
// });

// document.getElementById("trips-btn").addEventListener("click", (e) => {
//   e.stopPropagation();
//   toggleDropdown(tripsDropdownHTML);
// });

// // Close dropdown when clicking outside
// window.addEventListener("click", function () {
//   const dropdownSpace = document.getElementById("dropdown-space");
//   dropdownSpace.innerHTML = "";
//   dropdownSpace.style.backgroundColor = "white";
// });

// document.getElementById("profile-btn").addEventListener("click", function (e) {
//   e.stopPropagation();
//   toggleDropdown("profileDropdown");
// });

// document.getElementById("trips-btn").addEventListener("click", function (e) {
//   e.stopPropagation();
//   toggleDropdown("tripsDropdown");
// });

// function toggleDropdown(id) {
//   const dropdowns = document.querySelectorAll(".dropdown-content");
//   dropdowns.forEach((drop) => {
//     if (drop.id === id) {
//       drop.style.display = drop.style.display === "flex" ? "none" : "flex";
//     } else {
//       drop.style.display = "none";
//     }
//   });
// }

// function toggleDropdown(id) {
//   const dropdown = document.getElementById(id);
//   const dropdownSpace = document.getElementById("dropdown-space");

//   // If the dropdown is already visible, hide it
//   if (dropdown.style.display === "flex") {
//     dropdown.style.display = "none";
//     return;
//   }

//   // Hide all dropdowns
//   document.querySelectorAll(".dropdown-content").forEach((drop) => {
//     drop.style.display = "none";
//   });

//   // Position the dropdown inside the dropdown-space
//   dropdown.style.display = "flex";

//   // Calculate position
//   const spaceRect = dropdownSpace.getBoundingClientRect();

//   // Position the dropdown at the top of dropdown-space
//   dropdown.style.top = spaceRect.top + "px";
// }

// Modified toggleDropdown function
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

document.getElementById("profile-btn").addEventListener("click", function (e) {
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

// Close dropdowns if clicking outside
window.addEventListener("click", function () {
  document.querySelectorAll(".dropdown-content").forEach((drop) => {
    drop.style.display = "none";
  });
});
