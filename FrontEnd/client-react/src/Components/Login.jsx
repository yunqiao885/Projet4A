import React from 'react';
import {useState} from "react"
import { useNavigate } from 'react-router-dom';

function Login ({setId, setIsLogedIn}){
    let navigate = useNavigate();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    function handleChange(e, func){
        func(e.target.value);
    }


    function loginClicked(){
        try {
            fetch("http://localhost:8080/get-customer-id", {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(
                        {  
                            username: username,
                            password: password,
                        }),
                    })
                .then(response => response.text())
                .then(data => {
                    sessionStorage.setItem('id', data)
                    setId(data)
                    console.log(data)
                    })
                .then(sessionStorage.setItem('username', username))
        } catch (error) {
            console.log(error);
        }
        setIsLogedIn(true);
        navigate("/user")
        
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