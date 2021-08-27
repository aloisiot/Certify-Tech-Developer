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

const countainerImputPassword = document.createElement("div");
countainerImputPassword.appendChild(inputPassword);
form.appendChild(countainerImputPassword);

const submitButton = document.createElement('button');
submitButton.innerHTML= 'Enviar';
submitButton.type='submit';
form.appendChild(submitButton);

const resetButton = document.createElement('button');
resetButton.innerHTML= 'Cancelar'; 
resetButton.id='reset-button';
resetButton.type='reset';
form.appendChild(resetButton);


// Desabilita o input EMAIL com a saida do mouse
inputEmail.addEventListener('mouseout',()=>{
    if(inputEmail.value!=''){
        inputEmail.disabled = true;
    }
})

// Desabilita o input PASSWORD com a saida do mouse
inputPassword.addEventListener('mouseout',()=>{
    if(inputPassword.value!=''){
        inputPassword.disabled = true;
    }
})

// Reabilita o input PASSWORD com a entrada do mouse no elemento pai
countainerImputPassword.addEventListener('mouseenter',()=>{
    inputPassword.disabled=false;
})

// Reabilita o input EMAIL com a entrada do mouse no elemento pai
countainerImputEmail.addEventListener('mouseenter',()=>{
        inputEmail.disabled=false;
})

// Exibe uma mensagem de erro caso algum input esteja vazio durante a submição formulario
submitButton.addEventListener('click',(event)=>{
    
    event.preventDefault();
    
    const p0 = document.querySelector('#is-empity-alert');

    let p = document.createElement('p');
    p.id='is-empity-alert'
    p.innerHTML= 'Preencha os campos para continuar'
    p.style.color='red';
    p.style.fontSize = "0.8rem"

    try{
        form.removeChild(p0);
    } catch {
        console.log('Ainda nao possui o paragrafo');
    }

    if(inputEmail.value == '' || inputPassword.value == ''){
        form.appendChild(p);
    }

})