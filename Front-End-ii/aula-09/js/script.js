const body = document.querySelector('body');

const form = document.createElement('form');
body.appendChild(form);

const h1 = document.createElement('h1');
form.appendChild(h1);
h1.innerHTML='Login';

const inputEmail = document.createElement('input');
inputEmail.setAttribute('placeholder', 'email');
inputEmail.type='email';

const countainerImputEmail = document.createElement("div");
countainerImputEmail.appendChild(inputEmail);
form.appendChild(countainerImputEmail);

const inputPassword = document.createElement('input');
inputPassword.setAttribute('placeholder', 'senha');
inputPassword.type='password';
inputPassword.id = 'pass'
form.appendChild(inputPassword);

const submitButton = document.createElement('button');
submitButton.innerHTML= 'Enviar';
submitButton.type='submit';
form.appendChild(submitButton);

const resetButton = document.createElement('button');
resetButton.innerHTML= 'Cancelar'; 
resetButton.id='reset-button';
resetButton.type='reset';
form.appendChild(resetButton);


inputEmail.addEventListener('mouseout',()=>{
    if(inputEmail.value!=''){
        inputEmail.disabled = true;
    }
})

inputPassword.addEventListener('mouseout',()=>{
    if(inputPassword.value!=''){
        inputPassword.disabled = true;
    }
})

countainerImputEmail.addEventListener('mouseenter',()=>{
    inputPassword.disabled=false;
})

countainerImputEmail.addEventListener('mouseenter',()=>{
        inputEmail.disabled=false;
})

submitButton.addEventListener('click',(event)=>{
    
    event.preventDefault();
    
    const p0 = document.querySelector('#is-empity-alert');

    let p = document.createElement('p');
    p.id='alert-is-empity'
    p.innerHTML= 'Preencha os campos para continuar'
    p.style.color='red';

    try{
        form.removeChild(p0);
    } catch {
        console.log('Ainda nao possui o paragrafo');
    }

    if(inputEmail.value == '' || inputPassword.value == ''){
        form.appendChild(p);
    }

})