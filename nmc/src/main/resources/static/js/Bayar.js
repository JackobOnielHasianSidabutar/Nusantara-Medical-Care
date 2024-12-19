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

function showingPopup(popupId) {
    document.getElementById(popupId).classList.remove('hidden');
    console.log(popupId);
    document.getElementById(popupId).removeAttribute('hidden')
    // Tutup semua popup terlebih dahulu
    // document.querySelectorAll('.popup').forEach(popup => popup.style.display = 'none');
    // Tampilkan popup yang dipilih berdasarkan ID
    // document.getElementById(popupId).style.display = 'flex';
}

function hidingPopup(popupId) {
    document.getElementById(popupId).classList.add('hidden');
    console.log(popupId);
}