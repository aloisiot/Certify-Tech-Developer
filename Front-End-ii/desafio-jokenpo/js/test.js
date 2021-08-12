let rodadas=0;
let empates=0;

let vitoriasMaquina=0;
let vitoriasUser=0;

function game(){

    let maoUsuario = prompt(
        "Digite (1) para pedra, (2) para papel e (3) para tesoura"
      );
      
    let maoMaquina = parseInt(Math.random() * 3 + 1);
    

if (maoUsuario == maoMaquina) {
    empates++;
    alert("Empate");
  } else if (maoUsuario == 1) {
    // Pedra
    switch (maoMaquina) {
      case 2:
        alert("Perdeu");
        vitoriasMaquina++;
        break;
  
      case 3:
        alert("Ganhou");
        vitoriasUser++;
    }
  } else if (maoUsuario == 2) {
    // Papel
    switch (maoMaquina) {
      case 3:
        alert("perdeu!");
        vitoriasMaquina++;
        break;
  
      case 1:
        alert("Ganhou!");
        vitoriasUser++;
    }
  } else if (maoUsuario == 3) {
    // Tesoura
    switch (maoMaquina) {
      case 1:
        alert("Perdeu");
        vitoriasMaquina++;
        break;
  
      case 2:
        alert("Ganhou");
        rvitoriasUser++;
        break;
    }
  } else{
      alert("Opção invalida;")
  }

  rodadas++;

  console.log(rodadas);
  if(rodadas < 3){
    game();
  }
  else{
    alert(`Vitorias do Usuário: ${vitoriasUser}\nVitórias da Máquina: ${vitoriasMaquina}\nEmpates: ${empates}`)
  }
  
}
game();
