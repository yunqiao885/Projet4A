import React, { useState, useEffect } from "react";
import { loadStripe } from "@stripe/stripe-js";
import { Elements } from "@stripe/react-stripe-js";
import CheckoutForm from "./CheckoutForm";

// Make sure to call loadStripe outside of a component’s render to avoid
// recreating the Stripe object on every render.
// This is your test publishable API key.
const stripePromise = loadStripe("pk_test_51Jx3zGE53UCrsTeH4QQXgAv80lSh94JL6r9aweYqqw4fdhV6MCpur5CIXNqQGMGB168ZmlNDdZdmhrXopUuRpRxq00tnTBmUg7");

export default function Porcess({customerId, panier}){

    const [clientSecret, setClientSecret] = useState("");

    useEffect(() => {
    // Create PaymentIntent as soon as the page loads
        fetch("http://localhost:8080/create-payment-intent", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(
            { 
            customerId : customerId,
            jeux : panier.jeux
            })
        })
        .then((res) => res.json())
        .then((data) => setClientSecret(data.clientSecret));
    }, []);

    const appearance = {
        theme: 'stripe',
    };
    const options = {
        clientSecret,
        appearance,
    };

    return (
        <>
        {clientSecret && (
        <Elements options={options} stripe={stripePromise}>
          <CheckoutForm />
        </Elements>
        )}
        </>
    )
}