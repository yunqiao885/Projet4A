import React from "react"
import { useEffect, useState } from "react/cjs/react.development";
import Jeu from "../Jeu";

export default function Bibliotheque({setBiblio}) {

    const [jeuxBiblio, setJeuxBiblio] = useState([])

    useEffect(() => {
        async function getBiblio() {
            try {
                const response = await fetch("http://localhost:8080/biblios/"+sessionStorage.getItem('id'))
                const data = await response.json();
                setBiblio(data)
                setJeuxBiblio(data.jeux)
            } catch (error) {
                console.log(error);
            }
        }
        getBiblio()
    },[])

    return (
        <div>
            <ul className="liste">
                {jeuxBiblio.map((jeu) => (
                <li className="liste-jeu" key={("bi-"+jeu.id)}>
                    <Jeu value={jeu}/>
                    <button>Telecharger/Jouer</button>
                </li>
                ))}
            </ul>
        </div>
    )
}