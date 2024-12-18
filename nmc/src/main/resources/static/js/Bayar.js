function showPopup(action) {
    const popup = document.getElementById("popupBayar");
    popup.style.display = "flex";
}

function hidePopup() {
    const popup = document.getElementById("popupBayar");
    popup.style.display = "none";
}
document.addEventListener("DOMContentLoaded", function () {
    const addPasienButton = document.querySelector(".addPasien");
    if (addPasienButton) {
        addPasienButton.addEventListener("click", function () {
            window.location.href = "/administrator/pendaftaran";
        });
    }
});