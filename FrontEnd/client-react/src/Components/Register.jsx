import React from 'react';
import {useState} from "react"
import { useNavigate } from 'react-router-dom';

function Register ({setId, setIsLogedIn}){
    let navigate = useNavigate()
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [confPassword, setConfPassword] = useState("");

    const [email, setEmail] = useState("");
    const [nom, setNom] = useState("");
    const [prenom, setPrenom] = useState("");
    const [tel, setTel] = useState("");

    const [cp, setCp] = useState("");
    const [ville, setVille] = useState("");

    return (
        <div className="register">
            <label htmlFor="username">Username : </label>
            <input type="text" id="username" name="username" value={username} onChange={(e) => handleChange(e, setUsername)} /> <br/>
            <label htmlFor="password">Mot de passe : </label>
            <input type="password" id="password" name="password" value={password} onChange={(e) => handleChange(e, setPassword)} /> <br/>
            <label htmlFor="confPassword">Confirmer le Mot de passe : </label>
            <input type="password" id="confPassword" name="confPassword" value={confPassword} onChange={(e) => handleChange(e, setConfPassword)} /> <br/>
            <label htmlFor="email">Email :</label>
            <input type="email" id="email" name="email" value={email} onChange={(e) => handleChange(e, setEmail)} /> <br/>
            <label htmlFor="nom">Nom : </label>
            <input type="text" id="nom" name="nom" value={nom} onChange={(e) => handleChange(e, setNom)} /> <br/>
            <label htmlFor="prenom">Prenom : </label>
            <input type="text" id="prenom" name="prenom" value={prenom} onChange={(e) => handleChange(e, setPrenom)} /> <br/>
            <label htmlFor="tel">Numero : </label>
            <input type="text" id="tel" name="tel" value={tel} onChange={(e) => handleChange(e, setTel)} /> <br/>
            <label htmlFor="cp">Code postale : </label>
            <input type="text" id="cp" name="cp" value={cp} onChange={(e) => handleChange(e, setCp)} /> <br/>
            <label htmlFor="ville">Ville : </label>
            <input type="text" id="ville" name="ville" value={ville} onChange={(e) => handleChange(e, setVille)} /> <br/>

            <button onClick={registerClicked}>Register</button>
        </div>
    )

    function handleChange(e, func){
        func(e.target.value)
    }
    
    function registerClicked(){

        try {
            fetch("http://localhost:8080/create-customer-id", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(
                    {  
                        username: username,
                        nom: nom,
                        prenom: prenom,
                        email: email,
                        password: password,
                        numero: tel,
                        codePostal: cp,
                        ville: ville
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
        
        navigate("/user");
        setIsLogedIn(true);
    }

}



export default Register