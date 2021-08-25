window.onload = alert('Bem vindo');

const body = document.querySelector('body');

const form = document.createElement('form');
body.appendChild(form);

const h1 = document.createElement('h1');
form.appendChild(h1);
h1.innerHTML='Login';

const inputEmail = document.createElement('input');
inputEmail.setAttribute('placeholder', 'email');
inputEmail.type='email';
form.appendChild(inputEmail);

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

// Elimina o comportamento padrão do botão reset depois de clicado a primeira vez.
resetButton.addEventListener('click', function(event){
    event.preventDefault();
});

// Altera a cor do titulo quando o mouse é posicionado sobre dele
h1.addEventListener('mouseenter',()=>{
    h1.style.color='red';
})

// Altera a cor do titulo quando o mouse é retirado de cima dele
h1.addEventListener('mouseout',()=>{
    h1.style.color='white';
})

/* Para cada caracter inserido no input senha
   insere um paragrafo ao final do form */
let count = 0
inputPassword.addEventListener('keydown', function(event){
    count++;
    let result = `Ultima tecla precionada: ${event.key}, repetições: ${count}`
    p = document.createElement('p');
    p.innerHTML=result;
    form.appendChild(p);
})