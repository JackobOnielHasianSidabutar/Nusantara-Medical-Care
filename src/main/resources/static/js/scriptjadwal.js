function showSuccessPopup() {
    const popup = document.getElementById("success-popup");
    popup.style.display = "flex";
}

function hidePopup() {
    const popup = document.getElementById("success-popup");
    popup.style.display = "none";
}

// event listeners untuk tangal 
const scheduleButtons = document.querySelectorAll(".schedule-btn");
const timeButtons = document.querySelectorAll(".time-btn");

scheduleButtons.forEach((button) => {
    button.addEventListener("click", () => {
        // Remove 'selected' class from all buttons
        scheduleButtons.forEach((btn) => btn.classList.remove("selected"));
        // Add 'selected' class to the clicked button
        button.classList.add("selected");
    });
});

// event listeners untuk jam
timeButtons.forEach((button) => {
    button.addEventListener("click", () => {
        // Remove 'selected' class from all buttons
        timeButtons.forEach((btn) => btn.classList.remove("selected"));
        // Add 'selected' class to the clicked button
        button.classList.add("selected");
    });
});
