import React from "react";
import { useNavigate } from "react-router-dom";

export default function JeuInfo({jeu}){
    let navigate = useNavigate()

    function choix(categorie){
        switch (categorie) {
            case 'Jeu de tir':
                return <span>🔫</span>
            case 'Jeu de simulation':
                return <span>🧍‍♂️</span>
            case 'Jeu de course':
                return <span>🚗</span>
            case 'Jeu de chasse':
                return <span>🏞</span>
            case 'Jeu de combat':
                return <span>⚔️</span>
            case 'Jeu de strategie':
                return <span>🏙</span>
            default:
                return <span></span>
        }
    }

    return (
        <div>
            Nom : {jeu.nom}<br/>
            Description : {jeu.description} {choix(jeu.description)}<br/>
            Prix : {jeu.prix}€<br/>
            Fabricant : {jeu.nom_fabricant}<br/>
            Date de sortie : {jeu.date_publication}<br/>
            <button onClick={() => navigate("/user/boutique/")
                }>Fermer</button>
        </div>
    )
}