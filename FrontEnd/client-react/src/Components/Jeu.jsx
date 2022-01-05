import React from 'react';
import '../styles/Jeu.css'

function Jeu(props) {
    const jeu = props.value
    return (
        <div>
            <b> {jeu.nom} </b> <br/>
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



export default Jeu;