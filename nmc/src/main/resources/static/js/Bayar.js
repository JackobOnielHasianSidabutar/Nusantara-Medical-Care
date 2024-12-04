function showPopup(popupId) {
    document.querySelectorAll('.popup').forEach(popup => popup.style.display = 'none');
    document.getElementById(popupId).style.display = 'flex';
}

function hidePopup() {
    document.querySelectorAll('.popup').forEach(popup => popup.style.display = 'none');
}
