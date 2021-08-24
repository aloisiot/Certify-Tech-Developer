

function injectForm(){
    const body = document.querySelector('body');
    
    const form = document.createElement('form');
    body.appendChild(form);
    
    const h1 = document.createElement('h1');
    form.appendChild(h1);
    h1.innerHTML='Login';
    
    const inputEmail = document.createElement('input');
    inputEmail.setAttribute('placeholder', 'email');
    form.appendChild(inputEmail);
    
    const inputPassword = document.createElement('input');
    inputPassword.setAttribute('placeholder', 'senha');
    form.appendChild(inputPassword);
    
    const submitButton = document.createElement('button');
    submitButton.innerHTML= 'Enviar';
    submitButton.setAttribute('type','submit');
    form.appendChild(submitButton);
    
    const resetButton = document.createElement('button');
    resetButton.innerHTML= 'Calcelar'; 
    resetButton.setAttribute('type','submit');
    form.appendChild(resetButton);
}

window.addEventListener("load", injectForm);