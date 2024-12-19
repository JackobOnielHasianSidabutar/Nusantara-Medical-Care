document.addEventListener("DOMContentLoaded", function () {
    const klinikButtons = document.querySelectorAll('.klinik-container button'); // Pilih tombol klinik-container
    // Ambil ID Klinik dari localStorage
    const idKlinik = localStorage.getItem("idKlinik");
    if (idKlinik) {
        console.log(`Klinik ID Terpilih: ${idKlinik}`);
        // Logika lain seperti memuat dokter berdasarkan idKlinik
    }

    // Tombol "Home" untuk kembali ke halaman utama
    const homeButton = document.querySelector(".home");
    if (homeButton) {
        homeButton.addEventListener("click", function () {
            window.location.href = "/pasien/main"; // Redirect ke /main
        });
    }

    // Tombol "Lihat Jadwal" pada setiap dokter
    const doctorButtons = document.querySelectorAll(".doctor-card button");
    if (doctorButtons.length > 0) {
        doctorButtons.forEach((button, index) => {
            button.addEventListener("click", function () {
                const idDokter = index + 1; // ID dokter dimulai dari 1
                localStorage.setItem("idDokter", idDokter);
                window.location.href = "jadwaldokter"; // Redirect ke /jadwaldokter
            });
        });
    }
    function pilihKlinik(event) {
        const button = event.target;
        let idKlinik = 0;

        // Tentukan idKlinik berdasarkan tombol yang diklik
        if (button.classList.contains('penyakit-dalam')) idKlinik = 1;
        else if (button.classList.contains('tht')) idKlinik = 2;
        else if (button.classList.contains('gigi')) idKlinik = 3;
        else if (button.classList.contains('mata')) idKlinik = 4;
        else if (button.classList.contains('paru-paru')) idKlinik = 5;

        if (idKlinik > 0) {
            // Simpan idKlinik di localStorage dan pindahkan ke KlinikPage.html
            localStorage.setItem("idKlinik", idKlinik);
            window.location.href = "/pasien/klinikPage";
        }
    }

    // Event Listener untuk tombol dalam klinik-container
    if (klinikButtons.length > 0) { // Pastikan elemen tombol ada
        klinikButtons.forEach(button => button.addEventListener('click', pilihKlinik));
    }
});
