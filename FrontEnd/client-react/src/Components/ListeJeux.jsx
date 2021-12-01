import '../styles/ListeJeux.css'
import { jeuList } from '../data/jeuList'
import Jeu from './Jeu'

function ListeJeux() {
    
    return (
        <>
            <ul className="liste">
                {jeuList.map((jeu) => (
                <li className="liste-jeu" key={jeu.id}>
                    <Jeu value={jeu}/>
                </li>
                ))}
            </ul>
        </>
    )
}

export default ListeJeux