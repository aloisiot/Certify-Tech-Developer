let rodadas = 0;
let empates = 0;

let vitoriasMaquina = 0;
let vitoriasUser = 0;

function game() {
  let maoUsuario = prompt(
    "Digite (1) para pedra, (2) para papel e (3) para tesoura"
  );
  let maoMaquina = parseInt(Math.random() * 3 + 1);

  if (0 < maoUsuario && maoUsuario < 4) {

    let result =parseInt(maoUsuario) -  maoMaquina;
    
    if (result == 0) {
      alert("Empate");
    } else if (result == -1 || result == 2) {
      alert("Você perdeu");
    } else if (result == 1 || result == -2) {
      alert("Você ganhou");
    }

  } else {
    alert("Opção invalida;");
    game();
  }

  rodadas++;

  if (rodadas < 3) {
    game();
  } else {
    alert(`Vitorias do Usuário: ${vitoriasUser}\nVitórias da Máquina: ${vitoriasMaquina}\nEmpates: ${empates}`);
  }
}

game();