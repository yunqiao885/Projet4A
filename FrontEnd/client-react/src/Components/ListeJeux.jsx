import React from 'react';
import '../styles/ListeJeux.css'
import { jeuList } from '../data/jeuList'
import Jeu from './Jeu'

function ListeJeux({panier, setPanier}) {
    
    function ajouterPanier(id, nom, prix) {
        const jeuAjouter = panier.find(jeu => jeu.nom === nom)
        if (jeuAjouter){
            const newPanier = panier.filter(
                jeu => jeu.nom !==nom
            )
            setPanier([...newPanier, {nom, prix, qte: jeuAjouter.qte +1} ])
        } else{
            setPanier([...panier, {id, nom, prix, qte:1}])
        }
    }

    return (
        <div>
            <ul className="liste">
                {jeuList.map((jeu) => (
                <li className="liste-jeu" key={jeu.id}>
                    <Jeu value={jeu}/>
                    <button onClick={() => ajouterPanier(jeu.id, jeu.name, jeu.prix)
                    }>Ajouter</button>
                </li>
                ))}
            </ul>
        </div>
    )
}



export default ListeJeux