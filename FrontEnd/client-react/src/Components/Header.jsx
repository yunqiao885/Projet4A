import React from 'react';
import '../styles/Header.css'
import logo from '../assets/logo.png'
import { Link } from "react-router-dom";

function Header({islogedIn, setIsLogedIn}) {
    const titre = "Magasin de jeu video"
    
    return (
        
    <div className='banner'>
        {
        !islogedIn &&
        <nav>
            <Link to="login">Login</Link>
            <Link to="register">Register</Link>
        </nav>
        }
        
       { 
       islogedIn &&
        <nav>
            <Link to="jeuxBoutique">Magasin</Link>
            <Link to="bibliotheque">Bibliotheque</Link>
            <Link to="compte">Mon Compte</Link>
            <Link to="logout" onClick={() => {
                sessionStorage.removeItem("username")
                setIsLogedIn(false);
            }}>Logout</Link>
        </nav>
        }
        <img src={logo} alt='Magasin du jeu video' className='logo' />
        <h1 className='titre'>{titre}</h1>
        <br/>
        
    </div>
    );
}

export default Header