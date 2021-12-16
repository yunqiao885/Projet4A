import React from 'react';
import '../styles/Jeu.css'

function Jeu(props) {
    const jeu = props.value
    return (
        <div>
            <b> {jeu.nom} </b> <br/>
             {jeu.description} {choix(jeu.description)} <br/>
            Avis : {avis(jeu.id)}
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

export default Jeu;