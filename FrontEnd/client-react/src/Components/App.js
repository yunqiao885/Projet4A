import React from 'react';
import '../styles/App.css';

import { useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import UserApp from './UserApp';
import Header from './Header'
import Login from './Login'
import Register from './Register'

function App() {
  const [islogedIn, setIsLogedIn] = useState(false);
  return (
    <div className="App">
        <Header islogedIn={islogedIn} setIsLogedIn={setIsLogedIn}/>
        <Routes>
          <Route path="/login" element={<Login setIsLogedIn={setIsLogedIn} />}/> 
          <Route path="/logout" element={<Login setIsLogedIn={setIsLogedIn} />}/> 
          <Route path="/register" element={<Register />}/>
          <Route path="/user/*" element={<UserApp />} /> 
          <Route path="*" element={<Error />} />        
        </Routes>
    </div>

  );
}

export default App;
