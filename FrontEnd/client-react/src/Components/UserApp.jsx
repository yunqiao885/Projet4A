import React from 'react';
import '../styles/App.css';

import { useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import Compte from './UserComponents/Compte';
import Bibliotheque from './UserComponents/Bibliotheque';
import PaymentApp from './PaymentComponent/PaymentApp';
import Boutique from './UserComponents/Boutique';


function UserApp() {
  const [panier, setPanier] = useState([])
  return (
    <div className="App">
        <Routes>
          <Route path="/boutique" element={<Boutique panier={panier} setPanier={setPanier} />}/>
          <Route path="/paiement" element={<PaymentApp panier={panier} />}/>
          <Route path="/bibliotheque" element={<Bibliotheque />}/>
          <Route path="/compte" element={<Compte />}/>
        </Routes>
    </div>

  );
}

export default UserApp;