import React, { useState } from 'react';
import "../../styles/Panier.css"
import { useNavigate } from 'react-router-dom';


export default function Panier({total, jeuxPanier, setJeuxPanier}){
    let navigate = useNavigate();
    const [isOpen, setIsOpen] = useState(false)
        

    return isOpen ? (
        <div className="panier">
            <button onClick={() => setIsOpen(false)}>Fermer</button>
            <h2>Panier</h2>
            <div>
                {jeuxPanier.map(({id, nom, prix, qte }) => ( //mettre toutes les donnees du jeu
                    <div key={id}>{nom} : {prix}€ x {qte}</div>
                    ))}
            </div>
            <h3>Total : {total}</h3>
            <button onClick={() => setJeuxPanier([])}>Vider le panier</button>
            {total >0 && <button onClick={() => navigate("/user/paiement/process")}>Payer</button>}
            
        </div>
    ) : (
        <button onClick={() => setIsOpen(true)}>Ouvrir le Panier</button>
    )
}