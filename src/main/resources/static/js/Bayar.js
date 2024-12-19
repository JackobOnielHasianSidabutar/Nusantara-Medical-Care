// Fungsi untuk menampilkan popup
function showPopup() {
    const popup = document.querySelector('.popup-check');
    let body = document.querySelector('body');
    popup.removeAttribute('hidden'); 
}

// let updatebutton = document.querySelector(".update-button");
function hidePopup() {
    const popup = document.querySelector('.popup-check');
    popup.setAttribute('hidden', 'true'); 
}

function showingPopup(popupId, norekammedispasien=null) {
    document.getElementById(popupId).classList.remove('hidden');
    document.getElementById(popupId).removeAttribute('hidden');
    if(document.getElementById('norekammedispasien')&& norekammedispasien!=null){
        document.getElementById('norekammedispasien').value=norekammedispasien;
    }
    // Tutup semua popup terlebih dahulu
    // document.querySelectorAll('.popup').forEach(popup => popup.style.display = 'none');
    // Tampilkan popup yang dipilih berdasarkan ID
    // document.getElementById(popupId).style.display = 'flex';
}

function hidingPopup(popupId) {
    document.getElementById(popupId).classList.add('hidden');
}
document.addEventListener("DOMContentLoaded", function () {
    const addPasienButton = document.querySelector(".addPasien");
    if (addPasienButton) {
        addPasienButton.addEventListener("click", function () {
            window.location.href = "/administrator/pendaftaran";
        });
    }
});
document.querySelectorAll('.action-btn-rekammedis').forEach(function (btn){
    btn.addEventListener('click', function(event) {
        console.log(event.target.getAttribute('data-norekammedispasien'));

        document.getElementById('norekammedispasien').value = event.target.getAttribute('data-norekammedispasien');
        document.getElementById('tanggalperiksa').value = event.target.getAttribute('data-tglpendaftaran');

        document.getElementById('popup-informasi-dasar').classList.remove('hidden');
        document.getElementById('popup-informasi-dasar').removeAttribute('hidden');
    });
});