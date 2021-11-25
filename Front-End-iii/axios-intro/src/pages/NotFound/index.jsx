import { useState, useEffect } from "react";
import { useNavigate } from "react-router"

export default function NotFound(){

    const [ count , setCount] = useState(5);

    const navigate = useNavigate();

    useEffect( () => {
        let time;
        if(count > 1){
            time = setInterval(() => setCount(count - 1), 1000)
        }
        return () => clearInterval(time);
    }, [count])
    

    setTimeout(() => navigate("/"), 5000);

    return (
        <>
            <h1>404 - Not Found</h1>
            <h2>Aguarde: {count}</h2>
        </>
        )
}