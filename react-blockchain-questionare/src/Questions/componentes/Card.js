import opciones from "./opciones";
import "./global.css";
import { useState, useEffect } from "react";
import { Link, useParams,useLocation } from "react-router-dom";


const Card = (props) => {
  var i = 0;
  console.log();
  const [preguntaActual, setPreguntaActual] = useState(
    props.questions[0].question
  );
  const [puntuacion, setPuntuacion] = useState(0);
  const [isFinished, setIsFiniched] = useState(false);
  const [count, setCount] = useState(0);
  const [total,setTotal] = useState(0);

  function handleAnswerSubmit(e,points) {
    if (count === props.questions.length-1) {
      console.log(count);
      setIsFiniched(true);
      setTotal(total+points);
      answerQuestionByUserHandler(points);
    } else if(count < props.questions.length-1) {    
      setCount(count + 1);
      setTotal(total+points);
      answerQuestionByUserHandler(points);
      setPreguntaActual(props.questions[count + 1].question);
    }
    
  }

  async function answerQuestionByUserHandler(points) {
    var url = "http://localhost:8080/questions/"+props.email+"/answers";

    const bodyAnswer = {
      points:points,
      question:{
        question:props.questions[count].question
      }
    }

    var response = await fetch(url, {
      method: "POST",
      body: JSON.stringify(bodyAnswer),
      headers: {
        "Content-Type": "application/json",
      },
    });

    var data = await response.json();
    console.log(data);
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
              onClick={(e) => handleAnswerSubmit(e,quest.points)}
            >
              {console.log(quest)} {quest.textoRespuesta}{" "}
            </button>
          ))
        )}
      </div>
      {isFinished===true && 
          <Link to={`/${props.email}/results`} state={ total } >
            <button >See results</button>
          </Link>
        }
    </main>
  );
  // return(<div></div>);
};

export default Card;
