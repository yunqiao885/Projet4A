import React, { useEffect, useState } from 'react';
import { Route, Routes, useNavigate } from 'react-router-dom';
import '../styles/ListeJeux.css'
import Jeu from './Jeu'
import JeuInfo from './JeuInfo';

function ListeJeux({jeuxPanier, setJeuxPanier}) {
    let navigate = useNavigate()
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
            <Routes>
            {listeJeux.map((jeu) => (
                    <Route path={("/"+jeu.id)} element={<JeuInfo jeu={jeu}/>}/>
                ))}
            </Routes>
            <ul className="liste">
                {listeJeux.map((jeu) => (
                <li className="liste-jeu" key={("li-"+jeu.id)}>
                    <Jeu value={jeu}/>
                    <button onClick={() => ajouterPanier(jeu.id, jeu.nom, jeu.description, jeu.prix)
                    }>{jeu.prix}€</button>
                    <button onClick={() => navigate("/user/boutique/"+jeu.id)
                    }>Details</button>

                </li>
                ))}
            </ul>
            
        </div>
    )
}


export default ListeJeux