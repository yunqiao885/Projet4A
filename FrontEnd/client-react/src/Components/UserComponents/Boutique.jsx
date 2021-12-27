import React from "react";
import ListeJeux from '../ListeJeux';
import Panier from './Panier';

export default function Boutique({panier, setPanier}) {
    
    return (
        <div>
            <Panier panier={panier} setPanier={setPanier} />
            <ListeJeux panier={panier} setPanier={setPanier} /> 
        </div>
    )
}