import '../styles/Banner.css'
import logo from '../assets/logo.png'

function Banner() {
    const titre = "Magasin de jeu video"
    return (
    <div className='banner'>
        <img src={logo} alt='Magasin du jeu video' className='logo' />
        <h1 className='titre'>{titre}</h1>
    </div>
    );
}

export default Banner