// Fungsi untuk menampilkan popup
function showPopup() {
    const popup = document.querySelector('.popup-check');
    let body = document.querySelector('body');
    popup.removeAttribute('hidden'); 
    //body.style.background = "rgba(0, 0, 0, 0.5)";

}

// let updatebutton = document.querySelector(".update-button");
function hidePopup() {
    const popup = document.querySelector('.popup-check');
    popup.setAttribute('hidden', 'true'); 
}

// let backbutton = document.querySelector(".back-button");
// backbutton.addEventListener("click", hidePopup);
// updatebutton.addEventListener("click", hidePopup);

function showingPopup(popupId) {
    document.getElementById(popupId).classList.remove('hidden');
    console.log(popupId);
    // Tutup semua popup terlebih dahulu
    // document.querySelectorAll('.popup').forEach(popup => popup.style.display = 'none');
    // Tampilkan popup yang dipilih berdasarkan ID
    // document.getElementById(popupId).style.display = 'flex';
}

// function hidePopup() {
//     // Tutup semua popup
//     document.querySelectorAll('.popup').forEach(popup => popup.style.display = 'none');
// }

function hidingPopup(popupId) {
    document.getElementById(popupId).classList.add('hidden');
    console.log(popupId);
    // Tutup semua popup terlebih dahulu
    // document.querySelectorAll('.popup').forEach(popup => popup.style.display = 'none');
    // Tampilkan popup yang dipilih berdasarkan ID
    // document.getElementById(popupId).style.display = 'flex';
}

// Tambahkan event listener untuk tombol "Tambah Pasien Baru"
// document.addEventListener("DOMContentLoaded", function () {
//     document.querySelector('.addPasien').addEventListener('click', function () {
//         showPopup('popupPasienStep1'); // Tampilkan popup langkah 1
//     });
// });

function showPopup(id) {
    fetch(`/api/pasien/${id}`)
        .then(response => response.json())
        .then(data => {
            if (data) {
                document.getElementById('namaPasien').value = data.namapasien;
                document.getElementById('tanggalLahir').value = data.tgllahirpasien;
                document.getElementById('jenisKelamin').value = data.jeniskelaminpasien;
                document.getElementById('nomorTelepon').value = data.nohppasien;
                document.querySelector('.popup-check').hidden = false;
            } else {
                alert('Pasien tidak ditemukan.');
            }
        })
        .catch(error => console.error('Error fetching pasien:', error));
}

function hidePopup() {
    document.querySelector('.popup-check').hidden = true;
}