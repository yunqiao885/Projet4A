import React, { useEffect, useState } from 'react';
import '../styles/ListeJeux.css'
import { jeuList } from '../data/jeuList'
import Jeu from './Jeu'

function ListeJeux({panier, setPanier}) {

    const [listeJeux, setListeJeux] = useState([])

    useEffect(() => {
        async function getListeJeu() {
            try {
                const response = await fetch("http://localhost:8080/jeux")
                const data = await response.json();
                setListeJeux(data);
            } catch (error) {
                console.log(error);
            }
        }
        getListeJeu()
    }, [])
    
    function ajouterPanier(id, nom, prix) {
        const jeuAjouter = panier.find(jeu => jeu.nom === nom)
        if (jeuAjouter){
            const newPanier = panier.filter(
                jeu => jeu.nom !==nom
            )
            setPanier([...newPanier, {id, nom, prix, qte: jeuAjouter.qte +1} ])
        } else{
            setPanier([...panier, {id, nom, prix, qte:1}])
        }
    }

    return (
        <div>
            <ul className="liste">
                {listeJeux.map((jeu) => (
                <li className="liste-jeu" key={jeu.id}>
                    <Jeu value={jeu}/>
                    <button onClick={() => ajouterPanier(jeu.id, jeu.nom, jeu.prix)
                    }>Ajouter</button>
                </li>
                ))}
            </ul>
        </div>
    )
}



export default ListeJeux