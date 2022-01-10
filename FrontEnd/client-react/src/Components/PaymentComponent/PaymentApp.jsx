import React from "react";
import "../../styles/PaymentApp.css";
import { Routes, Route } from "react-router-dom";
import Succeded from "./Succeded";
import Porcess from "./Process";

export default function PaymentApp({customerId, panier}) {

  return (
    <div className="PaymentApp">
      <Routes>
        <Route path="/process" element={<Porcess customerId={customerId} panier={panier} />}/>
        <Route path="/succeded" element={<Succeded customerId={customerId} panier={panier} />}/>
      </Routes>
      
    </div>
  );
}