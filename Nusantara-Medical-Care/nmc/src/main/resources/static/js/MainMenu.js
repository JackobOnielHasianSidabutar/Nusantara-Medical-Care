const signIn = document.querySelector('.button');

function changeBackgroundWhite(){
    signIn.style.backgroundColor = 'white';
}
function changeBackgroundBlue(){
    signIn.style.backgroundColor = 'lightblue';
}

function pindahHalaman() {
    window.location.href = "PelangganSignIn.html";
}

signIn.addEventListener('mouseover', changeBackgroundWhite);
signIn.addEventListener('mouseout', changeBackgroundBlue);

signIn.addEventListener('click', pindahHalaman);