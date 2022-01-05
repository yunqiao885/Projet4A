import React from 'react';
import '../styles/App.css';

import { useState } from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import UserApp from './UserApp';
import Header from './Header'
import Login from './Login'
import Error from './Error'
import Register from './Register'

function App() {
  const [islogedIn, setIsLogedIn] = useState(sessionStorage.getItem("username")!==null);
  const [id, setId] = useState(0)
  return (
    <div className="App">
        <Header islogedIn={islogedIn} setIsLogedIn={setIsLogedIn}/>
        <Routes>
          <Route path="/login" element={<AuthenticatedRoute islogedIn={!islogedIn} children={<Login setId={setId} setIsLogedIn={setIsLogedIn} />} other={<Navigate to="/user" />} />} /> 
          <Route path="/register" element={<AuthenticatedRoute islogedIn={!islogedIn} children={<Register setId={setId} setIsLogedIn={setIsLogedIn} />} other={<Navigate to="/user" />} />} /> 
          <Route Route path="/user/*" element={<AuthenticatedRoute islogedIn={islogedIn} children={<UserApp id={id} setId={setId} />} other={<Navigate to="/login" />} />} /> 
          <Route path="*" element={<Error />} />        
        </Routes>
    </div>

  );
}

function AuthenticatedRoute({islogedIn, children, other}){

  if (islogedIn) return children
  else return other
} 
export default App;
