import { Component } from 'react';
import './App.scss';

export default class App extends Component {
  constructor(){
    super();
    this.state = {
      valor: 1,
      mostraNome: false,
      listaAluno: [
        {id: 1 ,nome: "Joao", sobrenome: "Silva"},
        {id: 2 ,nome: "Marcia", sobrenome: "Santos"},
        {id: 3 ,nome: "Lara", sobrenome: "Sena"},
        {id: 4 ,nome: "Larissa", sobrenome: "Santana"}
      ]
    }
  }

  render(){
    const incrementaUm = () =>{
      this.setState({
        valor: this.state.valor + 1
      });
    }

    const mostraNome = () => {
      this.setState({
        mostraNome: !this.state.mostraNome
      });
    }

    const removeAluno = (idAluno) => {
      const lista = this.state.listaAluno.filter(({id}) => {
        return id !== idAluno;
      })
      this.setState({
        listaAluno: lista
      })
    }

    return(
      <>
        <div className="d-flex flex-wrap flex-column justify-content-center align-items-center py-3 my-4">
          <h2>{this.state.valor}</h2>
          <button className="btn btn-primary" onClick={incrementaUm}>SOMAR UM</button>
        </div>
        
        <div className="d-flex flex-wrap flex-column justify-content-center align-items-center py-3 my-4">
          {this.state.mostraNome && (<h2>Nome legal</h2>)}
          <button className="btn btn-primary" onClick={mostraNome}>MOSTRAR NOME</button>
        </div>
        
        <div className="d-flex flex-wrap flex-column justify-content-center align-items-center py-3 my-4">
          {this.state.listaAluno.map(({id, nome, sobrenome}) => {
            return(
              <div key={id} onClick={ () => removeAluno(id) }>
                <h3>{`${nome} ${sobrenome}`}</h3>
              </div>
            );
          })}
        </div>
      </>
    );
  }
}