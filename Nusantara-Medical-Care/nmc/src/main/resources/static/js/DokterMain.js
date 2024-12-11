// Fungsi untuk menampilkan popup
function showPopup() {
    const popup = document.querySelector('.popup-check');
    let body = document.querySelector('body');
    popup.removeAttribute('hidden'); 
    //body.style.background = "rgba(0, 0, 0, 0.5)";

}

let updatebutton = document.querySelector(".update-button");
function hidePopup() {
    const popup = document.querySelector('.popup-check');
    popup.setAttribute('hidden', 'true'); 
}

let backbutton = document.querySelector(".back-button");
backbutton.addEventListener("click", hidePopup);
updatebutton.addEventListener("click", hidePopup);