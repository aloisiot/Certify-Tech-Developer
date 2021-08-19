const body = document.querySelector('body');

let result = '';

listadeFelinos.forEach((el)=>{
    result += `
    <div>

        <h2>${el.title}</h2>

        <img src='${el.imgUrl}'></img>

        <p>${el.description}</p>

        <q>Criado em: ${el.createdAt}</q>

    </div>
`
})

body.innerHTML+= result;