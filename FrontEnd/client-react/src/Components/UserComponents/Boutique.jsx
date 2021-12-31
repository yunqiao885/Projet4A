import React, { useEffect } from "react";
import { useState } from "react/cjs/react.development";
import ListeJeux from '../ListeJeux';
import Panier from './Panier';

export default function Boutique({panier, setPanier}) {
    
    const [total, setTotal] = useState(0)
    const [jeuxPanier, setJeuxPanier] = useState([])

    useEffect(() => {
        async function getPanier() {
            try {
                const response = await fetch("http://localhost:8080/paniers/"+sessionStorage.getItem('id'))
                const data = await response.json();
                setPanier(data)
                setJeuxPanier(data.jeux)
                setTotal(data.prix_total)
            } catch (error) {
                console.log(error);
            }
        }
        getPanier()
    },[])

    useEffect(() => {
        async function updatePanier() {
            try {
                const response = await fetch("http://localhost:8080/paniers/"+sessionStorage.getItem('id'), {
                    method: "PUT",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(
                        {  
                            jeux : jeuxPanier,
                            payement : panier.payement
                        }),
                    })
                const data = await response.json();
                setPanier(data)
                setTotal(data.prix_total)
            } catch (error) {
                console.log(error);
            }
        }
        updatePanier()
    },[jeuxPanier])

    return (
        <div>
            <Panier total={total} jeuxPanier={jeuxPanier} setJeuxPanier={setJeuxPanier} />
            <ListeJeux jeuxPanier={jeuxPanier} setJeuxPanier={setJeuxPanier}  /> 
        </div>
    )
}