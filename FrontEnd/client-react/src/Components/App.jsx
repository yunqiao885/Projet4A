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
  return (
    <div className="App">
        <Header islogedIn={islogedIn} setIsLogedIn={setIsLogedIn}/>
        <Routes>
          <Route path="/login" element={<Login setIsLogedIn={setIsLogedIn} />}/> 
          <Route path="/register" element={<Register setIsLogedIn={setIsLogedIn} />}/>
          <Route path="/logout" element={<AuthenticatedRoute 
              islogedIn={islogedIn} 
              children={<Login setIsLogedIn={setIsLogedIn} />} 
              />} 
            /> 
          <Route Route path="/user/*" element={<AuthenticatedRoute islogedIn={islogedIn} children={<UserApp />}/>} /> 
          <Route path="*" element={<Error />} />        
        </Routes>
    </div>

  );
}

function AuthenticatedRoute({islogedIn, children}){

  if (islogedIn) return children
  else return <Navigate to="/login" />
} 
export default App;
