function togglePopup(popupId, show) {
    const popup = document.getElementById(popupId);
    if (show) {
        popup.classList.remove('hidden');
        popup.removeAttribute('hidden');
    } else {
        popup.classList.add('hidden');
        popup.setAttribute('hidden', 'true');
    }
}

document.addEventListener("DOMContentLoaded", () => {
    // Tambahkan event listener ke tombol Edit
    const actionButtons = document.querySelectorAll(".action-btn");
    actionButtons.forEach((btn) => {
        btn.addEventListener("click", (e) => {
            const doctorId = e.target.getAttribute("data-id");
            document.getElementById("iddokter").value = doctorId;
            togglePopup("popupJadwal", true);
        });
    });

    // Event listener untuk tombol Kembali
    document.querySelector(".close-btn").addEventListener("click", () => {
        togglePopup("popupJadwal", false); 
    });
});