let head = document.querySelector('h1');

function toMain(){
    window.location.href = 'PelangganMain.html'
}

head.style.cursor = 'pointer';
head.addEventListener('click', toMain);

let noHp = document.querySelector('#noHP');

function checkMin8(){

    let noHpValue = noHp.value;

    if(noHpValue.length < 8){
        alert("Username and Password require at least 8 digits!");
    }else{
        window.location.href = 'PelangganMain.html';
    }
}

let button = document.querySelector(".log-in-button");

button.addEventListener('click', checkMin8);

let register = document.querySelector('.register-click');

function toRegister(){
    window.location.href = 'PelangganRegister.html'
}

register.style.cursor = 'pointer';
register.addEventListener('click', toRegister)

/*
masih bingung untuk apa

function goToMain(){
    if(checkMin8){
        window.location.href = 'PelangganMain.html';
    }
}

button.addEventListener('click', toMain);

*/