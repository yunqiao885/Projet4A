import React from 'react';
import { useState } from "react"
import "../styles/Panier.css"

export default function Panier(props){
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
                {panier.map(({nom, prix, qte, id}) => (
                    <div key={id}>{nom} : {prix}€ x {qte}</div>
                    ))}
            </div>
            <h3>Total : {total}</h3>
            <button onClick={() => setPanier([])}>Vider le panier</button>
        </div>
    ) : (
        <button onClick={() => setIsOpen(true)}>Ouvrir le Panier</button>
    )
}