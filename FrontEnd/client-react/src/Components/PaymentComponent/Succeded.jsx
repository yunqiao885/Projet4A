import { useEffect, useState } from "react"
import { Navigate } from "react-router-dom"

export default function Succeded(){

    useEffect(() =>{
        fetch("http://localhost:8080/paniers/"+sessionStorage.getItem('id'))
            .then(response => response.json())
            .then(data => {
                fetch("http://localhost:8080/send-mail", {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(
                    { 
                    customerId : sessionStorage.getItem("cusId"),
                    jeux : data.jeux
                    })
                })
            })
            .then(() => {
                fetch("http://localhost:8080/users-panier/"+sessionStorage.getItem('id'), {
                    method: "PUT",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify({})
                })
            })     
    }, [])
    return(
        <Navigate to="/user" />
    )
}