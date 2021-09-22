let porcent = document.querySelector(".porcent");
let loading = document.querySelector(".loading");

let count = 1;
let load = setInterval( _ => {
    if(count >= 100) {
        loading.parentElement.removeChild(loading);
        clearInterval(load);
    } else {
        count ++
        porcent.textContent = `${count}%`
    }
}, 40);