import React, { useState } from "react";
import {  useParams } from "react-router-dom";
import { useEffect } from "react";

const Questions = () => {
    const params = useParams();
    const [questions,setQuestions] = useState([]);

    useEffect(()=>{
        async function fetchQuestions() {
            const response = await fetch("http://localhost:8080/questions/all");
      
            const data = await response.json();
            setQuestions(data);
            console.log(data);
          }
          fetchQuestions();
        }, []);

    return(
        <div>Hello {params.email} </div>
    );
}
export default Questions;