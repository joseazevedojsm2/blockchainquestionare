import React, { useState } from "react";
import { useParams } from "react-router-dom";
import { useEffect } from "react";
import Card from "./componentes/Card";

const Questions = () => {
  const params = useParams(null);
  const [questions, setQuestions] = useState(null);

  async function fetchQuestions() {
    const response = await fetch("http://localhost:8080/questions/all");

    const data = await response.json();
    setQuestions(data);
  }

  return (
    <div>
      <button onClick={fetchQuestions}> Fill Questionare </button>
      <p>.</p>
      {questions !== null && <Card questions={questions}></Card>}
    </div>
  );
};
export default Questions;
