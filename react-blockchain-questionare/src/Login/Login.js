import React, { useState } from "react";
import "./Login.css";
const Login = () => {
  const [userEmail, setUserEmail] = useState("");

  const userEmailChangeHandler = (event) => {
    console.log(event.target.value);
    setUserEmail(event.target.value);
  };

  async function fetchOrCreateUserHandler() {
    var url = "http://localhost:8080/questions/" + userEmail;
    var response = await fetch(url);
    var data = await response.json();

    if(data.id!==null)
         return;

    url = "http://localhost:8080/questions/" + userEmail;
    response = await fetch(url,{
        method: "POST"
    });

    data = await response.json();
    console.log(data);
  }

  function submitHandler(event) {
    event.preventDefault();
    fetchOrCreateUserHandler();
  }

  return (
    <div class="container">
      <div class="screen">
        <div class="screen__content">
          <form class="login" onSubmit={submitHandler} >
            <div class="login__field">
              <i class="login__icon fas fa-user"></i>
              <input
                type="text"
                class="login__input"
                placeholder="User Email"
                onChange={userEmailChangeHandler}
              />
            </div>
            <button class="button login__submit" >
              <span class="button__text">Go to Questionare</span>
              <i class="button__icon fas fa-chevron-right"></i>
            </button>
          </form>
        </div>
        <div class="screen__background">
          <span class="screen__background__shape screen__background__shape4"></span>
          <span class="screen__background__shape screen__background__shape3"></span>
          <span class="screen__background__shape screen__background__shape2"></span>
          <span class="screen__background__shape screen__background__shape1"></span>
        </div>
      </div>
    </div>
  );
};
export default Login;
