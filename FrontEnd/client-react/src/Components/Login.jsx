import React from 'react';
import {useState} from "react"
import { useNavigate } from 'react-router-dom';

function Login ({setIsLogedIn}){
    let navigate = useNavigate();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    function handleChange(e, func){
        func(e.target.value);
    }


    function loginClicked(){
        try {
            fetch("http://localhost:8080/utilisateurs/search/findByUsername?username="+username)
                .then(response => response.json())
                .then(data => sessionStorage.setItem('customerId', data.customerId))
        } catch (error) {
            console.log(error);
        }
        sessionStorage.setItem('username', username);
        navigate("/user/boutique");
        setIsLogedIn(true);
    }

    return (
        <div className="login">
            <label htlmfor="username">Username </label>
            <input type="text" id="username" name="username" value={username} onChange={(e) => handleChange(e, setUsername)} />
            <label htlmfor="password">Password </label>
            <input type="password" id="password" name="password" value={password} onChange={(e) => handleChange(e, setPassword)}/>
            <button onClick={loginClicked}>Login</button>
        </div>
    )

    

}



export default Login