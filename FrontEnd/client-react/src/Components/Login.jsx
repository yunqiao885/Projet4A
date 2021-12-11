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
        sessionStorage.setItem('username', username);
        navigate("/user");
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