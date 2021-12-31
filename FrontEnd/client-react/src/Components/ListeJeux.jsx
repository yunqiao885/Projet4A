import React, { useEffect, useState } from 'react';
import '../styles/ListeJeux.css'
import Jeu from './Jeu'

function ListeJeux({jeuxPanier, setJeuxPanier}) {

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
    
    function ajouterPanier(id, nom, description, prix) {
        const jeuAjouter = jeuxPanier.find(jeu => jeu.nom === nom)
        if (!jeuAjouter){
            jeuxPanier = [...jeuxPanier, {id, nom, description, prix, qte:1}]
            setJeuxPanier(jeuxPanier);
            
        } else{
           // const newPanier = panier.filter(
           //     jeu => jeu.nom !==nom
           // )
           // setPanier([...newPanier, {id, nom, prix, qte: jeuAjouter.qte +1} ])
        }
    }

    return (
        <div>
            <ul className="liste">
                {listeJeux.map((jeu) => (
                <li className="liste-jeu" key={jeu.id}>
                    <Jeu value={jeu}/>
                    <button onClick={() => ajouterPanier(jeu.id, jeu.nom, jeu.description, jeu.prix)
                    }>Ajouter</button>
                </li>
                ))}
            </ul>
        </div>
    )
}


export default ListeJeux