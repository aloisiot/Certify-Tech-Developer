console.log("Bem vindo");

const contaBancaia = {
    usuario: "Babu",
    situacao: "ativo",
    valorConta: "1",
}

const minhaPromise = new Promise((resolve, reject) =>{


    setTimeout(()=>{
        if(contaBancaia.valorConta < 1){
            reject({
                mensagem:"Saldo insuficinente",
            })
        } else if(contaBancaia.situacao != "ativo"){
            reject({
                mensagem: "Conta inativa",
            })
        } else{
            resolve({
                mensagem: "Transação realizada com sucesso!",
            })
        }
    }, 2500)


})

const h5 = document.querySelector("h5")

minhaPromise
    .then(res => {
        h5.innerHTML = res.mensagem
        console.log(res)
    })
    .catch(err => {
        h5.innerHTML = err.mensagem
        console.log(err)
    })