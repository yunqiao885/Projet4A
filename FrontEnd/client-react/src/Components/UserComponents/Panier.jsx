import React from 'react';
import { useState } from "react"
import "../../styles/Panier.css"
import { useNavigate } from 'react-router-dom';


export default function Panier(props){
    let navigate = useNavigate();
    const panier = props.panier
    const setPanier = props.setPanier
    const [isOpen, setIsOpen] = useState(false)
    const total = panier.reduce(
        (acc, jeu) => acc + jeu.qte*jeu.prix, 0
    )


    return isOpen ? (
        <div className="panier">
            <button onClick={() => setIsOpen(false)}>Fermer</button>
            <h2>Panier</h2>
            <div>
                {panier.map(({id, nom, prix, qte }) => (
                    <div key={id}>{nom} : {prix}€ x {qte}</div>
                    ))}
            </div>
            <h3>Total : {total}</h3>
            <button onClick={() => setPanier([])}>Vider le panier</button>
            <button onClick={() => navigate("/user/paiement")}>Payer</button>
        </div>
    ) : (
        <button onClick={() => setIsOpen(true)}>Ouvrir le Panier</button>
    )
}