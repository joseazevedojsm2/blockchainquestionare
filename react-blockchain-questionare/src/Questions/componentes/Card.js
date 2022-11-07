import opciones from "./opciones";
import "./global.css";
import { useState, useEffect } from "react";

const Card = (props) => {
  var i=0;
  console.log();
  const [preguntaActual, setPreguntaActual] = useState(
    props.questions[0].question  );
   const [puntuacion, setPuntuacion]=useState(0);
   const [isFinished, setIsFiniched]=useState(false);

  function handleAnswerSubmit(e) {
    if(props.questions[i] === props.questions.length -1){
      setIsFiniched(true);
    } else {
    setPreguntaActual(props.questions[i++] );
    }
  }

  return (
    <main className="app">
      <div className="lado-izquierdo">
        <div className="pregunta-numero">
          <span>Pregunta {i+1}/ </span> {props.questions.length}
        </div>
        <div className="pregunta-titulo">
          {props.questions[i].question}
        </div>
      </div>
      <div className="lado-derecho">
        {opciones.map((respuesta) => (
          <button
            key={respuesta.textoRespuesta}
            onClick={(e) => handleAnswerSubmit(e)}
          >
            {" "}
            {respuesta.textoRespuesta}{" "}
          </button>
        ))}
      </div>
    </main>
  );
  // return(<div></div>);
};

export default Card;
