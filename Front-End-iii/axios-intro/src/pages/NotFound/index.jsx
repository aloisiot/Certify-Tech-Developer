import { useState, useEffect } from "react";
import { useNavigate } from "react-router"

export default function NotFound(){

    const [ time , setTime] = useState(5);

    const navigate = useNavigate();

    useEffect( () => {
        let x;
        if(time > 1){
            x = setInterval(() => setTime(time - 1), 1000)
        }
        return () => clearInterval(x);
    }, [time])
    

    setTimeout(() => navigate("/"), 5000);

    return (
        <>
            <h1>404 - Not Found</h1>
            <h2>Aguarde: {time}</h2>
        </>
        )
}