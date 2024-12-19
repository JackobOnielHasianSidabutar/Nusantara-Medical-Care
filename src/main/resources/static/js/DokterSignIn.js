let head = document.querySelector('h1');

function toMain(){
    window.location.href = 'PelangganMain.html'
}

head.style.cursor = 'pointer';
head.addEventListener('click', toMain);

let username = document.querySelector('#username-dokter');
let password = document.querySelector('#password-dokter');
function checkMin8(){

    let usernameValue = username.value;
    let passwordValue = password.value;

    if((usernameValue.length < 8) && (passwordValue.length < 8)){
        alert("Username and Password require at least 8 digits!");
    }else{
        //window.location.href = 'PelangganMain.html';
    }
}

let button = document.querySelector(".log-in-button");

button.addEventListener('click', checkMin8);
