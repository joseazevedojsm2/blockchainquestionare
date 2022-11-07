import logo from './logo.svg';
import './App.css';
import questions from './questions';
import "./global.css"; 

function App() {
  return ( 
  <main className ="app">
    <div className="lado-izquierdo"></div>
    <div className="pregunta-numero">
      <span>Pregunta 1 de</span>10
    </div>
    <div className="pregunta-titulo">
     Question1:
    </div>
    <div  className="lado-derecho"> 
     <button>Option 1</button>
     <button>Option 2</button>
     <button>Option 3</button>
     <button>Option 4</button>
    </div>
  </main>
    
  );
}

export default App;
