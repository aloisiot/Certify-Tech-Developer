import pavao from './pavao.png';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={pavao} className="App-logo" alt="logo" />
        <h1>
          Enfeitei o pavão!!
        </h1>
        <a
          className="App-link"
          href="https://github.com/aloisiot"
          target="_blank"
          rel="noopener noreferrer"
        >
          aloisiot
        </a>
      </header>
    </div>
  );
}

export default App;
