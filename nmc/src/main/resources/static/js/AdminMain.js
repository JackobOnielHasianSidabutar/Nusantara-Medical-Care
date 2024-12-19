function showPopup(popupId) {
    // Tutup semua popup terlebih dahulu
    document.querySelectorAll('.popup').forEach(popup => popup.style.display = 'none');
    // Tampilkan popup yang dipilih berdasarkan ID
    document.getElementById(popupId).style.display = 'flex';
}

function hidePopup() {
    // Tutup semua popup
    document.querySelectorAll('.popup').forEach(popup => popup.style.display = 'none');
}

// Tambahkan event listener untuk tombol "Tambah Pasien Baru"
document.addEventListener("DOMContentLoaded", function () {
    document.querySelector('.addPasien').addEventListener('click', function () {
        showPopup('popupPasienStep1'); // Tampilkan popup langkah 1
    });
});
