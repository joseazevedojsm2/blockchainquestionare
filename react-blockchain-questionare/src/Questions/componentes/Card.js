import opciones from "./opciones";
import "./global.css";
import { useState, useEffect } from "react";

const Card = (props) => {
  var i = 0;
  console.log();
  const [preguntaActual, setPreguntaActual] = useState(
    props.questions[0].question
  );
  const [puntuacion, setPuntuacion] = useState(0);
  const [isFinished, setIsFiniched] = useState(false);
  const [count, setCount] = useState(0);

  function handleAnswerSubmit(e) {
    if (props.questions[count] === props.questions.length - 1) {
      setIsFiniched(true);
    } else {
      setCount(count + 1);
      console.log(props.questions[count + 1]);
      setPreguntaActual(props.questions[count + 1].question);
    }
  }

  return (
    <main className="app">
      <div className="lado-izquierdo">
        <div className="pregunta-numero">
          <span>Pregunta {count + 1}/ </span> {props.questions.length}
        </div>
        <div className="pregunta-titulo">{props.questions[count].question}</div>
      </div>
      <div className="lado-derecho">
        {opciones.map((respuesta) =>
          respuesta.opciones.map((quest) => (
            <button
              key={quest.textoRespuesta}
              onClick={(e) => handleAnswerSubmit(e)}
            >
              {console.log(quest)} {quest.textoRespuesta}{" "}
            </button>
          ))
        )}
      </div>
    </main>
  );
  // return(<div></div>);
};

export default Card;
