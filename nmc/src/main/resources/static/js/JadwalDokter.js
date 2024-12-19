document.addEventListener("DOMContentLoaded", function () {
    // Ambil idKlinik dari localStorage
    const idKlinik = localStorage.getItem("idKlinik");
    if (idKlinik) {
        document.getElementById("idKlinikInput").value = idKlinik;
    }

    // Logika untuk tombol "Kembali"
    const backButton = document.querySelector(".btn-back");
    if (backButton) {
        backButton.addEventListener("click", function () {
            window.location.href = "/pasien/klinikPage"; // Kembali ke halaman KlinikPage
        });
    }
});
