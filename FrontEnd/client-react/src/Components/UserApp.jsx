import React from 'react';
import '../styles/App.css';

import Panier from './Panier';
import { useState } from 'react';
import ListeJeux from './ListeJeux';
import { Routes, Route } from 'react-router-dom';
import Compte from './Compte';
import Bibliotheque from './Bibliotheque';


function UserApp() {
  const [panier, setPanier] = useState([])
  return (
    <div className="App">
          <Routes>
            <Route path="/bibliotheque" element={<Bibliotheque />}/>
            <Route path="/compte" element={<Compte />}/>
          </Routes>
        <Panier panier={panier} setPanier={setPanier} />
        <ListeJeux panier={panier} setPanier={setPanier} />
    </div>

  );
}

export default UserApp;