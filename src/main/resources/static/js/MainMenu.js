document.addEventListener("DOMContentLoaded", function () {
    const signIn = document.querySelector('.button');
    const klinikButtons = document.querySelectorAll('.klinik-container button'); // Pilih tombol klinik-container

    // Fungsi untuk mengubah warna latar belakang tombol Sign In
    function changeBackgroundWhite() {
        signIn.style.backgroundColor = 'white';
    }
    function changeBackgroundBlue() {
        signIn.style.backgroundColor = 'lightblue';
    }

    // Fungsi untuk berpindah halaman ke halaman login
    function pindahHalaman() {
        window.location.href = "PelangganSignIn.html";
    }

    // Event Listener untuk tombol Sign In
    if (signIn) { // Cek apakah tombol Sign In ada
        signIn.addEventListener('mouseover', changeBackgroundWhite);
        signIn.addEventListener('mouseout', changeBackgroundBlue);
        signIn.addEventListener('click', pindahHalaman);
    }

    // Fungsi untuk menangani klik pada tombol klinik-container
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
