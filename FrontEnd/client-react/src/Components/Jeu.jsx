import React from 'react';
import '../styles/Jeu.css'

function Jeu(props) {
    const jeu = props.value
    return (
        <div>
            <b> {jeu.name} </b> <br/>
             {jeu.category} {choix(jeu.category)} <br/>
            Avis : {avis(jeu.avis)}
        </div>
    )
}

function avis(max){
    var star =""
    for (let i = 0; i < max; i++) {
        star += "⭐️"
    }
    return star;
}

function choix(categorie){
    switch (categorie) {
        case 'tir':
            return <span>🔫</span>
        case 'simulation':
            return <span>🧍‍♂️</span>
        case 'course':
            return <span>🚗</span>
        case 'aventure':
            return <span>🏞</span>
        case 'combat':
            return <span>⚔️</span>
        case 'gestion':
            return <span>🏙</span>
        default:
            return <span></span>
    }
}

export default Jeu;