import Title from './components/Title';
import data from './data/convidados';
import Convidado from './components/Convidado';
import Convidados from './components/Convidados';

function App() {
  return (
    <div className="App">
      
      <Title>Convidados para o evento</Title>
      <Convidados>
        {data.map((data, index)=>{
          return <Convidado nome={`${data.nome} ${data.sobrenome}`} />
        })}
      </Convidados>
   
    </div>
  );
}

export default App;
