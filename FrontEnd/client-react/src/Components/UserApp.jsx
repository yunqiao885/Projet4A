import React from 'react';
import '../styles/App.css';

import { useState, useEffect } from 'react';
import { Routes, Route, Navigate  } from 'react-router-dom';
import Compte from './UserComponents/Compte';
import Bibliotheque from './UserComponents/Bibliotheque';
import PaymentApp from './PaymentComponent/PaymentApp';
import Boutique from './UserComponents/Boutique';


function UserApp({id, setId}) {

  const [user, setUser] = useState({})
  const [panier, setPanier] = useState({})
  const [biblio, setBiblio] = useState({})
  
  useEffect(() => {
    setId(sessionStorage.getItem('id'))
}, [])

  useEffect(() => {
    async function getJoueurInfo() {
        try {
            const response = await fetch("http://localhost:8080/users/"+id)
            const data = await response.json();
            setUser(data);
            setPanier(data.panier)
            setBiblio(data.bibliotheque)
        } catch (error) {
            console.log(error);
        }
    }
    if (id!==0 && id!==null) getJoueurInfo()
}, [id])
  return (
    <div className="App">
        <Routes>
          <Route path="/boutique" element={<Boutique panier={panier} setPanier={setPanier} />}/>
          <Route path="/paiement" element={<PaymentApp panier={panier} />}/>
          <Route path="/bibliotheque" element={<Bibliotheque biblio={biblio} setBiblio={setBiblio} />}/>
          <Route path="/compte" element={<Compte user={user} setUser={setUser} />}/>
          <Route path="/logout" element={<Navigate to="/login" />} /> {/* Revoire la deconnexion qui affiche toujour le menu lorsque le lien est entre sur l'url */}
        </Routes>
        
    </div>

  );
}

export default UserApp;