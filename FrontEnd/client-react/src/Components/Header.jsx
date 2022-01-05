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
        <nav className='mjv-nav'>
            <Link className='mjv-link' to="login">Login</Link>
            <Link className='mjv-link' to="register">Register</Link>
        </nav>
        }
        
       { 
       islogedIn &&
        <nav className='mjv-nav'>
            <Link className='mjv-link' to="user/boutique">Magasin</Link>
            <Link className='mjv-link' to="user/bibliotheque">Bibliotheque</Link>
            <Link className='mjv-link' to="user/compte">Mon Compte</Link>
            <Link className='mjv-link' to="user/logout" onClick={() => {
                sessionStorage.removeItem("username")
                sessionStorage.removeItem("id")
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